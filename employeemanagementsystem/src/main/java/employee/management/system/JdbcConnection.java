package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {

    Connection conn;
    Statement statement;

    public JdbcConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the driver class
            conn = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem",System.getenv("DB_USERNAME"),System.getenv("DB_USERNAME")); //connection string
            statement = conn.createStatement(); //creating statement
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}