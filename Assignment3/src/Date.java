/* Name: Keith Reis
 * Program Name: Date
 * Due Date: 3/14/22
 * Description: My own version of Calendar and Date
 * Assistance: None
 */
public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(int day, int month) {
		this.day = day;
		this.month = month;
		this.year = 2000;
	}
	
	public Date(int day) {
		this.day = day;
		this.month = 1;
		this.year = 2000;
	}
	
	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}
	
	public void advance() {
		if(day == 31) {
			day = 1;
			if(month == 12) {
				month = 1;
				year++;
			} else
				month++;
		} else if (day == 30 && (month == 4 || 
				month == 6 || month == 9 || month == 11)){
			day = 1;
			month++;
		} else if (day == 28 && month == 2 && 
				!(year%4 == 0 && (year%100 != 0 || year%400 == 0))) {
			day = 1;
			month++;
		} else if (day == 28 && month == 2 && 
				(year%4 == 0 && (year%100 != 0 || year%400 == 0))) {
			day++;
		} else if (day == 29 && month == 2) {
			day = 1;
			month++;
		} else
			day++;
	}
	
	public boolean equals(Object o) {
		try {
			if(((Date)o).daysSince() == this.daysSince()) {
				return true;
			}
		} catch(ClassCastException e) { // if Object o isn't a Date Object
			
		}
		return false;
	}
	
	public int compareTo(Date date) {
		if((date.daysSince() == daysSince()))
			return 0;
		else if(date.daysSince() > daysSince())
			return -(date.daysSince() - daysSince());
		else
			return (daysSince() - date.daysSince());
	}
	
	public String dayOfWeek() {
		// 1/1/0000 is a Friday
		// Friday, Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday
		
		int days = daysSince();
		int currentYear = year;
		
		while(currentYear != 1) {
			if((currentYear%4 == 0 && (currentYear%100 != 0 || currentYear%400 == 0))) {
				currentYear--;
				days -= 2;
			} else {
				currentYear--;
				days--;
			}
			
		}
		String dayOfWeek = null;
		
		switch(days%7) {
		case 0:
			dayOfWeek = "Friday";
			break;
		case 1:
			dayOfWeek = "Saturday";
			break;
		case 2:
			dayOfWeek = "Sunday";
			break;
		case 3:
			dayOfWeek = "Monday";
			break;
		case 4:
			dayOfWeek = "Tuesday";
			break;
		case 5:
			dayOfWeek = "Wednesday";
			break;
		case 6:
			dayOfWeek = "Thursday";
			break;
		default:
			dayOfWeek = "Error";
			break;
		}
		
		return dayOfWeek;
	}
	
	public boolean isValid() {
		boolean valid = false;
		if(month == 4 || month == 6 || month == 9 || month == 11)
			if(day <= 30)
				valid = true;
		if(month == 1 || month == 3 || month == 5 || month == 7 
				|| month == 8 || month == 10 || month == 12) 
			if(day <= 31)
				valid = true;
		if(month == 2) {
			if(day <= 29 && (year%4 == 0 && (year%100 != 0 || year%400 == 0)))
				valid = true;
			else if (day <= 28 && !(year%4 == 0 && (year%100 != 0 || year%400 == 0)))
				valid = true;
		}
		return valid;
	}
	
	public int daysSince() {
		
		int amountOfDays = 0;
		int currentDay = day;
		int currentMonth = month;
		int currentYear = year;
		
		boolean currentDayTest = false;
		while(currentDay != 1) {
			currentDay--;
			amountOfDays++;
			currentDayTest = true;
		}
		if(currentDayTest) {
			currentMonth--;
		}
		
		while(currentMonth >= 1) {
			if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 
					|| currentMonth == 10 || currentMonth == 12) {
				currentMonth--;
				amountOfDays += 31;
			} else if (currentMonth == 4 || currentMonth == 6 || 
					currentMonth == 9 || currentMonth == 11) {
				currentMonth--;
				amountOfDays += 30;
			} else if (currentMonth == 2 && !(currentYear%4 == 0 && 
					(currentYear%100 != 0 || currentYear%400 == 0))) {
				currentMonth--;
				amountOfDays += 28;
			} else {
				currentMonth--;
				amountOfDays += 29;
			}
		}
		
		
		amountOfDays += currentYear * 365 + currentYear/4 - currentYear/100 + currentYear/400;
		
		return amountOfDays;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	public static void main(String[] args) {
		Date date = new Date(14, 3, 2022);
		Date date2 = new Date(2, 5, 0004);
		Date date3 = new Date(3, 5, 0004);
		Date invalidDate = new Date (40, 57, 2003);
		
		System.out.println(invalidDate + " is a valid date: " + invalidDate.isValid());
		System.out.println(date + " is a valid date: " + date.isValid());
		
		System.out.println();
		
		System.out.println(date);
		System.out.println(date.dayOfWeek());
		System.out.println(date.daysSince());
		date.advance();
		System.out.println("Advancing date");
		System.out.println(date);
		System.out.println(date.dayOfWeek());
		System.out.println(date.daysSince());
		
		System.out.println();
		
		System.out.println(date2.daysSince());
		System.out.println(date3.daysSince());
		System.out.println(date3.compareTo(date2));
		System.out.println(date2.compareTo(date3));
		System.out.println(date2.compareTo(date2));
		
		System.out.println();
		
		Object empty = new Object();
		Object incorrectDate = new Date(2, 5, 0004);
		Object correctDate = new Date(3, 5, 0004);
		System.out.println(date3.equals(empty));
		System.out.println(date3.equals(incorrectDate));
		System.out.println(date3.equals(correctDate));
	}
}
