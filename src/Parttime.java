package src;

public class Parttime extends Employee {
	private int hours;
	private double hourlyRate;
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHourlyRate(double rate) {
		hourlyRate = rate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	@Override
	public void calculatePayment() {
		if(hours > 80) {
			if(hours > 100)
				hours = 100;
			super.setPayment((hours * hourlyRate) + (hours-80 * (hourlyRate * 1.5)));
		}
		
		else
			super.setPayment(hours * hourlyRate);
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals(Object obj) { //compare name, department, and date hired
		if(obj == null)
			return false;
		
		else if(obj instanceof Parttime) {
			Parttime aParttime = (Parttime)obj;
			return hours != aParttime.getHours() ? false : (hourlyRate != aParttime.getHourlyRate() ? false : true);
		}
		
		else 
			return false;
		
	}
}
