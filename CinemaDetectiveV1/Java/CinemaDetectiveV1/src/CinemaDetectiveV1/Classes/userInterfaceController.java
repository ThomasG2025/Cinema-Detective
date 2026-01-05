package CinemaDetectiveV1.Classes;

import CinemaDetectiveV1.Objects.*;
import CinemaDetectiveV1.Objects.SelectionPasser.Range;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class userInterfaceController implements Initializable {


    @FXML public StackPane image_Pane;
    @FXML public ImageView graph_View;
    @FXML public Button load_Dataset_Button;
    private List<SliderInfo> sliders;

    // -------------------- SELECTION PASSER --------------------
    private final SelectionPasser passer = new SelectionPasser();

    // Box office Sliders

    @FXML private Slider worldwide_Box_Low_Slider;
    @FXML private Slider worldwide_Box_High_Slider;
    @FXML private Slider domestic_Box_Low_Slider;
    @FXML private Slider domestic_Box_High_Slider;
    @FXML private Slider foreign_Box_Low_Slider;
    @FXML private Slider foreign_Box_High_Slider;
    @FXML private Slider domestic_Percent_Box_Low_Slider;
    @FXML private Slider domestic_Percent_Box_High_Slider;
    @FXML private Slider foreign_Percent_Box_Low_Slider;
    @FXML private Slider foreign_Percent_Box_High_Slider;
    @FXML private Slider rating_Low_Slider;
    @FXML private Slider rating_High_Slider;
    @FXML private Slider vote_Count_Low_Slider;
    @FXML private Slider vote_Count_High_Slider;



    // Box office labels

    @FXML private Label worldwide_Box_Low_Value_Display;
    @FXML private Label worldwide_Box_High_Value_Display;
    @FXML private Label domestic_Box_Low_Value_Display;
    @FXML private Label domestic_Box_High_Value_Display;
    @FXML private Label domestic_Percent_Box_Low_Value_Display;
    @FXML private Label domestic_Percent_Box_High_Value_Display;
    @FXML private Label foreign_Box_Low_Value_Display;
    @FXML private Label foreign_Box_High_Value_Display;
    @FXML private Label foreign_Percent_Box_Low_Value_Display;
    @FXML private Label foreign_Percent_Box_High_Value_Display;
    @FXML private Label rating_Low_Value_Display;
    @FXML private Label rating_High_Value_Display;
    @FXML private Label vote_Count_Low_Value_Display;
    @FXML private Label vote_Count_High_Value_Display;


    // -------------------- YEARS --------------------
    @FXML private CheckBox year_2000_Box;
    @FXML private CheckBox year_2001_Box;
    @FXML private CheckBox year_2002_Box;
    @FXML private CheckBox year_2003_Box;
    @FXML private CheckBox year_2004_Box;
    @FXML private CheckBox year_2005_Box;
    @FXML private CheckBox year_2006_Box;
    @FXML private CheckBox year_2007_Box;
    @FXML private CheckBox year_2008_Box;
    @FXML private CheckBox year_2009_Box;
    @FXML private CheckBox year_2010_Box;
    @FXML private CheckBox year_2011_Box;
    @FXML private CheckBox year_2012_Box;
    @FXML private CheckBox year_2013_Box;
    @FXML private CheckBox year_2014_Box;
    @FXML private CheckBox year_2015_Box;
    @FXML private CheckBox year_2016_Box;
    @FXML private CheckBox year_2017_Box;
    @FXML private CheckBox year_2018_Box;
    @FXML private CheckBox year_2019_Box;
    @FXML private CheckBox year_2020_Box;
    @FXML private CheckBox year_2021_Box;
    @FXML private CheckBox year_2022_Box;
    @FXML private CheckBox year_2023_Box;
    @FXML private CheckBox year_2024_Box;
    @FXML private CheckBox year_All_Box;

    // -------------------- GENRES --------------------
    @FXML private CheckBox genre_Action_Box;
    @FXML private CheckBox genre_Adventure_Box;
    @FXML private CheckBox genre_Animation_Box;
    @FXML private CheckBox genre_Comedy_Box;
    @FXML private CheckBox genre_Crime_Box;
    @FXML private CheckBox genre_Documentary_Box;
    @FXML private CheckBox genre_Drama_Box;
    @FXML private CheckBox genre_Family_Box;
    @FXML private CheckBox genre_Fantasy_Box;
    @FXML private CheckBox genre_History_Box;
    @FXML private CheckBox genre_Horror_Box;
    @FXML private CheckBox genre_Music_Box;
    @FXML private CheckBox genre_Mystery_Box;
    @FXML private CheckBox genre_Romance_Box;
    @FXML private CheckBox genre_Science_Fiction_Box;
    @FXML private CheckBox genre_Thriller_Box;
    @FXML private CheckBox genre_War_Box;
    @FXML private CheckBox genre_Western_Box;
    @FXML private CheckBox genre_All_Box;

    // -------------------- LANGUAGES --------------------
    @FXML private CheckBox o_Language_Ar_Box;
    @FXML private CheckBox o_Language_Cn_Box;
    @FXML private CheckBox o_Language_Cs_Box;
    @FXML private CheckBox o_Language_Da_Box;
    @FXML private CheckBox o_Language_De_Box;
    @FXML private CheckBox o_Language_El_Box;
    @FXML private CheckBox o_Language_En_Box;
    @FXML private CheckBox o_Language_Es_Box;
    @FXML private CheckBox o_Language_Et_Box;
    @FXML private CheckBox o_Language_Fa_Box;
    @FXML private CheckBox o_Language_Fi_Box;
    @FXML private CheckBox o_Language_Fr_Box;
    @FXML private CheckBox o_Language_Hr_Box;
    @FXML private CheckBox o_Language_Id_Box;
    @FXML private CheckBox o_language_It_Box;
    @FXML private CheckBox o_Language_Ja_Box;
    @FXML private CheckBox o_Language_Kn_Box;
    @FXML private CheckBox o_Language_Ko_Box;
    @FXML private CheckBox o_Language_Ml_Box;
    @FXML private CheckBox o_Language_Nl_Box;
    @FXML private CheckBox o_Language_No_Box;
    @FXML private CheckBox o_Language_Pa_Box;
    @FXML private CheckBox o_Language_Pl_Box;
    @FXML private CheckBox o_Language_Pt_Box;
    @FXML private CheckBox o_Language_Ru_Box;
    @FXML private CheckBox o_Language_Sr_Box;
    @FXML private CheckBox o_Language_Sv_Box;
    @FXML private CheckBox o_Language_Ta_Box;
    @FXML private CheckBox o_Language_Te_Box;
    @FXML private CheckBox o_Language_Th_Box;
    @FXML private CheckBox o_Language_Tl_Box;
    @FXML private CheckBox o_Language_Tr_Box;
    @FXML private CheckBox o_Language_Uk_Box;
    @FXML private CheckBox o_Language_Vi_Box;
    @FXML private CheckBox o_Language_Zh_Box;
    @FXML private CheckBox o_Language_All_Box;

    // -------------------- PRODUCTION COUNTRIES --------------------
    @FXML private CheckBox pro_Co_Algeria_Box;
    @FXML private CheckBox pro_Co_Argentina_Box;
    @FXML private CheckBox pro_Co_Australia_Box;
    @FXML private CheckBox pro_Co_Austria_Box;
    @FXML private CheckBox pro_Co_Bahamas_Box;
    @FXML private CheckBox pro_Co_Belgium_Box;
    @FXML private CheckBox pro_Co_Brazil_Box;
    @FXML private CheckBox pro_Co_Bulgaria_Box;
    @FXML private CheckBox pro_Co_Cambodia_Box;
    @FXML private CheckBox pro_Co_Canada_Box;
    @FXML private CheckBox pro_Co_Chile_Box;
    @FXML private CheckBox pro_Co_China_Box;
    @FXML private CheckBox pro_Co_Czech_Republic_Box;
    @FXML private CheckBox pro_Co_Denmark_Box;
    @FXML private CheckBox pro_Co_Dominican_Republic_Box;
    @FXML private CheckBox pro_Co_Ecuador_Box;
    @FXML private CheckBox pro_Co_Estonia_Box;
    @FXML private CheckBox pro_Co_Finland_Box;
    @FXML private CheckBox pro_Co_France_Box;
    @FXML private CheckBox pro_Co_Germany_Box;
    @FXML private CheckBox pro_Co_Greece_Box;
    @FXML private CheckBox pro_Co_Hong_Kong_Box;
    @FXML private CheckBox pro_Co_Hungary_Box;
    @FXML private CheckBox pro_Co_Iceland_Box;
    @FXML private CheckBox pro_Co_India_Box;
    @FXML private CheckBox pro_Co_Indonesia_Box;
    @FXML private CheckBox pro_Co_Iran_Box;
    @FXML private CheckBox pro_Co_Ireland_Box;
    @FXML private CheckBox pro_Co_Italy_Box;
    @FXML private CheckBox pro_Co_Japan_Box;
    @FXML private CheckBox pro_Co_Lithuania_Box;
    @FXML private CheckBox pro_Co_Luxembourg_Box;
    @FXML private CheckBox pro_Co_Mexico_Box;
    @FXML private CheckBox pro_Co_Morocco_Box;
    @FXML private CheckBox pro_Co_Netherlands_Box;
    @FXML private CheckBox pro_Co_New_Zealand_Box;
    @FXML private CheckBox pro_Co_Nigeria_Box;
    @FXML private CheckBox pro_Co_Norway_Box;
    @FXML private CheckBox pro_Co_Pakistan_Box;
    @FXML private CheckBox pro_Co_Peru_Box;
    @FXML private CheckBox pro_Co_Philippines_Box;
    @FXML private CheckBox pro_Co_Poland_Box;
    @FXML private CheckBox pro_Co_Romania_Box;
    @FXML private CheckBox pro_Co_Russia_Box;
    @FXML private CheckBox pro_Co_Singapore_Box;
    @FXML private CheckBox pro_Co_Slovakia_Box;
    @FXML private CheckBox pro_Co_South_Africa_Box;
    @FXML private CheckBox pro_Co_South_Korea_Box;
    @FXML private CheckBox pro_Co_Spain_Box;
    @FXML private CheckBox pro_Co_Sweden_Box;
    @FXML private CheckBox pro_Co_Switzerland_Box;
    @FXML private CheckBox pro_Co_Taiwan_Box;
    @FXML private CheckBox pro_Co_Thailand_Box;
    @FXML private CheckBox pro_Co_Turkey_Box;
    @FXML private CheckBox pro_Co_Ukraine_Box;
    @FXML private CheckBox pro_Co_UAE_Box;
    @FXML private CheckBox pro_Co_UK_Box;
    @FXML private CheckBox pro_Co_USA_Box;
    @FXML private CheckBox pro_Co_All_Box;


    @FXML private ChoiceBox <GraphType> graph_CBox;


// Ranges

    private static final Range WORLD_WIDE_BOX_RANGE_LOW = new Range(1666028,2799439100L);
    private static final Range WORLD_WIDE_BOX_RANGE_HIGH = new Range(1666028,2799439100L);
    private static final Range DOMESTIC_BOX_RANGE_LOW = new Range(0,936662225);
    private static final Range DOMESTIC_BOX_RANGE_HIGH = new Range(0,936662225);
    private static final Range FOREIGN_BOX_RANGE_LOW = new Range(0,1993811448);
    private static final Range FOREIGN_BOX_RANGE_HIGH = new Range(0,1993811448);
    private static final Range DOMESTIC_BOX_PERCENT_RANGE_LOW = new Range(0,100);
    private static final Range DOMESTIC_BOX_PERCENT_RANGE_HIGH = new Range(0,100);
    private static final Range FOREIGN_BOX_PERCENT_RANGE_LOW = new Range(0,100);
    private static final Range FOREIGN_BOX_PERCENT_RANGE_HIGH = new Range(0,100);
    private static final Range RATING_RANGE_LOW = new Range(0, 10);
    private static final Range RATING_RANGE_HIGH = new Range(0, 10);
    private static final Range VOTE_COUNT_RANGE_LOW = new Range(0,36753);
    private static final Range VOTE_COUNT_RANGE_HIGH = new Range(0,36753);

    // Cinema Detective Mail System instance

    private CDMS cdms;

    @FXML private Button queryButton;





    // -------------------- MAPS --------------------
    private Map<CheckBox, Year> yearMap;
    private Map<CheckBox, Genre> genreMap;
    private Map<CheckBox, Language> languageMap;
    private Map<CheckBox, productionCountry> countryMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // -------------------- INITIALIZE MAPS --------------------
        yearMap = Map.ofEntries(
                Map.entry(year_2000_Box , Year.Y2000) ,
                Map.entry(year_2001_Box , Year.Y2001) ,
                Map.entry(year_2002_Box , Year.Y2002) ,
                Map.entry(year_2003_Box , Year.Y2003) ,
                Map.entry(year_2004_Box , Year.Y2004) ,
                Map.entry(year_2005_Box , Year.Y2005) ,
                Map.entry(year_2006_Box , Year.Y2006) ,
                Map.entry(year_2007_Box , Year.Y2007) ,
                Map.entry(year_2008_Box , Year.Y2008) ,
                Map.entry(year_2009_Box , Year.Y2009) ,
                Map.entry(year_2010_Box , Year.Y2010) ,
                Map.entry(year_2011_Box , Year.Y2011) ,
                Map.entry(year_2012_Box , Year.Y2012) ,
                Map.entry(year_2013_Box , Year.Y2013) ,
                Map.entry(year_2014_Box , Year.Y2014) ,
                Map.entry(year_2015_Box , Year.Y2015) ,
                Map.entry(year_2016_Box , Year.Y2016) ,
                Map.entry(year_2017_Box , Year.Y2017) ,
                Map.entry(year_2018_Box , Year.Y2018) ,
                Map.entry(year_2019_Box , Year.Y2019) ,
                Map.entry(year_2020_Box , Year.Y2020) ,
                Map.entry(year_2021_Box , Year.Y2021) ,
                Map.entry(year_2022_Box , Year.Y2022) ,
                Map.entry(year_2023_Box , Year.Y2023) ,
                Map.entry(year_2024_Box , Year.Y2024) ,
                Map.entry(year_All_Box , Year.ALL)
        );


        genreMap = Map.ofEntries(
                Map.entry(genre_Action_Box, Genre.ACTION),
                Map.entry(genre_Adventure_Box, Genre.ADVENTURE),
                Map.entry(genre_Animation_Box, Genre.ANIMATION),
                Map.entry(genre_Comedy_Box, Genre.COMEDY),
                Map.entry(genre_Crime_Box, Genre.CRIME),
                Map.entry(genre_Documentary_Box, Genre.DOCUMENTARY),
                Map.entry(genre_Drama_Box, Genre.DRAMA),
                Map.entry(genre_Family_Box, Genre.FAMILY),
                Map.entry(genre_Fantasy_Box, Genre.FANTASY),
                Map.entry(genre_History_Box, Genre.HISTORY),
                Map.entry(genre_Horror_Box, Genre.HORROR),
                Map.entry(genre_Music_Box, Genre.MUSIC),
                Map.entry(genre_Mystery_Box, Genre.MYSTERY),
                Map.entry(genre_Romance_Box, Genre.ROMANCE),
                Map.entry(genre_Science_Fiction_Box, Genre.SCIENCE_FICTION),
                Map.entry(genre_Thriller_Box, Genre.THRILLER),
                Map.entry(genre_War_Box, Genre.WAR),
                Map.entry(genre_Western_Box, Genre.WESTERN),
                Map.entry(genre_All_Box, Genre.ALL)
        );

        languageMap = Map.ofEntries(
                Map.entry(o_Language_Ar_Box, Language.AR),
                Map.entry(o_Language_Cn_Box, Language.CN),
                Map.entry(o_Language_Cs_Box, Language.CS),
                Map.entry(o_Language_Da_Box, Language.DA),
                Map.entry(o_Language_De_Box, Language.DE),
                Map.entry(o_Language_El_Box, Language.EL),
                Map.entry(o_Language_En_Box, Language.EN),
                Map.entry(o_Language_Es_Box, Language.ES),
                Map.entry(o_Language_Et_Box, Language.ET),
                Map.entry(o_Language_Fa_Box, Language.FA),
                Map.entry(o_Language_Fi_Box, Language.FI),
                Map.entry(o_Language_Fr_Box, Language.FR),
                Map.entry(o_Language_Hr_Box, Language.HR),
                Map.entry(o_Language_Id_Box, Language.ID),
                Map.entry(o_language_It_Box, Language.IT),
                Map.entry(o_Language_Ja_Box, Language.JA),
                Map.entry(o_Language_Kn_Box, Language.KN),
                Map.entry(o_Language_Ko_Box, Language.KO),
                Map.entry(o_Language_Ml_Box, Language.ML),
                Map.entry(o_Language_Nl_Box, Language.NL),
                Map.entry(o_Language_No_Box, Language.NO),
                Map.entry(o_Language_Pa_Box, Language.PA),
                Map.entry(o_Language_Pl_Box, Language.PL),
                Map.entry(o_Language_Pt_Box, Language.PT),
                Map.entry(o_Language_Ru_Box, Language.RU),
                Map.entry(o_Language_Sr_Box, Language.SR),
                Map.entry(o_Language_Sv_Box, Language.SV),
                Map.entry(o_Language_Ta_Box, Language.TA),
                Map.entry(o_Language_Te_Box, Language.TE),
                Map.entry(o_Language_Th_Box, Language.TH),
                Map.entry(o_Language_Tl_Box, Language.TL),
                Map.entry(o_Language_Tr_Box, Language.TR),
                Map.entry(o_Language_Uk_Box, Language.UK),
                Map.entry(o_Language_Vi_Box, Language.VI),
                Map.entry(o_Language_Zh_Box, Language.ZH),
                Map.entry(o_Language_All_Box, Language.ALL)
        );

         countryMap = Map.ofEntries(
                Map.entry(pro_Co_Algeria_Box, productionCountry.ALGERIA),
                Map.entry(pro_Co_Argentina_Box, productionCountry.ARGENTINA),
                Map.entry(pro_Co_Australia_Box, productionCountry.AUSTRALIA),
                Map.entry(pro_Co_Austria_Box, productionCountry.AUSTRIA),
                Map.entry(pro_Co_Bahamas_Box, productionCountry.BAHAMAS),
                Map.entry(pro_Co_Belgium_Box, productionCountry.BELGIUM),
                Map.entry(pro_Co_Brazil_Box, productionCountry.BRAZIL),
                Map.entry(pro_Co_Bulgaria_Box, productionCountry.BULGARIA),
                Map.entry(pro_Co_Cambodia_Box, productionCountry.CAMBODIA),
                Map.entry(pro_Co_Canada_Box, productionCountry.CANADA),
                Map.entry(pro_Co_Chile_Box, productionCountry.CHILE),
                Map.entry(pro_Co_China_Box, productionCountry.CHINA),
                Map.entry(pro_Co_Czech_Republic_Box, productionCountry.CZECH_REPUBLIC),
                Map.entry(pro_Co_Denmark_Box, productionCountry.DENMARK),
                Map.entry(pro_Co_Dominican_Republic_Box, productionCountry.DOMINICAN_REPUBLIC),
                Map.entry(pro_Co_Ecuador_Box, productionCountry.ECUADOR),
                Map.entry(pro_Co_Estonia_Box, productionCountry.ESTONIA),
                Map.entry(pro_Co_Finland_Box, productionCountry.FINLAND),
                Map.entry(pro_Co_France_Box, productionCountry.FRANCE),
                Map.entry(pro_Co_Germany_Box, productionCountry.GERMANY),
                Map.entry(pro_Co_Greece_Box, productionCountry.GREECE),
                Map.entry(pro_Co_Hong_Kong_Box, productionCountry.HONG_KONG),
                Map.entry(pro_Co_Hungary_Box, productionCountry.HUNGARY),
                Map.entry(pro_Co_Iceland_Box, productionCountry.ICELAND),
                Map.entry(pro_Co_India_Box, productionCountry.INDIA),
                Map.entry(pro_Co_Indonesia_Box, productionCountry.INDONESIA),
                Map.entry(pro_Co_Iran_Box, productionCountry.IRAN),
                Map.entry(pro_Co_Ireland_Box, productionCountry.IRELAND),
                Map.entry(pro_Co_Italy_Box, productionCountry.ITALY),
                Map.entry(pro_Co_Japan_Box, productionCountry.JAPAN),
                Map.entry(pro_Co_Lithuania_Box, productionCountry.LITHUANIA),
                Map.entry(pro_Co_Luxembourg_Box, productionCountry.LUXEMBOURG),
                Map.entry(pro_Co_Mexico_Box, productionCountry.MEXICO),
                Map.entry(pro_Co_Morocco_Box, productionCountry.MOROCCO),
                Map.entry(pro_Co_Netherlands_Box, productionCountry.NETHERLANDS),
                Map.entry(pro_Co_New_Zealand_Box, productionCountry.NEW_ZEALAND),
                Map.entry(pro_Co_Nigeria_Box, productionCountry.NIGERIA),
                Map.entry(pro_Co_Norway_Box, productionCountry.NORWAY),
                Map.entry(pro_Co_Pakistan_Box, productionCountry.PAKISTAN),
                Map.entry(pro_Co_Peru_Box, productionCountry.PERU),
                Map.entry(pro_Co_Philippines_Box, productionCountry.PHILIPPINES),
                Map.entry(pro_Co_Poland_Box, productionCountry.POLAND),
                Map.entry(pro_Co_Romania_Box, productionCountry.ROMANIA),
                Map.entry(pro_Co_Russia_Box, productionCountry.RUSSIA),
                Map.entry(pro_Co_Singapore_Box, productionCountry.SINGAPORE),
                Map.entry(pro_Co_Slovakia_Box, productionCountry.SLOVAKIA),
                Map.entry(pro_Co_South_Africa_Box, productionCountry.SOUTH_AFRICA),
                Map.entry(pro_Co_South_Korea_Box, productionCountry.SOUTH_KOREA),
                Map.entry(pro_Co_Spain_Box, productionCountry.SPAIN),
                Map.entry(pro_Co_Sweden_Box, productionCountry.SWEDEN),
                Map.entry(pro_Co_Switzerland_Box, productionCountry.SWITZERLAND),
                Map.entry(pro_Co_Taiwan_Box, productionCountry.TAIWAN),
                Map.entry(pro_Co_Thailand_Box, productionCountry.THAILAND),
                Map.entry(pro_Co_Turkey_Box, productionCountry.TURKEY),
                Map.entry(pro_Co_Ukraine_Box, productionCountry.UKRAINE),
                Map.entry(pro_Co_UAE_Box, productionCountry.UAE),
                Map.entry(pro_Co_UK_Box, productionCountry.UK),
                Map.entry(pro_Co_USA_Box, productionCountry.USA),
                Map.entry(pro_Co_All_Box, productionCountry.ALL)
        );

        passer.registerEnumMap(Year.class, yearMap);
        passer.registerEnumMap(productionCountry.class, countryMap);
        passer.registerEnumMap(Genre.class, genreMap);
        passer.registerEnumMap(Language.class, languageMap);


        queryButton.setOnAction(e -> gatherSelections());

        image_Pane.setStyle(" -fx-background-color: lightgray;");



        load_Dataset_Button.setOnAction(e -> {
            try {
                loadDataSet();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // WW Is worldwide Dom = domestic Fore = foreign
        // This also sets the parameters of the sliders and function logic

         sliders = List.of(
                new SliderInfo(worldwide_Box_Low_Slider,  worldwide_Box_Low_Value_Display, WORLD_WIDE_BOX_RANGE_LOW,"WW_Box_Low"),
                new SliderInfo(worldwide_Box_High_Slider, worldwide_Box_High_Value_Display, WORLD_WIDE_BOX_RANGE_HIGH,"WW_Box_High"),
                new SliderInfo(domestic_Box_Low_Slider, domestic_Box_Low_Value_Display, DOMESTIC_BOX_RANGE_LOW,"Dom_Box_Low"),
                new SliderInfo(domestic_Box_High_Slider, domestic_Box_High_Value_Display, DOMESTIC_BOX_RANGE_HIGH, "Dom_Box_High"),
                new SliderInfo(foreign_Box_Low_Slider, foreign_Box_Low_Value_Display, FOREIGN_BOX_RANGE_LOW,"Fore_Box_Low"),
                new SliderInfo(foreign_Box_High_Slider, foreign_Box_High_Value_Display, FOREIGN_BOX_RANGE_HIGH,"Fore_Box_High"),
                new SliderInfo(domestic_Percent_Box_Low_Slider, domestic_Percent_Box_Low_Value_Display, DOMESTIC_BOX_PERCENT_RANGE_LOW,"Dom_Percentage_Box_Low"),
                new SliderInfo(domestic_Percent_Box_High_Slider, domestic_Percent_Box_High_Value_Display, DOMESTIC_BOX_PERCENT_RANGE_HIGH,"Dom_Percentage_Box_High"),
                new SliderInfo(foreign_Percent_Box_Low_Slider, foreign_Percent_Box_Low_Value_Display, FOREIGN_BOX_PERCENT_RANGE_LOW,"Fore_Percentage_Box_Low"),
                new SliderInfo(foreign_Percent_Box_High_Slider, foreign_Percent_Box_High_Value_Display, FOREIGN_BOX_PERCENT_RANGE_HIGH,"Fore_Percentage_Box_High"),
                new SliderInfo(rating_Low_Slider,rating_Low_Value_Display, RATING_RANGE_LOW,"Rating_Slider_Low"),
                new SliderInfo(rating_High_Slider, rating_High_Value_Display, RATING_RANGE_HIGH, "Rating_Slider_High"),
                new SliderInfo(vote_Count_Low_Slider, vote_Count_Low_Value_Display, VOTE_COUNT_RANGE_LOW,"VC_Slider_Low"),
                new SliderInfo(vote_Count_High_Slider, vote_Count_High_Value_Display, VOTE_COUNT_RANGE_HIGH,"VC_Slider_High")
        );

        sliders.forEach(this::setupSlider);

        graph_CBox.getItems().addAll(GraphType.values());

        // Converts Graph Type  Enum to String

        graph_CBox.setConverter(new javafx.util.StringConverter<>() {
            @Override
            public String toString(GraphType graphType) {
                return graphType == null ? "": graphType.getDisplayName();
            }

            @Override
            public GraphType fromString(String s) {
                return null;
            }
        });


        graph_CBox.setValue(GraphType.WW_BOX_YEAR);

//  Sets up the selection options for the graph selection control

        graph_CBox.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {
                    passer.setSelectedGraphType(newVal);
                });

        cdms = CDMS.getInstance(
                Paths.get(System.getProperty("user.dir"), "Mailbox", "toR"),
                Paths.get(System.getProperty("user.dir"), "Mailbox", "fromR")
        );
        try {
            cdms.watchFromRMailbox(); // start background mailbox watcher
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    // -------------------- POPULATE SELECTION PASSER --------------------


    @FXML
    private void gatherSelections() {

        try {
            // 🔒 Guard: dataset must already exist
            Path datasetPath = cdms.getToRMailbox().resolve("dataset.json");
            if (!Files.exists(datasetPath)) {
                System.err.println("Please load a dataset before submitting a query.");
                return;
            }

            // 1️⃣ Gather enum selections
            passer.applyAllSelections();

            // 2️⃣ Gather slider values
            for (SliderInfo si : sliders) {
                passer.getNumericSelections().put(si.key, (long) si.slider.getValue());
            }

            GraphType gt = graph_CBox.getValue();
            passer.setSelectedGraphType(gt);

            // 3️⃣ Export selections to mailbox
            Path selectionsPath = cdms.getToRMailbox().resolve("selections.json");
            passer.exportSelectionsToJson(selectionsPath.toString());

            // 4️⃣ Debug (optional, but good)
            passer.printAll();

            System.out.println("R script should launch next");
            // 5️⃣ Execute analysis (THIS launches R)
            cdms.runRScript(Paths.get("r/entry_point.R"));


            // 6️⃣ Watch for results
            cdms.watchFromRMailbox();

            // Load visuals / output

            Path visualsDir = cdms.getFromRMailbox().resolve("visuals");
            Path imagePath = getLatestImage(visualsDir);

            double targetWidth  = image_Pane.getPrefWidth();
            double targetHeight = image_Pane.getPrefHeight();

            Image image = new Image(
                    imagePath.toUri().toString(),
                    targetWidth,
                    targetHeight,
                    true,   // preserve ratio
                    true    // smooth
            );

            graph_View.setImage(image);


            System.out.println("R Any Mail");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private void setupSlider(SliderInfo info) {

        Slider slider = info.slider;
        Label label = info.label;
        Range range = info.range;

        slider.setMin(range.getMin());
        slider.setMax(range.getMax());

        double majorTickUnit = computeMajorTickUnit(range.getMin(), range.getMax());
        slider.setMajorTickUnit(majorTickUnit);

        slider.setMinorTickCount(4);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);







        // Snap for integer/percent ranges
        if (range.getMax() <= 100 || range.getMax() <= 10) {
            slider.setSnapToTicks(true);
        }

        // Initialize label
        label.setText(String.valueOf((long) slider.getValue()));

        // Listener to update SelectionPasser and label in real time
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            long val = newVal.longValue();
            label.setText(String.valueOf(val));
            passer.setSliderValue(info.key, val);
        });

        // Optionally, set starting value to min
        slider.setValue(range.getMin());
        passer.setSliderValue(info.key, range.getMin());
    }


    private double computeMajorTickUnit(long min, long max) {
        long range = max - min;
        if (range > 1_000_000_000L) return range / 10.0;       // Large box office numbers
        if (range > 10_000_000L) return range / 10.0;          // Smaller box office
        if (range > 100_000L) return range / 10.0;             // Vote counts
        if (range <= 10) return 1;                              // Ratings
        if (range <= 100) return 10;                            // Percentages
        return range / 10.0;                                   // Default fallback
    }




    public class SliderInfo {
        Slider slider;
        Label label;
        Range range;
        String key;





        SliderInfo(Slider slider, Label label, Range range, String key) {
            this.slider = slider;
            this.label = label;
            this.range = range;
            this.key = key;

        }

        public long getValue() {
            return (long) slider.getValue();
        }



    }




    public void loadDataSet() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a CSV dataset");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null && selectedFile.exists()) {
            try {
                cdms.sendDataset(selectedFile); // hand off to CDMS
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Path getLatestImage(Path visualsDir) throws IOException {
        try (Stream<Path> files = Files.list(visualsDir)) {
            return files
                    .filter(p -> p.toString().toLowerCase().endsWith(".png"))
                    .max(Comparator.comparingLong(p -> p.toFile().lastModified()))
                    .orElseThrow(() -> new IOException("No image found in visuals folder"));
        }
    }






}






















