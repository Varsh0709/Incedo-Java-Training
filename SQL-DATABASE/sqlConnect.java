package SqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class sqlConnect {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employeedb"; 
	    String user = "root"; 
	    String password = "Incedo@1234";
	    
	    try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Successfully connected to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
		
	} 

}
