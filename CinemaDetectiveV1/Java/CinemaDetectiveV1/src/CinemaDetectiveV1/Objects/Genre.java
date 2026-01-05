package CinemaDetectiveV1.Objects;

public enum Genre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    ANIMATION("Animation"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FANTASY("Fantasy"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science_Fiction"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western"),
    ALL("All");


    private final String genreName;

    Genre(String genreName){
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return genreName;
    }

}
