
public class PhoneNumberGuesser {

	public static void main(String[] args) {
		
		int attempt1 = 0;
		int attempt2 = 0;
		int attempt3 = 0;
		int attempt4 = 0;
		int attempt5 = 0;
		
		String phoneNumber = "000-000-0000";
		
		String myPhoneNumber = "240-501-9148";
		
		
		int firstSection = 0;
		int secondSection = 0;
		int thirdSection = 0;
		
		while(!phoneNumber.equals(myPhoneNumber)) {
			firstSection = (int)(Math.random() * 1000);
			secondSection = (int)(Math.random() * 1000);
			thirdSection = (int)(Math.random() * 10000);
			
			phoneNumber = firstSection + "-" + secondSection + "-" + thirdSection;
			attempt1++;
		}
		System.out.println("Exited 1");
		System.out.println("1 took " + attempt1 + " attempts");
		
		phoneNumber = "000-000-0000";
		
		while(!phoneNumber.equals(myPhoneNumber)) {
			firstSection = (int)(Math.random() * 1000);
			secondSection = (int)(Math.random() * 1000);
			thirdSection = (int)(Math.random() * 10000);
			
			phoneNumber = firstSection + "-" + secondSection + "-" + thirdSection;
			attempt2++;
		}
		System.out.println("Exited 2");
		System.out.println("2 took " + attempt2 + " attempts");
		phoneNumber = "000-000-0000";
		
		while(!phoneNumber.equals(myPhoneNumber)) {
			firstSection = (int)(Math.random() * 1000);
			secondSection = (int)(Math.random() * 1000);
			thirdSection = (int)(Math.random() * 10000);
			
			phoneNumber = firstSection + "-" + secondSection + "-" + thirdSection;
			attempt3++;
		}
		System.out.println("Exited 3");
		System.out.println("3 took " + attempt3 + " attempts");
		phoneNumber = "000-000-0000";
		
		while(!phoneNumber.equals(myPhoneNumber)) {
			firstSection = (int)(Math.random() * 1000);
			secondSection = (int)(Math.random() * 1000);
			thirdSection = (int)(Math.random() * 10000);
			
			phoneNumber = firstSection + "-" + secondSection + "-" + thirdSection;
			attempt4++;
		}
		System.out.println("Exited 4");
		System.out.println("4 took " + attempt4 + " attempts");
		phoneNumber = "000-000-0000";
		
		while(!phoneNumber.equals(myPhoneNumber)) {
			firstSection = (int)(Math.random() * 1000);
			secondSection = (int)(Math.random() * 1000);
			thirdSection = (int)(Math.random() * 10000);
			
			phoneNumber = firstSection + "-" + secondSection + "-" + thirdSection;
			attempt5++;
		}
		System.out.println("Exited 5");
		System.out.println("5 took " + attempt5 + " attempts");
		
	}

}
