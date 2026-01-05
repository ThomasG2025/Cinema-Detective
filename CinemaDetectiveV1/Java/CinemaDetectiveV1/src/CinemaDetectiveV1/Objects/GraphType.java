package CinemaDetectiveV1.Objects;

public enum GraphType {
    // WORLDWIDE
WW_BOX_YEAR("Worldwide Box by Year"),
WW_BOX_GENRE_YEAR("Worldwide Box by Genre by Year"),
WW_BOX_ORIGINAL_LANGUAGE_YEAR("Worldwide Box by Language by Year"),
WW_BOX_PRODUCTION_COUNTRY_YEAR("Worldwide Box by Country by Year"),
WW_BOX_AVG_GENRE_YEAR("Worldwide Avg Box by Genre by Year"),
WW_BOX_AVG_PRODUCTION_COUNTRY_YEAR("Worldwide Avg Box by Country by Year"),
WW_BOX_AVG_ORIGINAL_LANGUAGE_YEAR("Worldwide Avg Box by Language by Year"),




    // DOMESTIC
DO_BOX_YEAR("Domestic Box by Year"),
DO_BOX_PERCENT_YEAR("Domestic Box Percentage by Year"),
DO_BOX_PERCENT_GENRE_YEAR("Domestic Box Percentage by Genre by Year"),
DO_BOX_PERCENT_ORIGINAL_LANGUAGE_YEAR ("Domestic Box Percentage by Language by Year"),
DO_BOX_PERCENT_PRODUCTION_COUNTRY_YEAR("Domestic Box Percentage by Country by Year"),
DO_BOX_GENRE_YEAR("Domestic Box by Genre by Year"),
DO_BOX_ORIGINAL_LANGUAGE_YEAR("Domestic Box by Language by Year"),
DO_BOX_PRODUCTION_COUNTRY_YEAR("Domestic Box by Country by Year"),
DO_BOX_AVG_GENRE_YEAR("Domestic Box Avg by Genre by Year"),
DO_BOX_AVG_PRODUCTION_COUNTRY_YEAR("Domestic Box Avg by Country by Year"),
DO_BOX_AVG_ORIGINAL_LANGUAGE_YEAR("Domestic Box Avg by Language by Year"),


// FOREIGN
FO_BOX_YEAR("Foreign Box by Year"),
FO_BOX_PERCENT_YEAR("Foreign Box Percentage by Year"),
FO_BOX_PERCENT_GENRE_YEAR("Foreign Box Percentage by Genre by Year"),
FO_BOX_PERCENT_PRODUCTION_COUNTRY_YEAR("Foreign Box Percentage by Country by Year"),
FO_BOX_PERCENT_ORIGINAL_LANGUAGE("Foreign Box Percentage by Language by Year"),
FO_BOX_GENRE_YEAR("Foreign Box by Genre by Year"),
FO_BOX_PRODUCTION_COUNTRY_YEAR("Foreign Box by Country by Year"),
FO_BOX_ORIGINAL_LANGUAGE_YEAR("Foreign Box by Language by Year"),
FO_BOX_AVG_GENRE_YEAR("Foreign Box Avg by Genre by Year"),
FO_BOX_AVG_PRODUCTION_COUNTRY("Foreign Box Avg by Country by Year"),
FO_BOX_AVG_ORIGINAL_LANGUAGE_YEAR("Foreign Box Avg by Language by Year"),

// MISC
MI_GENRE_COUNTRY("Genre by Country by Year"),
MI_GENRE_YEAR("Genre by Year"),
MI_GENRE_ORIGINAL_LANGUAGE("Genre by Language by Year"),
MI_AVG_RATING_GENRE_YEAR("Avg Rating by Genre by Year"),
MI_AVG_RATING_YEAR("Avg Rating by Year"),
MI_AVG_RATING_PRODUCTION_COUNTRY("Avg Rating by Country by Year"),
MI_VOTE_COUNT_YEAR("Vote Count by Year"),
MI_PRODUCTION_COUNTRY_YEAR("Country by Year"),
MI_PRODUCTION_COUNTRY_ORIGINAL_LANGUAGE_YEAR("Country by Language by Year");




    private final String displayName;

    GraphType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }








}
