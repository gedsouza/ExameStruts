package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	 public Connection getConnection(){
         try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             return DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/exames?useTimezone=true&serverTimezone=UTC", "root", "admin123");
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
}
