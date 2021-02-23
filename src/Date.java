/**
 * Properties of a Date.
 * Includes constructors, getter methods, and isValid to check for valid dates.
 * @author Alexander Galvan, Yuan Zhao
 */
package src;
import java.util.Calendar;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;
    
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;
    public static final int BEFORE1900 = 1900;
    public static final int MONTHS_FIRST_DAY = 1;
    public static final int MONTHS_31DAYS = 31;
    public static final int MONTHS_30DAYS = 30;
    public static final int LEAPYEAR = 29;
    public static final int NORMALYEAR = 28;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    //taking mm/dd/yyyy and create a Date object
    /**
     * Basic constructor for Date that takes a string and splits it.
     * @param date is the string to be split
     */
    public Date(String date){
        String dates[] = date.split("/");
		month = Integer.parseInt(dates[0].trim());
		day = Integer.parseInt(dates[1].trim());
		year = Integer.parseInt(dates[2].trim());
	}

    //creating an object with today's date (see Calendar class)
    /**
     * Default constructor that sets Date attributes to current date.
     */
    public Date(){
        Calendar cal = Calendar.getInstance();

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);
    }
    
    /**
     * To get the year of Date.
     * @return int of the the year
     */
    public int getYear(){
		return this.year;
	}
	
    /**
     * To get the month of Date.
     * @return int of the month
     */
	public int getMonth(){
		return this.month;
	}
	
	/**
	 * To get the day of Date.
	 * @return int of the day
	 */
	public int getDay(){
		return this.day;
	}

	/**
	 * Checks the validity of a date.
	 * Checks for future dates, dates before 1900, correct days in month, and leap years.
	 * @return true if the date is valid, false if it is not
	 */
    public boolean isValid(){
        Calendar currentDate = Calendar.getInstance();
        Calendar thisDate = Calendar.getInstance();
            thisDate.set(year, month, day);

        
        if(year < BEFORE1900){
            return false;
        }

        if(thisDate.after(currentDate)){
            return false;
        }

        if (month > DECEMBER || month < JANUARY) {
			return false;
		}
		if (day > MONTHS_31DAYS || day < MONTHS_FIRST_DAY) {
			return false;
		}
		// ensures for months April,June,September, and November do not have more than
		// 30 days
		if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && day > MONTHS_30DAYS) {
			return false;
		}
		// ensures Feburary has no more than 28 days on non leapyears, and 29 on
		// leapyears
		if ((month == FEBRUARY && !leapYear(year) && day > NORMALYEAR) || (month == FEBRUARY && leapYear(year) && day > LEAPYEAR)) {
			return false;
		}

		return true;
        
    }

    // User created method, checks if there is a leap year
    /**
     * Checks if the year is a leap year.
     * @param year to be checked
     * @return true if it is a leap year, false if it is not
     */
	private static boolean leapYear(int year) {
		if (year % QUADRENNIAL == 0) {
			if (year % CENTENNIAL == 0) {
				if (year % QUATERCENTENNIAL == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Represent date as a string.
	 * @return String of date representation
	 */
	@Override
	public String toString() {
		return month + "/" + day + "/" + year;
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Date date) { //return 1, 0, or -1
		if(year < date.getYear())
			return -1;
		else if(year > date.getYear())
			return 1;
		else {
			if(month < date.getMonth())
				return -1;
			else if(month > date.getMonth())
				return 1;
			else {
				if(day < date.getDay())
					return -1;
				else if(day > date.getDay())
					return 1;
				
				else
					return 0;
			}
		}
	}
	
	/**
	 * Testbed for isValid method.
	 * Checks all cases for possible errors.
	 * @return void
	 */
	public static void main(String[] args) {
		Date currentDate = new Date(); //test case for default constructor
		Date validDate = new Date("03/01/2003"); //valid test case using constructor  
		Date before1900 = new Date("01/11/1899"); //invalid test case; year is before 1900
		Date afterCurrentYear = new Date("01/11/2030"); //invalid test case; year is after current date
		Date afterCurrentMonth = new Date("03/11/2021");
		Date validLeapyear = new Date("02/29/2000"); //valid test case; year 2000 was a leapyear
		Date invalidLeapYear = new Date("02/29/2019"); //invalid test case; year 2019 was not a leapyear
		Date invalidMonth = new Date("13/03/2020");
		Date invalidMonthDay = new Date("12/32/2020");
		Date invalid_30_DayMonth = new Date("04/31/2020");
		Date invalid_31_DayMonth = new Date("03/32/2020");
		
		if(currentDate.isValid())
			System.out.println("currentDate is valid! " + currentDate.toString());
		if(validDate.isValid())
			System.out.println("validDate is valid! " + validDate.toString());
		if(!before1900.isValid())
			System.out.println("before1900 is invalid! " + before1900.toString());
		if(!afterCurrentYear.isValid())
			System.out.println("afterCurrentYear is invalid! " + afterCurrentYear.toString());
		if(!afterCurrentMonth.isValid())
			System.out.println("afterCurrentMonth is invalid! " + afterCurrentMonth.toString());
		if(validLeapyear.isValid())
			System.out.println("validLeapyear is valid! " + validLeapyear.toString());
		if(!invalidLeapYear.isValid())
			System.out.println("invalidLeapYear is invalid! " + invalidLeapYear.toString());
		if(!invalidMonth.isValid())
			System.out.println("invalidMonth is invalid! " + invalidMonth.toString());
		if(!invalidMonthDay.isValid())
			System.out.println("invalidMonthDay is invalid! " + invalidMonthDay.toString());
		if(!invalid_30_DayMonth.isValid())
			System.out.println("invalid_30_DayMonth is invalid! " + invalid_30_DayMonth.toString());
		if(!invalid_31_DayMonth.isValid())
			System.out.println("invalid_31_DayMonth is invalid! " + invalid_31_DayMonth.toString());
		
	}
}
