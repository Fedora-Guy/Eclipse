import java.util.Scanner;

public class KeithReisHW5 {
	public static void main (String[] args) {
		// Question 1
		
		// Welcome Message
		System.out.println("Welcome to the training hall!"); 
		
		// Variables
		int playerHealth = 100;
		int opponentHealth = 100;
		boolean fighting = true;
		Scanner s = new Scanner(System.in);
		
		
		while (fighting)
		{
			System.out.println("What would you like to do? Attack or Quit?");
			String Response = s.nextLine();
			String reply = "";
			if(Response.equalsIgnoreCase("attack")) {
				
				do 
				{
					
					while(fighting) {
						
						int playerDamage = (int) (Math.random()*20.0)+1;
						int opponentDamage = (int) (Math.random()*20.0)+1;
						playerHealth -= opponentDamage;
						opponentHealth -= playerDamage;
						if(playerHealth <= 0 || opponentHealth <= 0) {
							fighting = false;
							reply = "no";
							break;
						}
						System.out.println("Your character's Health is " + playerHealth);
						System.out.println("Your opponent's Health is " + opponentHealth);
						fighting = false;
						System.out.println("Do you wish to continue fighting? \"Yes\" or \"No\"");
						reply = s.nextLine();
					}
					
					if(reply.equalsIgnoreCase("Yes")) {
						fighting = true;
					} else if (reply.equalsIgnoreCase("no")) {
						Response = "Gave up";
						break;
					} else {
						System.out.println("Sorry I didn't understand you, can you repeat it again? \"Yes\" or \"No\"?");
						reply = s.nextLine();
					}
				} while(Response.equalsIgnoreCase("attack") && playerHealth >0 && opponentHealth >0);
				
				if(playerHealth <= 0) {
					System.out.println("Give training a rest; come back when you are a real challenge!");
					fighting = false;
				} else if (opponentHealth <= 0 ) {
					System.out.println("I yield! Nice fighting techinques!");
					fighting = false;
				} else {
					System.out.println("You give up? Fair enough. See that your wounds are tended to!");
					System.out.println("Your character's Health was " + playerHealth);
					System.out.println("Your opponent's Health was " + opponentHealth);
					fighting = false;
				}
				
			} else if (Response.equalsIgnoreCase("Quit")) {
				System.out.println("Why approach the hall if not to fight? Get lost!");
				fighting = false;
				
			} else {
				System.out.println("I didn't hear you, you will have to speak louder"
						+ " and clearer. Do you wish to \"Attack\" or \"Quit\"?");
			}
		} 
		s.close();
		System.out.println("Thank you for playing, come again soon!");
		
		
	}
}
