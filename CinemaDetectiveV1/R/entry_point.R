cat(">>> ENTRY POINT STARTED\n")

source("loader.R")          # defines main(), load_from_java(), etc
source("Graph Creation.R")  # defines plot_WW_Box_By_Year()
source("static_router.R")   # uses log_pipeline + plot_* functions

cat(">>> All pipeline files sourced\n")



cat(">>> ENTRY POINT FINISHED\n")
main()