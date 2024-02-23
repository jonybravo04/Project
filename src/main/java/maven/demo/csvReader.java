package maven.demo;
import java.util.*;
import java.io.*;

public class csvReader {

	public List<modelclass> readCsv(String filePath) {
	       List<modelclass> mc1 = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        	br.readLine();
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                modelclass mc = new modelclass(Integer.parseInt(values[0]), values[1], (values[2]), values[3]);
	                mc1.add(mc);
	            }
	        } catch (Exception e) {
	            System.err.println("Error reading CSV file: " + e.getMessage());
	        }
	        return mc1;
	}
}

