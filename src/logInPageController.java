// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

//Public class containing functionality for login page
public class logInPageController{

    //Create account button functionality
    @FXML
    private Button createAccountButton;

    public void createAccountButtonOnAction(ActionEvent event) {

    }

    //Login button functionality
    @FXML
    private Button loginButton;
    
    //Login message label functionality - Displays incorrect details message 
    @FXML
    private Label loginMessageLabel;

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isEmpty()== false && passwordTextField.getText().isEmpty()== false){
            checkLogin();
        }
            else{
                loginMessageLabel.setText("Details incorrect. Please try again!");
            }
    }

    //Password text field fucntionality
    @FXML
    private TextField passwordTextField;

    //Username textfield functionality
    @FXML
    private TextField usernameTextField;

    //Function used for the exit app button - Working
    @FXML
    private Button exitButton;
    
    public void exitButtonOnAction(ActionEvent event){
        Stage stage =(Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    //Function used to validate the user log in details against SQL database
    public void checkLogin(){
        databaseCon connectNow = new databaseCon();
        Connection connectDatabase = connectNow.getConnection();

        String checkLoginDetais = "SELECT count(1) FROM user_details WHERE username = ''" + usernameTextField.getText() + "' AND password ='" + passwordTextField.getText();
        
        try{

            Statement statement = connectDatabase.createStatement();
            ResultSet queryResult = statement.executeQuery(checkLoginDetais);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome user!");
                } else {
                    loginMessageLabel.setText("Details incorrect. Please try again!");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}