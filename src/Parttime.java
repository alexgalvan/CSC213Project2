package src;

/**
 * Parttime class, driver from Employee.
 * This class store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Parttime extends Employee {
	private int hoursWorked;
	private double hourlyRate;
	
	/**
	 * Parttime constructor to set profile
	 * 
	 * @param profile information of parttime employee
	 */
	public Parttime(Profile profile) {
		super(profile);
		hourlyRate = 0;
	}
	
	/**
	 * Parttime constructor to set profile and hourlyRate
	 * 
	 * @param profile information of parttime employee
	 * @param hourlyRate of parttime employee
	 */
	public Parttime(Profile profile, double hourlyRate) {
		super(profile);
		this.hourlyRate = hourlyRate;
	}
	
	/**
	 * Set hours worked by parttime employee
	 * 
	 * @param hoursWorked to set
	 */
	public void setHoursWorked(int hoursWorked) {
		if(hoursWorked < 100 && hoursWorked > 0)
			this.hoursWorked = hoursWorked;
	}
	
	/**
	 * Get hours worked from parttime employee
	 * 
	 * @return int hours worked
	 */
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	/**
	 * Set the hourly rate of parttime employee
	 * 
	 * @param rate to set
	 */
	public void setHourlyRate(double rate) {
		hourlyRate = rate;
	}
	
	/**
	 * Get the hourly rate of parttime employee
	 * 
	 * @return double hourly rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	/**
	 * Calculate the payment for parttime employee
	 */
	@Override
	public void calculatePayment() {
		if(hoursWorked > 80) {
			super.setPayment((hoursWorked * hourlyRate) + ((hoursWorked-80) * (hourlyRate * 1.5)));
		}
		
		else
			super.setPayment(hoursWorked * hourlyRate);
	}
	
	@Override
    public String toString() {
        return super.toString() + "PART TIME" + "::" + "Hourly Rate $"
                + String.format("%,.2f", this.hourlyRate) + "::"
                + "Hours worked this period: " + this.hoursWorked;
    }
	
	 @Override
	    public boolean equals(Object obj) {
	        return super.equals(obj);
	    }
}
