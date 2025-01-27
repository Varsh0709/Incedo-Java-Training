package SqlConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws SQLException{
		
		// Get choice from the user as to which operation to proceed with
		Scanner scan=new Scanner(System.in);
		Connection conn=DatabaseConnection.getConnection();
		if(conn!=null){
			System.out.println("Connection successfull");
		}
		else {
			System.out.println("Failed to establish connection");
		}
		while(true){
			System.out.println("Select an operation:");
			System.out.println("1. Create a new table");
			System.out.println("2.Insert a new record");
			System.out.println("3. Update a record");
			System.out.println("4. Delete a record");
			System.out.println("5. Print the table");
			System.out.println("Enter your choice:");
			int choice=scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			case 1:
				CreateEmployee.createTable(conn, scan);
				break;
				
			case 2:
				InsertEmployee.insertRecord(conn, scan);
				break;
				
			case 3:
				UpdateEmployee.updateRecord(conn, scan);
				break;
				
			case 4:
				DeleteEmployee.deleteRecord(conn,scan);
				break;
				
			case 5:
				ReadEmployee.readRecords(conn, scan);
				break;
			default:
				System.out.println("Invalid choice!");
				System.out.println("Kindly select an option from (1-4)");
				continue;
			}
			
			System.out.println("Do you want to continue the operation (yes/no)? ");
			String continueChoice=scan.nextLine();
			
			if(continueChoice.equalsIgnoreCase("no")) {
				System.out.println("Exiting the program");
				break;
			}
			
		} 
		try {
			if(conn!=null) {
				conn.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		scan.close();
	}
	

}
