//Imported libraries
import java.sql.Connection;
import java.sql.DriverManager;

//Function used to gain conenction to the database
public class databaseCon {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "Dbusername123";
        String databaseUser = "root";
        String databasePassword = "123456";

        String connectionString = "jdbc:mysql://localhost/" + databaseName + "?user=" + databaseUser + "&password=" + databasePassword + "&useUnicode=true&characterEncoding=UTF-8";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}