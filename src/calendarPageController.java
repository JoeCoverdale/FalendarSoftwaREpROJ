// Software Project: Fitness note taking application
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import java.util.ResourceBundle;
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
    
//Program input -------------------------------

    @FXML
    private TextField iDTextField;

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
    private TableColumn<exerciseData, Integer> idColumn;

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
        idColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, Integer>("id"));;
        dateColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("dow"));
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("e"));
        SetsAndRepsColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("sar"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<exerciseData, String>("w"));
    }
    
    //Add notes button - also savess ntoes to the sql db
    @FXML
    private Button addNoteButton;
    
    public void addNoteButtonOnAction(ActionEvent event){
        exerciseData exerciseData = new exerciseData(Integer.parseInt(iDTextField.getText()),
                (dateTextField.getText()),
                (exerciseTextField.getText()),
                (setsAndRepsTextField.getText()),
                (weightTextField.getText()));
        ObservableList<exerciseData> exerciseDatas= exerciseDataTableView.getItems();
        exerciseDatas.add(exerciseData);
        exerciseDataTableView.setItems(exerciseDatas);

        //Database part
        databaseCon connectNow = new databaseCon(); 
        Connection connectDatabase = connectNow.getConnection();

        Integer id = Integer.parseInt(iDTextField.getText());
        String dateOfWorkout = dateTextField.getText();
        String exercise = exerciseTextField.getText();
        String setsAndReps = setsAndRepsTextField.getText();
        String weight = weightTextField.getText();

        String insertFields = "INSERT INTO exercisedata (id, workoutDate, exerciseName, setsAndReps, weightInKg) VALUES ('";
        String insertValues = id + "','" + dateOfWorkout + "','" + exercise + "','" + setsAndReps + "','" + weight + "')";
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

    //Used to edit notes which have been saved 
    @FXML
    private Button editNoteButton;
    
    public void editNoteButtonOnAction(ActionEvent event){
        ObservableList <exerciseData> currentTableData = exerciseDataTableView.getItems();
        int currentRowId = Integer.parseInt(iDTextField.getText());

        for (exerciseData exerciseData : currentTableData){
            if(exerciseData.getId()==currentRowId) {
                exerciseData.setDow(dateTextField.getText());
                exerciseData.setE(exerciseTextField.getText());
                exerciseData.setSar(setsAndRepsTextField.getText());
                exerciseData.setW(weightTextField.getText());

                exerciseDataTableView.setItems(currentTableData);
                exerciseDataTableView.refresh();
                break;

            }
        }
    }

    //Metrhod for when user clicks row they want to edit
    public void rowClicked(MouseEvent event){
        exerciseData clickedExerciseData = exerciseDataTableView.getSelectionModel().getSelectedItem();
        iDTextField.setText((String.valueOf(clickedExerciseData.getId())));
        dateTextField.setText(String.valueOf(clickedExerciseData.getDow()));
        exerciseTextField.setText(String.valueOf(clickedExerciseData.getE()));
        setsAndRepsTextField.setText(String.valueOf(clickedExerciseData.getSar()));
    }

     //Used to view the execises that have previouylsy been recorded
     @FXML
     private Button viewPrevExerciseButton;
 
     public void viewPrevExerciseButtonOnAction(ActionEvent event){
 
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
