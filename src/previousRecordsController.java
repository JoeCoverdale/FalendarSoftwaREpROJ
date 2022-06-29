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

//Class containing functionality for the previous records page
public class previousRecordsController {

//Table -------------------------------

    @FXML
    private TableView<exerciseData> exerciseDataTableView;

//columns -------------------------------

    @FXML
    private TableColumn<exerciseData, Integer> idColumn;

    @FXML
    private TableColumn<exerciseData, String> SetsAndRepsColumn;

    @FXML
    private TableColumn<exerciseData, String> dateColumn;

    @FXML
    private TableColumn<exerciseData, String> exerciseColumn;

    @FXML
    private TableColumn<exerciseData, String> weightColumn;

//Used to exit the window

    @FXML
    private Button viewRecordsButton;

    public void viewRecordsButtonOnAction(ActionEvent event){
        databaseCon connectNow = new databaseCon(); 
        Connection connectDatabase = connectNow.getConnection();

        
    }
    @FXML
    private Button exitButton;

    public void exitButtonOnAction(ActionEvent event){
        Stage stage =(Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
