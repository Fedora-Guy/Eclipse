import java.util.Scanner;

public class LabWeek3Sect3 {
	public static void main (String[] args0 ) {
		final int DAYS_OF_WEEK = 7;
		int weeks = 365 / DAYS_OF_WEEK;
		System.out.println("There are " + weeks + " weeks in a year");
		
		System.out.print("If we use print then there is no newline after our text");
		System.out.println("but if we use println there is !");
		System.out.println("\"");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number:");
		int x = input.nextInt();
		
		input.nextLine();
		System.out.print("Enter a string:");
		String line = input.nextLine();
		System.out.println(x + line);
		
		String one = input.next();
		String two = input.next();
		String three = input.next();
		String four = input.next();
		System.out.println("lets count words! " + one + two + three + four);
		
		
		
		String a = "This is my string";
		a = a.toUpperCase();
		System.out.println(a);
		a = a.toLowerCase();
		System.out.println(a);
		System.out.println(a.length());
		String b = a.substring(4, 7);
		System.out.println(b);
		b = a.substring(a.indexOf('i', a.indexOf('i')), a.indexOf('i', a.indexOf('i')) +2);
		System.out.println(b);
		
		b = b.replaceFirst("is", "changed!");
		System.out.println(b);
		
		String c = "this string is my favorite string its a nice string";
		c = c.replaceAll("string", "word");
		System.out.println(c);
		c = c.replaceAll(" ", "");
		System.out.println(c);
		
		String toTrim = "         \n       so many spaces!!  \t     ";
		System.out.println(toTrim);
		toTrim = toTrim.trim();
		System.out.println(toTrim);
		
		
		
		
		
		int solution = (6 * (3 + 1) ) % 2;
		int wrong = 6 * 3 + 1 % 2;
		
		System.out.println(solution + " " + wrong);
		input.close();
		
	}
}
