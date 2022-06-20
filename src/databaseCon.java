// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

//Imported libraries
import java.sql.Connection;
import java.sql.DriverManager;

//Function used to gain conenction to the database
public class databaseCon {
    public Connection databaseLink;

    public Connection getConnection(){
        String dbName = "LocalHost";
        String dbUser = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://localhost/" + dbName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, dbUser, dbPassword);

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}