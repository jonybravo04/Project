package maven.demo;

import java.util.*;
import java.sql.*;

public class dynamicBatchInsert {
	
	public static void insertmodelclass (List <modelclass> mc1) throws ClassNotFoundException {
	
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root","Adm!n");
			
			String query = "insert into empdetails(empID,empName,designation,location) "
						+ "values(?,?,?,?)";
			PreparedStatement ptsmt = conn.prepareStatement(query);
			
			conn.setAutoCommit(false);
			
			 for (modelclass mc : mc1) {
				 	ptsmt.setInt(1, mc.getEmpID());
					ptsmt.setString(2, mc.getEmpName());
					ptsmt.setString(3, mc.getDesignation());
					ptsmt.setString(4, mc.getLocation());
	                ptsmt.addBatch(); // Add to batch
	            }
			 ptsmt.executeBatch();
	         conn.commit();
	         System.out.println("Batch insert completed successfully.");
				
		} catch (SQLException e) {
			System.err.println("Error during batch insert: " + e.getMessage());
			}
			
		}
	public static void main(String[] args) throws ClassNotFoundException {
			
		csvReader csvreader = new csvReader();
        List<modelclass> mc1 = csvreader.readCsv("C:\\Users\\nares\\eclipse-workspace\\maven.demo\\src\\main\\resources\\Book1.csv");
	
		dynamicBatchInsert.insertmodelclass(mc1);
	}

}
