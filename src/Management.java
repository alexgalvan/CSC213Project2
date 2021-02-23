package src;

public class Management extends Fulltime {
	private int position;
	private static final int Manager = 1;
	private static final int DepartmentHead = 2;
	private static final int Director = 3;
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	@Override
	public void calculatePayment( ) {
		if(position == Manager) {
			super.setPayment(super.getSalary()/26 + 5000);
		}
		else if(position == DepartmentHead) {
			super.setPayment(super.getSalary()/26 + 9500);
		}
		
		else if(position == Director) {
			super.setPayment(super.getSalary()/26 + 12000);
		}
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Management) {
			Management aManagement = (Management)obj;
			return position != aManagement.getPosition() ? false : true;
		}
		
		else 
			return false;
		
	}
}
