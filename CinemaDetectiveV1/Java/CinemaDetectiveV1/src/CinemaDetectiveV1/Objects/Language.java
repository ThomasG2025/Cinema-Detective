package CinemaDetectiveV1.Objects;

public enum Language {
    AR("Ar"),
    CN("Cn"),
    CS("Cs"),
    DA("Da"),
    DE("De"),
    EL("El"),
    EN("En"),
    ES("Es"),
    ET("Et"),
    FA("Fa"),
    FI("Fi"),
    FR("Fr"),
    HR("Hr"),
    ID("Id"),
    IT("It"),
    JA("Ja"),
    KN("Kn"),
    KO("Ko"),
    ML("Ml"),
    NL("Nl"),
    NO("No"),
    PA("Pa"),
    PL("Pl"),
    PT("Pt"),
    RU("Ru"),
    SR("Sr"),
    SV("Sv"),
    TA("Ta"),
    TE("Te"),
    TH("Th"),
    TL("Tl"),
    TR("Tr"),
    UK("Uk"),
    VI("Vi"),
    ZH("Zh"),
    ALL("All");


    private final String languageName;


    Language(String languageName){
        this.languageName = languageName;

    }

    @Override
    public String toString() {
        return languageName;
    }









}
