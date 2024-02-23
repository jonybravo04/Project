package maven.demo;

import java.sql.*;
import java.io.*;

public class dynamicinsert {
	
	public static void main(String[] args) {
		
	    String csvFilePath = "C:\\Users\\nares\\eclipse-workspace\\maven.demo\\src\\main\\resources\\Book1.csv";   // Path to CSV file
	        
	    try (BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath))) {
	            
	            lineReader.readLine();	// Skip header line
	            
	            String lineText;
	            while ((lineText = lineReader.readLine()) != null) {
	                String[] data = lineText.split(",");
	                
	                int empID = Integer.parseInt(data[0]);
	                String empName = data[1];
	                String designation = data[2];
	                String location = data[3];
	                modelclass userData = new modelclass(empID, empName, designation, location);
	                insertUser(userData);
	            }
	            System.out.println("Data has been successfully inserted into the database.");
	        } 
	            catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }

	    private static void insertUser(modelclass mc) {
	        String insertQuery = "insert into empdetails(empID,empName,designation,location) "
					+ "values(?,?,?,?)";

	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root","Adm!n");
	             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
	            
	            preparedStatement.setInt(1, mc.getEmpID());
	            preparedStatement.setString(2, mc.getEmpName());
	            preparedStatement.setString(3, mc.getDesignation());
	            preparedStatement.setString(4, mc.getLocation());

	            preparedStatement.executeUpdate();
	            
	        } catch (Exception e) {
	            System.err.println("Error during the insert: " + e.getMessage());
	        }
	    }
	}
