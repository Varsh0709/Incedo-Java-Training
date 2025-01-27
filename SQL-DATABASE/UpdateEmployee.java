package SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {
	
	public static void updateRecord(Connection conn,Scanner scan) {
		System.out.println("Enter employee id to update:");
        String EmployeeId = scan.nextLine();

        System.out.println("Which column you want to update?");
        System.out.println("1. EmployeeName");
        System.out.println("2. Job Title");
        System.out.println("3. Salary");
        System.out.println("4. Email id");
        System.out.println("5. Date of birth");

        int columnChoice = scan.nextInt();
        scan.nextLine();

        String columnToUpdate = " ";
        String newValue = " ";
        int newSalary = 0;

        if (columnChoice == 1) {
            columnToUpdate = "EmployeeName";
            System.out.println("Enter the new name: ");
            newValue = scan.nextLine();
        } else if (columnChoice == 2) {
            columnToUpdate = "JobTitle";
            System.out.println("Enter the new position: ");
            newValue = scan.nextLine();
        } else if (columnChoice == 3) {
            columnToUpdate = "Salary";
            System.out.println("Enter the salary:");
            newSalary = scan.nextInt();
            scan.nextLine();
        } else if (columnChoice == 4) {
            columnToUpdate = "EmailId";
            System.out.println("Enter the new email id: ");
            newValue = scan.nextLine();
        } else if (columnChoice == 5) {
            columnToUpdate = "DateOfBirth";
            System.out.println("Enter the new date of birth: ");
            newValue = scan.nextLine();
        } else {
            System.out.println("You have entered an invalid option! No update made!");
            return;
        }

        String updateQuery = "UPDATE Employee SET " + columnToUpdate + " = ? WHERE EmployeeId = ?";
        try (PreparedStatement pst = conn.prepareStatement(updateQuery)) {
            if (columnToUpdate.equals("Salary")) {
                pst.setInt(1, newSalary);
            } else {
                pst.setString(1, newValue);
            }
            pst.setString(2, EmployeeId);

            int rows = pst.executeUpdate();
            System.out.println("Updated " + rows + " row(s) in the employee table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		
	}

}
