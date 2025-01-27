package SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
	
	public static void deleteRecord(Connection conn,Scanner scan) {
		System.out.println("Enter employee id to delete:");
        String EmployeeId = scan.nextLine();

        String deleteQuery = "DELETE FROM Employee WHERE EmployeeId = ?";

        try (PreparedStatement pst = conn.prepareStatement(deleteQuery)) {
            pst.setString(1, EmployeeId);
            int rows = pst.executeUpdate();
            System.out.println("Deleted " + rows + " row(s) from the employee table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	}

