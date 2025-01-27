package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//To establish a connection with the database
		public static Connection getConnection() throws SQLException{
			//Database Connection
			final String URL="jdbc:mysql://localhost:3306/employeedb";
			final String Username="root";
			final String Password="Incedo@1234";
			try {
				return DriverManager.getConnection(URL,Username,Password);
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}


}
