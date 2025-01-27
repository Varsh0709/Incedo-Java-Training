package SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadEmployee {

    
    public static void readRecords(Connection conn, Scanner scan) {
        String query = "SELECT * FROM Employee";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            boolean isEmpty = true;

            while (rs.next()) {
                String EmployeeId = rs.getString("EmployeeId");
                String EmployeeName = rs.getString("EmployeeName");
                String JobTitle = rs.getString("JobTitle");
                int Salary = rs.getInt("Salary");
                String EmailId = rs.getString("EmailId");
                String Date = rs.getString("DateOfBirth");
                System.out.println("For the given employee id " + EmployeeId + "\n");
                System.out.println("Employee name: " + EmployeeName + "\n" + "Position: " + JobTitle + "\n" + "Salary: " + Salary + "\n" + "Email id: " + EmailId + "\n" + "Date: " + Date);

                isEmpty = false; // Found at least one employee
            }

            if (isEmpty) {
                System.out.println("No employee found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

