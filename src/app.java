// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


//Functions and Methods
public class app extends Application {
    @Override
    public void start(Stage primaryStage) {

  Parent root;
    try {

    root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Falendar");
    primaryStage.setScene(scene);
    primaryStage.show();} catch (IOException e) {

    e.printStackTrace();
}
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}


