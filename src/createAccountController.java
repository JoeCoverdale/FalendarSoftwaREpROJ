// Software Project: Fitness note taking application
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
import javafx.scene.control.PasswordField;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

//Functions and Methods

public class createAccountController {

    //All fxml components
    @FXML
    private Label comfirmPasswordLabel;
    @FXML
    private PasswordField comfirmPasswordPasswordField;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label firstnameLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private Label lastnameLabel;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private Label accountCreatedLabel;
    @FXML
    private Button registerButton;

    public void registerButtonOnAction(ActionEvent event){
        if (setPasswordPasswordField.getText().equals(comfirmPasswordPasswordField.getText())) {
            registerUser();
        } else {
            accountCreatedLabel.setText("Passwords do not match, please enter again.");
        }
    }

    //Method used to registrer the user
    public void registerUser(){
        databaseCon connectNow = new databaseCon(); 
        Connection connectDatabase = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = registerUsernameTextField.getText();
        String password = setPasswordPasswordField.getText();
        String email = emailTextField.getText();
    
        String insertFields = "INSERT INTO user_details (firstname, lastname, username, password, email) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "','" + email + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDatabase.createStatement();
            statement.executeUpdate(insertToRegister);

            accountCreatedLabel.setText("User registered");

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField setPasswordPasswordField;

    @FXML
    private TextField registerUsernameTextField;

    //Used to take user back to the login page
    @FXML
    private Button closeButton;

    public void closeButtonOnAction(ActionEvent event){
        Stage stage =(Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label usernameTextField;

    }
