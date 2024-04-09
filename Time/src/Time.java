
public class Time {
	private int seconds, minutes, hours;
	
	public Time(int argSeconds, int argMinutes, int argHours) {
		seconds = argSeconds;
		minutes = argMinutes;
		hours = argHours;
	}
	
	public Time(int argMinutes, int argHours) {
		this(0, argMinutes, argHours);
	}
	
	public Time(int argHours) {
		this(0, argHours);
	}
	
	public Time() {
		this(0);
	}
	
	public String toString() {
		return String.format("%2d:%02d:%02d", hours, minutes, seconds);
	}
	
	public void addSecond() {
		seconds++;
		if(seconds == 60) {
			seconds = 0;
			addMinute();
		}
		
	}
	
	public void addMinute() {
		minutes++;
		if(minutes == 60) {
			minutes = 0;
			addHour();
		}
	}
	
	public void addHour() {
		hours++;
		if(hours == 24) {
			hours = 0;
		}
	}
	
	public static void main(String[] args) {
		Time time1 = new Time(15, 2, 8);
		System.out.println(time1);
		Time time2 = new Time(45, 59, 23);
		System.out.println(time2);
		while(true) {
			System.out.println();
			System.out.println(time1);
			System.out.println(time2);
			System.out.println();
			System.out.println();
			
			time1.addSecond();
			time2.addSecond();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
