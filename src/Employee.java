package src;

public class Employee {

	private Profile profile;
	private double payment;
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile aProfile) {
		profile.setName(aProfile.getName());
		profile.setDept(aProfile.getDept());
		profile.setDate(aProfile.getDate());
	}
	
	public double getPayment() {
		return payment;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Employee) {
			Employee anEmployee = (Employee)obj;
			return profile != anEmployee.getProfile() ? false : true;
		}
		
		else 
			return false;
		
	}
	public void calculatePayment() {
		
	}
}
