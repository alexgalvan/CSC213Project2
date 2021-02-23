package src;

public class Profile {
	private String name; //employees name in the form "lastname, firstname"
	private String department; // department code: CS, ECE, IT
	private Date dateHired;
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		return false;
	}

}
