package src;

/**
 * Profile class,store information about a employee,including name, department,hired date.
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Profile {
	private String name; //employees name in the form "last name, first name"
	private String department; // department code: CS, ECE, IT
	private Date dateHired;
	
	/**
     * Profile constructor
     *
     * @param name       of the employee
     * @param department of the employee
     * @param dateHired  hired date of the employee
     */
	public Profile(String name, String department, Date dateHired) {
		this.name = name;
		this.department = department;
		this.dateHired = dateHired;
	}
	
	/**
     * Get name of the employee
     * @return  name
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the employee
	 * 
	 * @param name of employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Get department of the employee
     * 
     * @return department of employee
     */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Set the department of employee
	 * 
	 * @param dept of employee
	 */
	public void setDepartment(String dept) {
		department = dept;
	}
	
	/**
     * Get hired date of the employee
     * 
     * @return hired date
     */
	public Date getDateHired() {
		return dateHired;
	}
	
	/**
	 * Set the date hired of the employee
	 * 
	 * @param date hired
	 */
	public void setDateHired(Date date) {
		dateHired = date;
	}
	
	@Override
	public String toString() {
		return name + "::" + department + "::" + dateHired.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile p = (Profile) obj;
            return name.equals(p.getName()) && department.equals(p.getDepartment()) && dateHired.compareTo(p.getDateHired()) == 0;
        }
        return false;
    }

}
