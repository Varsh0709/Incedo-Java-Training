package SqlConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertEmployee {
	public static void insertRecord(Connection conn, Scanner scan) {
        System.out.println("\nInsert a record:");

        System.out.print("Enter employee's id: ");
        String EmployeeId = scan.nextLine();

        System.out.print("Enter employee's name: ");
        String EmployeeName = scan.nextLine();

        System.out.print("Enter job title: ");
        String JobTitle = scan.nextLine();

        System.out.print("Enter Salary: ");
        int Salary = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter email id: ");
        String EmailId = scan.nextLine();

        System.out.println("Enter date of birth (YYYY-MM-DD): ");
        String DateOfBirth = scan.nextLine();

        String insertSQL = "INSERT INTO Employee (EmployeeId, EmployeeName, JobTitle, Salary, EmailId, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(insertSQL)) {
            pst.setString(1, EmployeeId);
            pst.setString(2, EmployeeName);
            pst.setString(3, JobTitle);
            pst.setInt(4, Salary);
            pst.setString(5, EmailId);
            pst.setDate(6, Date.valueOf(DateOfBirth));

            int rows = pst.executeUpdate();
            System.out.println(rows + " row(s) inserted into the table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
