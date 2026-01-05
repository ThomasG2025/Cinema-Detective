package CinemaDetectiveV1.Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {


 public static void main(String[]args){




     launch(args);


 }


    @Override
    public void start(Stage primaryStage) throws Exception {

     // Loads FXML file that holds User interface visual logic

     Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/CinemaDetectiveV1/FXML/GUIV1.fxml"))));
     primaryStage.setTitle("User Interface");
     primaryStage.setScene(new Scene(root,1200,700));
     primaryStage.show();

    }
}
