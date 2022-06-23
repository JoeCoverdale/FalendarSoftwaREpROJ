// Software Project: Fitness Calendar
//Creator: Joseph Coverdale
//Student Number: 17024693

/*--------------------------------------------------------------------------------------------------------------------- */

//Imported Libraries
import java.sql.Connection;
import java.sql.DriverManager;

//Functions and Methods
//Function used to gain conenction to the database
public class databaseCon {
    public Connection conn;

    public Connection getConnection(){
        String dbName = "userdata";
        String dbUser = "root";
        String dbPassword = "123456";
        String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUser + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return conn;
    }
}