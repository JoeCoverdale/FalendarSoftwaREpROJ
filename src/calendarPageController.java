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
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import java.util.ResourceBundle;
import javax.swing.Action;
import java.io.IOException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

//Functions and Methods
public class calendarPageController {

    //Welcome label 
    @FXML
    private Label welcomeLabel;

    //Details saved label
    @FXML Label saveLabel;

//Program input -------------------------------
    @FXML
    private DatePicker DateChooserDatePicker;

    @FXML
    private TextField ExerciseTextField;

    @FXML
    private TextField setsAndRepsTextField;

    @FXML
    private TextField weightTextField;

//Data colums -------------------------------

    @FXML
    private TableView<?> exerciseDataTableView;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> exerciseColumn;

    @FXML
    private TableColumn<?, ?> SetsAndRepsColumn;
    
    @FXML
    private TableColumn<?, ?> weightColumn;

//Buttons -----------------------------------
    @FXML
    private Button addNoteButton;
    public void addNoteButtonOnAction(ActionEvent event){

    }

    @FXML
    private Button editNoteButton;

    @FXML
    private Button exitButton;

    public void exitButtonOnAction(ActionEvent event){
        Stage stage =(Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button saveNotesButton;

}
