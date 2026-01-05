plot_WW_Box_By_Year <- function(data, output_dir) {
  summarised <- data %>%
    group_by(Year) %>%
    summarise(Value = sum(`$Worldwide`, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(summarised, aes(x = Year, y = Value, fill = Value)) +
    geom_col() +
    scale_y_continuous(labels = comma) +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Worldwide Box Office by Year")
  
  save_plot_as_png(p,"WW_BOX_YEAR_PLOT.png", output_dir)
  return(output_dir)
}


# Worldwide by Genre Table

plot_DOM_Box_By_Year <- function(data, output_dir) {
  summarised <- data %>%
    group_by(Year) %>%
    summarise(`$Domestic` = sum(`$Domestic`, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(summarised, aes(x = Year, y = `$Domestic`, fill = `$Domestic`)) +
    geom_col() +
    scale_y_continuous(labels = scales::comma) +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Domestic Box Office by Year")
  
  save_plot_as_png(p,"WW_BOX_YEAR_PLOT.png", output_dir)
  
  return(output_dir)
}



plot_DOM_Box_Percent_By_Year <- function(data, output_dir){
  summarised <- data %>%
    group_by(Year) %>%
    summarise(`Domestic %` = mean(`Domestic %`, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(summarised, aes(x = Year, y = `Domestic %`, fill = `Domestic %`)) +
    geom_col() +
    scale_y_continuous(labels = scales::percent_format()) +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Domestic Percentage by Year")
  
  save_plot_as_png(p,"WW_BOX_YEAR_PLOT.png", output_dir)
  
  return(output_dir)
}


plot_FO_Box_By_Year <- function(data, output_dir) {
  df <- data %>%
    group_by(Year) %>%
    summarise(Foreign = sum(`$Foreign`, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(df, aes(x = Year, y = Foreign, fill = Foreign)) +
    geom_col() +
    scale_y_continuous(labels = comma) +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Foreign Box Office by Year")
  
  
  
  save_plot_as_png(p,"WW_BOX_YEAR_PLOT.png", output_dir)
  
  return(output_dir)
}

plot_FO_Box_Percent_By_Year <- function(data, output_dir) {
  df <- data %>%
    group_by(Year) %>%
    summarise(ForeignPct = mean(`Foreign %`, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(df, aes(x = Year, y = ForeignPct, fill = ForeignPct)) +
    geom_col() +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Foreign % of Box Office by Year")
  
  save_plot_as_png(p, "FO_BOX_PERCENT_YEAR_PLOT.png", output_dir)
  
  return(output_dir)
}


plot_MISC_avg_rating_by_year <- function(data, output_dir) {
  summarised <- data %>%
    group_by(Year) %>%
    summarise(Rating = mean(Rating, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(summarised, aes(x = Year, y = Rating, fill = Rating)) +
    geom_col() +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Average Rating by Year")
  
  save_plot_as_png(p,"MISC_AVG_RATING_YEAR_PLOT.png", output_dir)
  return(output_dir)
}


plot_MISC_vote_count_by_year <- function(data, output_dir) {
  summarised <- data %>%
    group_by(Year) %>%
    summarise(Vote_Count = sum(Vote_Count, na.rm = TRUE), .groups = "drop")
  
  p <- ggplot(summarised, aes(x = Year, y = Vote_Count, fill = Vote_Count)) +
    geom_col() +
    scale_y_continuous(labels = comma) +
    theme_minimal() +
    theme(legend.position = "none") +
    ggtitle("Vote Count by Year")
  
  save_plot_as_png(p,"MISC_VOTE_COUNT_YEAR_PLOT.png", output_dir)
  return(output_dir)
}









