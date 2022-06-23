// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

//Functions and Methods
public class calendarPageController {

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Button addNoteButton;

    public void addNoteButtonOnAction(ActionEvent event){

    }

    @FXML
    private TableView<?> dataTableView;

    @FXML
    private Label deatailsSavedLabel;

    @FXML
    private Button editNoteButton;

    public void editNotesButtonOnAction(ActionEvent event){

    }

    //Used to exit this page
    @FXML
    private Button exitButton;
    
    public void exitButtonOnAction(ActionEvent event){
        Stage stage =(Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button saveNotesButton;
    
    public void saveNotesButtonOnAction(ActionEvent event){

    }

    @FXML
    private Label welcomeLabel;

}



