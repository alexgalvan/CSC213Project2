package src;

/**
 * Company Class,store all the employees and number of employees
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Company {

	private Employee[] emplist;
	private int numEmployee;
	
	private static final int BUFFER_SIZE = 4;
	
	public Company() {
		numEmployee = 0;
		emplist = new Employee[BUFFER_SIZE];
	}
	
	/**
     * Find the position of given employee
     *
     * @param employee given employee
     * @return index in emplist,-1 if not find
     */
	private int find(Employee employee) {
		if (employee.getProfile() == null) {
            return -1;
        }
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].equals(employee)) {
                return i;
            }
        }
        return -1;
	}
	
	 /**
     * Grow the capacity by 4 if the array is full
     */
	private void grow() {
        Employee[] newEmployeeList = new Employee[emplist.length + BUFFER_SIZE];
        for (int i = 0; i < emplist.length; i++) {
            newEmployeeList[i] = emplist[i];
        }
        emplist = newEmployeeList;
	}
	
	/**
     * Add one employee.
     * Check the profile before adding.
     *
     * @param employee should be a new employee
     * @return true if add succeed,false if add before
     */
	public boolean add(Employee employee) { //check the profile before adding
		if (find(employee) >= 0) {
            return false;
        }
		
        if (emplist.length == numEmployee) {
            grow();
        }
        
        emplist[numEmployee] = employee;
        numEmployee++;
        return true;
	}
	
	/**
     * maintain the original sequence
     *
     * @param employee
     * @return
     */
	public boolean remove(Employee employee) { //maintain the original sequence
		int pos = find(employee);
        if (pos >= 0) {
            for (int i = pos; i < numEmployee - 1; i++) {
                emplist[i] = emplist[i + 1];
            }
            numEmployee -= 1;
            emplist[numEmployee] = null;
            return true;
        }
        return false;
	}
	
	/**
     * set working hours for a part time
     *
     * @param employee parttime employee
     * @return true if set succeed
     */
	public boolean setHours(Employee employee) { //set working hours for a part time employee
		if (employee instanceof Parttime) {
            Parttime parttime = (Parttime) employee;
            int hoursWorked = parttime.getHoursWorked();
            if (hoursWorked < 0) {
                return false;
            }
            int pos = find(employee);
            if (pos < 0) {
                return false;
            }
            Employee e = emplist[pos];
            //checking if employee in list is a part time employee
            if (e instanceof Parttime) {
            	Parttime ourParttime = (Parttime) e;
            	
            	if(hoursWorked > 100)
            		ourParttime.setHoursWorked(100);
            	else
            		ourParttime.setHoursWorked(hoursWorked);
                return true;
            } 
            else 
                return false;
            
        }

        return false;
	}
	
	/**
     * Get number of employees
     *
     * @return number
     */
    public int getNumEmployee() {
        return numEmployee;
    }

    /**
     * Checkout if company has no employee
     *
     * @return true is empty
     */
    public boolean isEmpty() {
        return getNumEmployee() == 0;
    }
	
    /**
     * process payments for all employees
     */
	public void processPayments() { //process payments for all employees
		for (int i = 0; i < numEmployee; i++) {
            emplist[i].calculatePayment();
        }
	}
	
	/**
     * print earning statements for all employees
     */
	public void print() { //print earning statements by actual list
		for (int i = 0; i < numEmployee; i++) {
            System.out.println(emplist[i].toString());
        }
	}
	
	/**
     * Print earning statements by department
     */
	public void printByDepartment() { //print earning statements by department
		 //sort by department first
		Employee[] templist = new Employee[numEmployee];
		System.arraycopy(emplist, 0, templist, 0, numEmployee);
		
        for (int i = 0; i < numEmployee; i++) {
            for (int j = 1; j < numEmployee - i; j++) {
                String d1 = templist[j - 1].getProfile().getDepartment();
                String d2 = templist[j].getProfile().getDepartment();
                if (d1.compareTo(d2) >= 0) {
                    Employee temp = templist[j - 1];
                    templist[j - 1] = templist[j];
                    templist[j] = temp;
                }
            }
        }
        
        for (int i = 0; i < numEmployee; i++) {
            System.out.println(templist[i].toString());
        }
	}
	
	/**
     * Print earning statements by date hired
     */
	public void printByDate() { //print earning statements by date hired
		//sort by hired date
		Employee[] templist = new Employee[numEmployee];
		System.arraycopy(emplist, 0, templist, 0, numEmployee);
		
        for (int i = 0; i < numEmployee; i++) {
            for (int j = 1; j < numEmployee - i; j++) {
                Date d1 = templist[j - 1].getProfile().getDateHired();
                Date d2 = templist[j].getProfile().getDateHired();
                if (d1.compareTo(d2) >= 0) {
                    Employee temp = templist[j - 1];
                    templist[j - 1] = templist[j];
                    templist[j] = temp;
                }
            }
        }
        
        for (int i = 0; i < numEmployee; i++) {
            System.out.println(templist[i].toString());
        }

	}
	
}
