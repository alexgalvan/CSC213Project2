package src;

/**
 * Fulltime class,driver from Employee.
 * This class store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Fulltime extends Employee {
	private double salary;
	
	/*
     * Fulltime Constructor
     * 
     * @param profile information about fulltime employee
     * @param salary for employee
     */
	public Fulltime(Profile profile, int salary) {
		super(profile);
		this.salary = salary;
	}
	
	/**
	 * Get salary of fulltime employee
	 * 
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Set salary of fulltime employee
	 * 
	 * @param salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
     * Calculate total payment of full time employee
     */
	@Override
	public void calculatePayment() {
		super.setPayment(getSalary()/26);
	}
	
	@Override
    public String toString() {
        return super.toString() + "FULL TIME" + "::" + "Annual Salary $" + String.format("%,.2f", salary);
    }
	
	@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
