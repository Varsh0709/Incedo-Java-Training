package SqlConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class crudOps {

	
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

	
	//Create a employee table
	public static void createTable(Connection conn,Scanner scan) {
		
		System.out.println("\nEnter the following details to create a new table");
		
		System.out.println("Enter the table name");
		String tableName=scan.nextLine();
		
		System.out.println("Enter the columns and their data types:");
		String columns=scan.nextLine();
		
		String createQuery="CREATE TABLE IF NOT EXISTS "+ tableName + " ( " + columns + " );";
		
		try(Statement stmt=conn.createStatement()){
			stmt.executeUpdate(createQuery);
			System.out.println("Table '"+tableName+"'created successfully.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//Retrieve a user's details
	public static void readUser(Connection conn,Scanner scan) {
		System.out.println("Enter the user id which u want to retrieve details for:");
		String EmployeeId=scan.nextLine();
		
		String query="SELECT * FROM Employee WHERE EmployeeId=?";
		
		try(PreparedStatement pst=conn.prepareStatement(query)){
			pst.setString(1,EmployeeId);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				String EmployeeName=rs.getString("EmployeeName");
				String JobTitle=rs.getString("JobTitle");
				int Salary=rs.getInt("Salary");
				String EmailId=rs.getString("EmailId");
				String Date=rs.getString("DateOfBirth");
				System.out.println("For the given employee id "+EmployeeId+"\n");
				System.out.println("Employee name: "+EmployeeName+"\n"+"Position: "+JobTitle+"\n"+"Salary: "+Salary+"\n"+"Email id: "+EmailId+"\n"+"Date: "+Date);
			}
			else {
				System.out.println("No employee found with id "+EmployeeId);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//Insert a record
	public static void insertRecord(Connection conn,Scanner scan) {
		System.out.println("\nInsert a record:");
		
		System.out.println("Enter employee's id:");
		String EmployeeId=scan.nextLine();
		
		System.out.print("Enter employee's name: ");
        String EmployeeName = scan.nextLine();
        
        System.out.print("Enter job title: ");
        String JobTitle = scan.nextLine();
       
        System.out.print("Enter Salary: ");
        int Salary = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Enter email id: ");
        String EmailId=scan.nextLine();
        
        System.out.println("Enter date of birth(YYYY-MM-DD): ");
        String DateOfBirth=scan.nextLine();
        
        String insertSQL = "INSERT INTO Employee (EmployeeId, EmployeeName, JobTitle, Salary, EmailId, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pst = conn.prepareStatement(insertSQL)){
        	
        	pst.setString(1, EmployeeId);
        	pst.setString(2, EmployeeName);
        	pst.setString(3, JobTitle);
        	pst.setInt(4, Salary);
        	pst.setString(5, EmailId);
        	pst.setDate(6, Date.valueOf(DateOfBirth));
        	
        	int rows=pst.executeUpdate();
        	System.out.println(rows+"row(s) inserted into the table.");	
        	
        } catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Update an employee's details
	public static void updateRecord(Connection conn,Scanner scan) {
		System.out.println("Enter employee id to update:");
		String EmployeeId=scan.nextLine();
		
		System.out.println("Which column you want to update?");
		System.out.println("1. EmployeeName");
		System.out.println("2. Job Title");
		System.out.println("3. Salary");
		System.out.println("4. Email id");
		System.out.println("5. Date of birth");
		
		int columnChoice=scan.nextInt();
		scan.nextLine();
		
		//Get what column to update and new value
		String columnToUpdate=" ";
		String newValue=" ";
		int newSalary=0;
		
		if(columnChoice==1) {
			columnToUpdate="EmployeeName";
			System.out.println("Enter the new name: ");
			newValue=scan.nextLine();
		}
		else if(columnChoice==2) {
			columnToUpdate="JobTitle";
			System.out.println("Enter the new position: ");
			newValue=scan.nextLine();
		}
		else if(columnChoice==3) {
			columnToUpdate="Salary";
			System.out.println("Enter the salary:");
			newSalary=scan.nextInt();
			scan.nextLine();
		}
		else if(columnChoice==4) {
			columnToUpdate="EmailId";
			System.out.println("Enter the new email id: ");
			newValue=scan.nextLine();
		}
		else if(columnChoice==5) {
			columnToUpdate="DateOfBirth";
			System.out.println("Enter the new date of birth: ");
			newValue=scan.nextLine();
		}
		else {
			System.out.println("You have entered an invalid option!\n No update made!");
			return;
		}
		
		//SQL Update query
		String updateQuery="UPDATE Employee SET "+columnToUpdate+"= ? WHERE EmployeeId= ?";
		try(PreparedStatement pst=conn.prepareStatement(updateQuery)){
			if(columnToUpdate.equals("Salary")) {
				pst.setInt(1, newSalary);
			}
			else {
				pst.setString(1, newValue);
			}
			pst.setString(2,EmployeeId);
			
			int rows=pst.executeUpdate();
			System.out.println("Updated"+rows+"row(s) in the employee table.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
			
   }
   
	public static void deleteRecord(Connection conn,Scanner scan) {
		System.out.println("Enter employee if to delete:");
		String EmployeeId=scan.nextLine();
		
		String deleteQuery="DELETE FROM Employee WHERE EmployeeId=?";
		
		try(PreparedStatement pst=conn.prepareStatement(deleteQuery)){
			pst.setString(1, EmployeeId);
			int rows=pst.executeUpdate();
			System.out.println("Deleted "+rows+"row(s) from the employee table");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) throws SQLException{
		
		// Get choice from the user as to which operation to proceed with
		Scanner scan=new Scanner(System.in);
		Connection conn=getConnection();
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
				createTable(conn,scan);
				break;
				
			case 2:
				insertRecord(conn,scan);
				break;
				
			case 3:
				updateRecord(conn,scan);
				break;
				
			case 4:
				deleteRecord(conn,scan);
				break;
				
			case 5:
				readUser(conn,scan);
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
