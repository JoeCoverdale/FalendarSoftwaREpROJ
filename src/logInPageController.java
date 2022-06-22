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
import javafx.stage.Stage;
import java.io.IOException;

//Public class containing functionality for login page
public class logInPageController{

    //Create account button functionality
    @FXML
    private Button createAccountButton;

    //used to take user to create account page
    public void createAccountButtonOnAction(ActionEvent event){
        try{

            Parent root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
            Stage createAccountStage = new Stage();
            Scene scene = new Scene(root);
            createAccountStage.setTitle("Create Account");
            createAccountStage.setScene(scene);
            createAccountStage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    //Login button functionality
    @FXML
    private Button loginButton;
    
    //Login message label functionality - Displays incorrect details message 
    @FXML
    private Label loginMessageLabel;

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isEmpty()== false && passwordPasswordField.getText().isEmpty()== false){
            checkLogin();
        }
            else{
                loginMessageLabel.setText("Details incorrect. Please try again.");
            }
    }

    //Password text field fucntionality - add echo functionality if enough time
    @FXML
    private PasswordField passwordPasswordField;


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

    //Function used to check the user log in details against SQL database
    public void checkLogin(){
        databaseCon connectNow = new databaseCon();
        Connection connectDatabase = connectNow.getConnection();

        String checkLoginDetais = "SELECT count(1) FROM user_details WHERE username ='" + usernameTextField.getText() + "' AND password ='" + passwordPasswordField.getText() + "'";
        
        try{

            Statement statement = connectDatabase.createStatement();
            ResultSet queryResult = statement.executeQuery(checkLoginDetais);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome user!");
                } else {
                    loginMessageLabel.setText("Details incorrect. Please try again.");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}