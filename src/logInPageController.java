// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

//Imported Libraries
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;

//Function used for first page user will see when using the app
public class logInPageController extends Application {
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 300,450, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Create Account");
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}

