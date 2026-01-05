
save_table_as_png <- function(df, filename, output_dir = "mailbox/visuals") {
  if(!dir.exists(output_dir)) dir.create(output_dir, recursive = TRUE)
  table_grob <- gridExtra::tableGrob(df, rows = NULL, theme = gridExtra::ttheme_minimal(base_size = 9))
  output_path <- file.path(output_dir, filename)
  png(filename = output_path, width = 1400, height = 900, res = 150)
  grid::grid.newpage()
  grid::grid.draw(table_grob)
  dev.off()
  return(output_path)
}

save_plot_as_png <- function(plot, filename, output_dir = "mailbox/visuals") {
  if(!dir.exists(output_dir)) dir.create(output_dir, recursive = TRUE)
  output_path <- file.path(output_dir, filename)
  ggsave(filename = output_path, plot = plot, width = 10, height = 6, dpi = 300)
  return(output_path)
}


load_libraries <- function() {
  library(jsonlite)
  library(tidyverse)
  library(readr)
  library(scales)
  library(ggplot2)
  library(gridExtra)
  library(grid)
}


load_from_java <- function() {
  
  MAILBOX_IN  <- Sys.getenv("R_MAILBOX_IN")
  MAILBOX_OUT <- Sys.getenv("R_MAILBOX_OUT")
  MAILBOX_VISUALS <- file.path(MAILBOX_OUT, "visuals")
  dir.create(MAILBOX_VISUALS, showWarnings = FALSE, recursive = TRUE)
  
  if (MAILBOX_IN == "" || MAILBOX_OUT == "") {
    stop("R mailbox environment variables not set by Java")
  }
  
  dataset_path <- file.path(MAILBOX_IN, "dataset.json")
  selections_path <- file.path(MAILBOX_IN, "selections.json")
  
  if (!file.exists(dataset_path)) {
    stop(paste("Dataset file not found:", dataset_path))
  }
  
  if (!file.exists(selections_path)) {
    stop(paste("Selections file not found:", selections_path))
  }
  
  message("✔ Mailbox paths verified")
  message("✔ Dataset path: ", dataset_path)
  message("✔ Selections path: ", selections_path)
  
  dataset <- load_dataset(dataset_path)
  
  
  list(
    dataset        = dataset,
    mailbox_in     = MAILBOX_IN,
    mailbox_out    = MAILBOX_OUT,
    mailbox_visuals = MAILBOX_VISUALS
  )
}



options(scipen = 999)


coerce_numeric_safe <- function(x) {
  as.numeric(gsub("[^0-9.-]", "", x))
}

load_dataset <- function(json_path){
  
  cinema_Data <- fromJSON(json_path, flatten = TRUE) %>% as.data.frame()
  
  
  money_cols <- c("$Worldwide", "$Domestic", "$Foreign")
  existing_money_cols <- intersect(money_cols, names(cinema_Data))
  
  cinema_Data <- cinema_Data %>%
    mutate(across(all_of(existing_money_cols), coerce_numeric_safe))
  
  # ---- NORMALIZE PERCENT COLUMNS ----
  percent_cols <- c("Domestic %", "Foreign %")
  existing_percent_cols <- intersect(percent_cols, names(cinema_Data))
  
  if (length(existing_percent_cols) > 0) {
    cinema_Data <- cinema_Data %>%
      mutate(
        across(
          all_of(existing_percent_cols),
          ~ as.numeric(gsub("%", "", .)) / 100
        )
      )
  }
  
  if ("Vote_Count" %in% names(cinema_Data)) {
    cinema_Data <- cinema_Data %>%
      mutate(
        Vote_Count = as.numeric(gsub(",", "", Vote_Count))
      )
  }
  
  
  if("Rating" %in% names(cinema_Data)){
    cinema_Data <- cinema_Data %>%
      mutate(Rating = as.numeric(sub("/10","", Rating)))
  }
  
  cinema_Data_Original <- cinema_Data
  
  cinema_Data_Expanded <- cinema_Data %>%
    mutate(
      Genres = stringr::str_trim(Genres),
      Production_Countries = stringr::str_trim(Production_Countries),
      Original_Language = stringr::str_trim(Original_Language)
    ) %>%
    separate_rows(Genres, sep = ",") %>%
    separate_rows(Production_Countries, sep = ",") %>%
    separate_rows(Original_Language, sep = ",")
  
  list(
    original = cinema_Data_Original,
    tidy     = cinema_Data_Expanded
  )
}


main <- function() {
  cat("[R][PIPELINE] main() start\n")
  
  load_libraries()
  cat("[R][PIPELINE] libraries loaded\n")
  
  inputs <- load_from_java()
  cat("[R][PIPELINE] dataset + selections loaded\n")
  
  # ✅ NORMALIZE selections here
  selections_norm <- load_filters(
    file.path(inputs$mailbox_in, "selections.json")
  )
  
  output_file <- select_pre_defined_graphs_static(
    dataset_original = inputs$dataset$original,
    dataset_expanded = inputs$dataset$expanded,
    selections       = selections_norm,
    output_dir       = inputs$mailbox_visuals
  )
  
  
  
  cat("[R][PIPELINE] output written to:", output_file, "\n")
  cat("[R][PIPELINE] done\n")
}







#chatgpt showed me how to do this

 

## AI(Chatgpt) generated the import json function and json normalization

json_path <- "selections.json"
load_filters <- function(json_path) {
  json_data <- fromJSON(json_path)
  
  # ---- ENUMS ----
  enums <- json_data[names(json_data) != "Sliders"]
  
  enums_df <- bind_rows(
    lapply(names(enums), function(enum_name) {
      
      values <- unlist(enums[[enum_name]])
      
      # ✅ Skip empty selections
      if (length(values) == 0) {
        return(NULL)
      }
      
      data.frame(
        category = enum_name,
        value = values,
        stringsAsFactors = FALSE
      )
    })
  )
  
  # Guarantee enums_df exists even if all enums are empty
  if (is.null(enums_df) || nrow(enums_df) == 0) {
    enums_df <- data.frame(
      category = character(),
      value = character(),
      stringsAsFactors = FALSE
    )
  }
  
  # ---- NUMERIC SLIDERS ----
  numeric_selections <- json_data$Sliders
  
  nums_df <- data.frame(
    slider = names(numeric_selections),
    value = as.numeric(unlist(numeric_selections)),
    stringsAsFactors = FALSE
  )
  
  # Optional: reorder sliders
  slider_order <- c(
    "WW_Box_Low", "WW_Box_High",
    "Dom_Box_Low", "Dom_Box_High",
    "Fore_Box_Low", "Fore_Box_High",
    "Dom_Percentage_Box_Low", "Dom_Percentage_Box_High",
    "Fore_Percentage_Box_Low", "Fore_Percentage_Box_High",
    "Rating_Slider_Low", "Rating_Slider_High",
    "VC_Slider_Low", "VC_Slider_High"
  )
  
  nums_df$slider <- factor(nums_df$slider, levels = slider_order)
  
  list(
    enums_df = enums_df,
    nums_df  = nums_df
  )
}


load_inputs <- function(dataset_path,selections_path){
  list(
  datasets = load_dataset(dataset_path),
  selections = load_filters(selections_path)
  )
}
  

