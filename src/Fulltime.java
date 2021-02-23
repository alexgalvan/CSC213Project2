package src;

public class Fulltime extends Employee {
	private int salary;
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public void calculatePayment() {
		super.setPayment(getSalary()/26);
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Fulltime) {
			Fulltime aFulltime = (Fulltime)obj;
			return salary != aFulltime.getSalary() ? false : true;
		}
		
		else 
			return false;
		
	}
}
