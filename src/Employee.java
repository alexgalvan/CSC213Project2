package src;

/**
 * Employee class,store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Employee {

	private Profile profile;
	private double payment;
	
	/**
     * Employee constructor
     *
     * @param profile hold infomation about employee
     */
	public Employee(Profile profile) {
		this.profile = profile;
		payment = 0;
	}
	
	/**
	 * Calculate total payment,subclass should override this method
	 */
	public void calculatePayment() {
	}
	
	/**
     * Get profile of the employee
     *
     * @return Profile
     */
	public Profile getProfile() {
		return profile;
	}
	
	/**
	 * Set name, department, and date hired of a profile
	 * 
	 * @param aProfile
	 */
	public void setProfile(Profile aProfile) {
		profile.setName(aProfile.getName());
		profile.setDepartment(aProfile.getDepartment());
		profile.setDateHired(aProfile.getDateHired());
	}
	
	/**
     * Get total payment
     *
     * @return payment
     */
	public double getPayment() {
		return payment;
	}
	
	/**
     * Set total payment
     *
     * @param payment new payment
     */
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	@Override
    public String toString() {
        String payment = String.format("%,.2f", this.getPayment());
        return profile.toString() + "::Payment $" + payment + "::";
    }
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Employee) {
			Employee anEmployee = (Employee)obj;
			return profile.equals(anEmployee.getProfile());
			//return profile != anEmployee.getProfile() ? false : true;
		}
		
		else 
			return false;
	}
}
