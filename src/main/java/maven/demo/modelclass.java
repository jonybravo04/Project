package maven.demo;

class modelclass {
	private int empID;
	private String empName;
	private String designation;
	private String location;
	
	public modelclass(int empID, String empName, String designation, String location) {
		this.empID=empID;
		this.empName=empName;
		this.designation = designation;
		this.location = location;

	}
	
/*	public modelclass() {
		
	}
*/

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
