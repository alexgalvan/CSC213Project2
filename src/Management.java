package src;

/**
 * Management class, driver from Fulltime.
 * This class store profile information and payment of a full-time employee with a management role
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Management extends Fulltime {
	private int position;
	private static final int MANAGER = 1;
	private static final int DEPARTMENT_HEAD = 2;
	private static final int DIRECTOR = 3;
	
	/**
	 * Management constructor
	 * 
     * @param profile        information about fulltime employee
     * @param salary         salary for employee
     * @param position		 position held by management employee
     */
	public Management(Profile profile, int salary, int position) {
		super(profile, salary);
		this.position = position;
	}
	
	/**
	 * Set the position held
	 * 
	 * @param position of employee
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Get the position held in String form
	 * 
	 * @return	String of position
	 */
	public String getPositionString() {
		return position == MANAGER ? "Manager" : (position == DEPARTMENT_HEAD ? "Department Head" : "Director");
	}

	/**
	 * Get the position held in Integer form
	 * 
	 * @return int of position
	 */
	public int getPositionInt() {
		return position;
	}
	
	/**
	 * Get the compensation due for management position
	 * 
	 * @return double compensation
	 */
	public double getManagementCompensation() {
		return position == MANAGER ? 5000.0/26 : (position == DEPARTMENT_HEAD ? 9500.0/26 : 12000.0/26);
	}
	
	/*
	 * Calculate total payment of management employee
	 */
	@Override
	public void calculatePayment( ) {
		if(position == MANAGER) {
			super.setPayment(super.getSalary()/26 + getManagementCompensation());
		}
		else if(position == DEPARTMENT_HEAD) {
			super.setPayment(super.getSalary()/26 + getManagementCompensation());
		}
		
		else if(position == DIRECTOR) {
			super.setPayment(super.getSalary()/26 + getManagementCompensation());
		}
	}
	
	@Override
    public String toString() {
        return super.toString() + "::" + getPositionString() + " Compensation $" + String.format("%,.2f", getManagementCompensation());
    }
	
	@Override
	public boolean equals(Object obj) {
	    return super.equals(obj);
	}
}
