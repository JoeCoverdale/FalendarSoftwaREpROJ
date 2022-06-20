// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

//Imported Libraries
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class app extends Application {
    @Override
    public void start(Stage primaryStage) {

  Parent root;
    try {

    root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("PPF Home.");
    primaryStage.setScene(scene);
    primaryStage.show();} catch (IOException e) {

    e.printStackTrace();
}
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}


