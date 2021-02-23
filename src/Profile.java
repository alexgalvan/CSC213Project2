package src;

public class Profile {
	private String name; //employees name in the form "last name, first name"
	private String department; // department code: CS, ECE, IT
	private Date dateHired;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return department;
	}
	
	public void setDept(String dept) {
		department = dept;
	}
	
	public Date getDate( ) {
		return dateHired;
	}
	
	public void setDate(Date date) {
		dateHired = date;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Profile) {
			Profile aProfile = (Profile)obj;
			return name != aProfile.getName() ? false : (department != aProfile.getDept() ? false : (dateHired != aProfile.getDate() ? false : true));
		}
		
		else 
			return false;
		
	}

}
