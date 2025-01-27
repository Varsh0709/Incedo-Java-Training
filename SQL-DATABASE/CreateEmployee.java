package SqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class CreateEmployee {
	
	public static void createTable(Connection conn,Scanner scan) {
		Scanner scan1=new Scanner(System.in);
		System.out.println("\nEnter the following details to create a new table");
		
		System.out.println("Enter the table name");
		String tableName=scan1.nextLine();
		
		System.out.println("Enter the columns and their data types:");
		String columns=scan1.nextLine();
		
		String createQuery="CREATE TABLE IF NOT EXISTS "+ tableName + " ( " + columns + " );";
		
		try(Statement stmt=conn.createStatement()){
			stmt.executeUpdate(createQuery);
			System.out.println("Table '"+tableName+"'created successfully.");
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}
	
}
