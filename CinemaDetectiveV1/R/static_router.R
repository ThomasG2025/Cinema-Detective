





requires_dynamic <- function(graph_type) {
  grepl("GENRE|LANGUAGE|PRODUCTION", graph_type)
}







log_pipeline <- function(msg) {
  cat(sprintf("[R][STATIC_ROUTER] %s\n", msg))
}


render_version2_placeholder <- function(
    graph_type,
    output_dir,
    filename = NULL
) {
  if (is.null(filename)) {
    filename <- paste0(graph_type, "_PLACEHOLDER.png")
  }
  
  message_df <- data.frame(
    Message = c(
      paste("Graph:", graph_type),
      "",
      "This visualization is available in Version 2.",
      "Version 2 introduces dynamic filtering logic.",
      "",
      "Current Version: Static (Version 1)"
    ),
    stringsAsFactors = FALSE
  )
  
  save_table_as_png(
    message_df,
    filename = filename,
    output_dir
  )
  
  return(file.path(output_dir, filename))
}








select_pre_defined_graphs_static <- function(
    dataset_original,
    dataset_expanded,
    selections,
    output_dir
) {
  
  # -------------------------------
  # Version 1 capability enforcement
  # -------------------------------
  graph_type <- selections$enums_df |>
    dplyr::filter(category == "GraphType") |>
    dplyr::pull(value) |>
    unique()
  
  if (length(graph_type) != 1) {
    stop("Static router expects exactly one GraphType")
  }
  
  graph_type <- graph_type[[1]]
  
  # Version 1 boundary rule
  if (requires_dynamic(graph_type)) {
    return(
      render_version2_placeholder(
        graph_type = graph_type,
        output_dir = output_dir
      )
    )
  }
  
  # -------------------------------
  # Version 1 dispatch table
  # -------------------------------
  dispatch <- list(
    
    # Worldwide selections
    
    WW_BOX_YEAR = function() {
      plot_WW_Box_By_Year(dataset_original, output_dir)
    },

    DO_BOX_YEAR = function() {
      plot_DOM_Box_By_Year(dataset_original, output_dir)
    },
    
    DO_BOX_PERCENT_YEAR = function() {
      plot_DOM_Box_Percent_By_Year(dataset_original, output_dir)
    },
    
    
    FO_BOX_YEAR = function() {
      plot_FO_Box_By_Year(dataset_original, output_dir)
    },
    
    
    FO_BOX_PERCENT_YEAR = function() {
      plot_FO_Box_Percent_By_Year(dataset_original, output_dir)
    },
    MI_VOTE_COUNT_YEAR = function() {
      plot_MISC_vote_count_by_year(dataset_original, output_dir)
    },
    MI_AVG_RATING_YEAR = function() {
      plot_MISC_avg_rating_by_year(dataset_original, output_dir)
    }
    
    
    
  )
  
  if (!graph_type %in% names(dispatch)) {
    stop(paste("No static handler registered for:", graph_type))
  }
  
  dispatch[[graph_type]]()
}


