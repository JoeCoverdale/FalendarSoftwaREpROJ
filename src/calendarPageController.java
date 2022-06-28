// Software Project: Fitness note taking application
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.sql.Connection;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import java.util.ResourceBundle;
import javax.print.DocFlavor.STRING;
import javax.swing.Action;
import javax.swing.text.TabableView;
import com.mysql.cj.xdevapi.Table;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

//Functions and Methods
public class calendarPageController implements Initializable {

    //Welcome label 
    @FXML
    private Label welcomeLabel;

    //Details saved label
    @FXML Label saveLabel;

    /*Used to save the details to sql db - May adjsut and make add button save aswell
    public void saveDetails(){
        databaseCon connectNow = new databaseCon(); 
        Connection connectDatabase = connectNow.getConnection();

        String dateOfWorkout = dateTextField.getText();
        String exercise = ExerciseTextField.getText();
        String setsAndReps = setsAndRepsTextField.getText();
        String weight = weightTextField.getText();

        String insertFields = "INSERT INTO exercisedata (workoutDate, exerciseName, setsAndReps, weightInKg) VALUES ('";
        String insertValues = dateOfWorkout + "','" + exercise + "','" + setsAndReps + "','" + weight + "')";
        String insertToSave = insertFields + insertValues;

        try{
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToSave);

            saveLabel.setText("Details Saved");

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
        */
//Program input -------------------------------
    @FXML
    private TextField dateTextField;

    @FXML
    private TextField exerciseTextField;

    @FXML
    private TextField setsAndRepsTextField;

    @FXML
    private TextField weightTextField;

//Table -------------------------------

    @FXML
    private TableView<exerciseData> exerciseDataTableView;

//columns -------------------------------
    @FXML
    private TableColumn<exerciseData, String> dateColumn;

    @FXML
    private TableColumn<exerciseData, String> exerciseColumn;

    @FXML
    private TableColumn<exerciseData, String> SetsAndRepsColumn;
    
    @FXML
    private TableColumn<exerciseData, String> weightColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("dow"));
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("e"));
        SetsAndRepsColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("sar"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("w"));
    }

    //Add notes button - also savess ntoes to the sql db
    @FXML
    private Button addNoteButton;
    
    public void addNoteButtonOnAction(ActionEvent event){
        exerciseData exerciseData = new exerciseData(dateTextField.getText(),
                (exerciseTextField.getText()),
                (setsAndRepsTextField.getText()),
                (weightTextField.getText()));
        ObservableList<exerciseData> exerciseDatas= exerciseDataTableView.getItems();
        exerciseDatas.add(exerciseData);
        exerciseDataTableView.setItems(exerciseDatas);

        //Database part
        databaseCon connectNow = new databaseCon(); 
        Connection connectDatabase = connectNow.getConnection();

        String dateOfWorkout = dateTextField.getText();
        String exercise = exerciseTextField.getText();
        String setsAndReps = setsAndRepsTextField.getText();
        String weight = weightTextField.getText();

        String insertFields = "INSERT INTO exercisedata (workoutDate, exerciseName, setsAndReps, weightInKg) VALUES ('";
        String insertValues = dateOfWorkout + "','" + exercise + "','" + setsAndReps + "','" + weight + "')";
        String insertToSave = insertFields + insertValues;

        try{
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToSave);

            saveLabel.setText("Exercise Details Added");

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
 
    //Used to view the execises that have previouylsy been recorded
    @FXML
    private Button viewPrevExerciseButton;

    public void viewPrevExerciseButtonOnAction(ActionEvent event){

    }

    //Used to edit notes which have been saved 
    @FXML
    private Button editNoteButton;

    //Metrhod for when user clicks row they want to edit
    public void rowClicked(MouseEvent event){
        exerciseData clickedExerciseData = exerciseData.getSelectionModel().getSelectedItem();
        dateTextField.setText(String.valueOf(clickedExerciseData.getDow()));
        exerciseTextField.setText(String.valueOf(clickedExerciseData.getE()));
        setsAndRepsTextField.setText(String.valueOf(clickedExerciseData.getSar()));
        weightTextField.setText(String.valueOf(clickedExerciseData.getW()));
    }

    //Used to exit the window
    @FXML
    private Button exitButton;

    public void exitButtonOnAction(ActionEvent event){
        Stage stage =(Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    //Used to delete selected notes
    @FXML
    private Button deleteNotesButton;

    public void deleteNotesButtonOnAction(ActionEvent event){
        int selectedID = exerciseDataTableView.getSelectionModel().getSelectedIndex();
        exerciseDataTableView.getItems().remove(selectedID);
        saveLabel.setText("Exercise details deleted");
    }
}
