package CinemaDetectiveV1.Objects;

public enum productionCountry {
    ALGERIA("Algeria"),
    ARGENTINA("Argentina"),
    AUSTRALIA("Australia"),
    AUSTRIA("Austria"),
    BAHAMAS("Bahamas"),
    BELGIUM("Belgium"),
    BRAZIL("Brazil"),
    BULGARIA("Bulgaria"),
    CAMBODIA("Cambodia"),
    CANADA("Canada"),
    CHILE("Chile"),
    CHINA("China"),
    CZECH_REPUBLIC("Czech Republic"),
    DENMARK("Denmark"),
    DOMINICAN_REPUBLIC("Dominican Republic"),
    ECUADOR("Ecuador"),
    ESTONIA("Estonia"),
    FINLAND("Finland"),
    FRANCE("France"),
    GERMANY("Germany"),
    GREECE("Greece"),
    HONG_KONG("Hong Kong"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    INDIA("India"),
    INDONESIA("Indonesia"),
    IRAN("Iran"),
    IRELAND("Ireland"),
    ITALY("Italy"),
    JAPAN("Japan"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MEXICO("Mexico"),
    MOROCCO("Morocco"),
    NETHERLANDS("Netherlands"),
    NEW_ZEALAND("New Zealand"),
    NIGERIA("Nigeria"),
    NORWAY("Norway"),
    PAKISTAN("Pakistan"),
    PERU("Peru"),
    PHILIPPINES("Philippines"),
    POLAND("Poland"),
    ROMANIA("Romania"),
    RUSSIA("Russia"),
    SINGAPORE("Singapore"),
    SLOVAKIA("Slovakia"),
    SOUTH_AFRICA("South Africa"),
    SOUTH_KOREA("South Korea"),
    SPAIN("Spain"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    TAIWAN("Taiwan"),
    THAILAND("Thailand"),
    TURKEY("Turkey"),
    UKRAINE("Ukraine"),
    UAE("United Arab Emirates"),
    UK("United Kingdom"),
    USA("United States"),
    ALL("All");  // Represents "select all"

    private final String displayName;

    productionCountry(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
