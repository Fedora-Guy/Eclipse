import java.util.Scanner;

public class KeithReisBranchingInteractions {
	public static void main(String[] args) {
		// Disclaimer
		// This is first and foremost my take on the Zork Game Genre.
		// This won't include every option from it, nor will it
		// include the same level of adventure options because
		// I am not that skilled of a programmer, and even as I
		// submit this I see that I could have simplified some code
		// or even removed whole sections. That being said, hopefully
		// you enjoy it. 
		
		
		// global variables and objects
		Scanner s = new Scanner(System.in);
		String response = null;
		boolean pickupItem = true;
		boolean useItem = true;
		boolean adventureAwaits = true;
		boolean visitedShack = false;
		boolean visitedRuins = false;
		boolean visitedJungle = false;
		int roundsPassed = 0;
		int roundsEscape = 4;
		int roundsInMaze = 0;
		boolean altarTriggered = false;
		boolean vinesCut = false;
		boolean maze = false;
		
		// items in Inventory - All the items used throughout the game; You start with nothing.
		boolean gotShovel = false;
		boolean gotBucket = false;
		boolean gotTorch = false;
		boolean gotMap = false;
		boolean gotMachete = false;
		
		// item modifiers - if the item has multiple states, it's values are initialized and declared here.
		boolean litTorch = false; 
		boolean derustShovel = false;
		boolean filledBucket = false;
		boolean completedMap = false;
		String bucketLiquid = "";
		boolean useTorchProperly = false;
		String inventory = "";
		
		// LocationTracker
		int north = 0, west = 1, central = 2, east = 3, south = 4;
		int shack = 5, ruins = 6, jungle = 7, rainbow = 8, crack = 9;
		int locationTracker = central;
		int lastPosition = central;
		// 0 = North, 1 = West, 2 = Central, 3 = East, 4 = South, 
		// 5 = Shack, 6 = Ruins, 7 = Jungle, 8 = Rainbow, 9 = Crack
		
		// MazeTracker
		boolean mazeNow = false; // Determines if we are in a maze or not.
		int northMaze = 1, southMaze = 2, eastMaze = 3, westMaze = 4;
		// 1 = North Maze, 2 = South Maze, 3 = East Maze, 4 = West Maze;
		int mazeDirection = 0; // What the next Direction the maze goes in.
		int playerDirection = 0; // What the player's direction in the maze is.
		int randomDirection = 0; // A random direction used for incomplete map.
		int mazeEscapage = 0; // If we get 3 or more consecutively correct directions, the player escapes the maze.
		int previousDirection = 0; // What the correct previous direction was; used for the correct direction method.
		
		// historyTracker - keeps a track of the History for a print out at the end.
		String historyTracker = "";
		
		// currentEvent - string to put current events in a text for a System.out.println();
		String currentEvent = "";
		
		// introduction speech
		System.out.println("Hello there, and welcome to Keith's mini Zork Adventure!");
		System.out.println();
		System.out.println("You awake in front of a strange, weirdly dark \'ruins\'! To the North you see a shoreline, ");
		System.out.println("to the East you see mountains, to the West, you see a forest, and lastly to the South you see valley.");
		System.out.println("Where do you wish to go?");
		System.out.println("[Type \"Help\" to see what commands you have at your options]");
		historyTracker += "You started the game. \n";
		
		// Main Code
		while(adventureAwaits) {
			response = s.nextLine(); // Get's user input
			
			// If user doesn't know what commands are available, they can do "Help" to see.
			if(response.equalsIgnoreCase("help")) { // Help commands - Start
				System.out.println("Commands you can currently do:");
				if(locationTracker == south ||  locationTracker == central) {
					System.out.print("\"North\", "); // If they can go North from their current position.
				}
				if(locationTracker == north ||  locationTracker == central) {
					System.out.print("\"South\", "); // If they can go South from their current position.
				}
				if(locationTracker == west ||  locationTracker == central) {
					System.out.print("\"East\", "); // If they can go East from their current position.
				}
				if(locationTracker == east ||  locationTracker == central) {
					System.out.print("\"West\", "); // If they can go West from their current position.
				}
				if(locationTracker == north || locationTracker == central || locationTracker == west || 
						locationTracker == south || locationTracker == east) { // Help Enter commands - Start
					System.out.print("\"Enter\", "); // If they can enter anywhere from their current position.
					if(locationTracker == north && visitedShack == true)
						System.out.print("\"Enter Shack\", "); // If they can enter the shack from their current position.
					if(locationTracker == north && visitedShack == false)
						System.out.print("\"Enter ???\", "); // If they haven't visited the shack yet, but can enter it from their current position.
					if(locationTracker == central && visitedRuins == true && altarTriggered != true)
						System.out.print("\"Enter Ruins\", "); // If they can enter the ruins from their current position.
					if(locationTracker == central && visitedRuins == false)
						System.out.print("\"Enter ???\", "); // If they haven't visited the ruins yet, but can enter it from their current position.
					if(locationTracker == west && visitedJungle == true)
						System.out.print("\"Enter Jungle\", "); // If they can enter the jungle from their current position.
					if(locationTracker == west && visitedJungle == false)
						System.out.print("\"Enter ???\", "); // If they haven't visited the jungle yet, but can enter it from their current position.
					if(locationTracker == east && vinesCut == true)
						System.out.print("\"Enter Rainbow\", "); // If they can enter the rainbow door from their current position.
					if(locationTracker == south && altarTriggered == true)
						System.out.print("\"Enter Crack\", "); // If they can enter the crack from their current position.
				} // Help Enter commands - End
				if(locationTracker == shack || locationTracker == ruins || locationTracker == jungle
						|| locationTracker == rainbow || locationTracker == crack) { // Help Exit commands - Start
					System.out.print("\"Exit\", "); // If they can exit anywhere from their current position.
					if(locationTracker == shack)
						System.out.print("\"Exit Shack\", "); // If they can exit the shack from their current position.
					if(locationTracker == ruins && roundsEscape != 0)
						System.out.print("\"Exit Ruins\", "); // If they can exit the ruins from their current position.
					if(locationTracker == jungle)
						System.out.print("\"Exit Jungle\", "); // If they can exit the jungle from their current position.
					if(locationTracker == rainbow)
						System.out.print("\"Exit Rainbow\", "); // If they can exit the rainbow door from their current position.
					if(locationTracker == crack)
						System.out.print("\"Exit Crack\", "); // If they can exit the crack from their current position.
				} // Help Exit commands - End
				if(pickupItem) { // Help Pick Up Items commands - Start
					if(locationTracker == north) {
						if(!gotShovel) {
							currentEvent += "\"Shovel\""; // If you can currently pick up the shovel.
							if (!gotBucket) {
								currentEvent += ", "; // If you can also currently pick up the bucket.
							}
						}
						if (!gotBucket) {
							currentEvent += "\"Bucket\""; // If you can currently pick up the bucket.
						}
					} else if(locationTracker == west) {
						if (!gotTorch) {
							currentEvent += "\"Torch\""; // If you can currently pick up the torch.
						}
					} else if(locationTracker == shack) {
						if (!gotMap) {
							currentEvent += "\"Map\""; // If you can currently pick up the map.
						}
					} 
					if(!currentEvent.equals("")) { // If any items can be picked up this section runs.
						System.out.print("\"Take [" + currentEvent + "]\", "); // If any items can be picked up, this says what items can be.
						System.out.print("\"Take all\", "); // If any items can be picked up, then take all can be ran.
					}
					currentEvent = ""; // Empties the string currentEvent.
				} // Help Pick Up Items commands - End
				if(useItem) { // Help Use Item commands - Start
					if(derustShovel) {
						currentEvent += "\"Shovel\""; // If you can currently use the shovel.
						if (filledBucket) {
							currentEvent += ", "; // If you can also currently use the bucket.
						} else if (litTorch) {
								currentEvent += ", "; // Or if you can also currently use the torch.
						} else if (gotMachete) {
							currentEvent += ", "; // Or if you can also currently use the machete.
						}  else if (gotMap) {
							currentEvent += ", "; // Or if you can also currently use the map.
						}
					}
					if (filledBucket) {
						currentEvent += "\"Bucket\""; // If you can currently use the bucket.
						if (litTorch) {
							currentEvent += ", "; // If you can also currently use the torch.
						} else if (gotMachete) {
							currentEvent += ", "; // Or if you can also currently use the machete.
						}  else if (gotMap) {
							currentEvent += ", "; // Or if you can also currently use the map.
						}
					}
					if(litTorch) {
						currentEvent += "\"Torch\""; // If you can currently use the torch.
						if (gotMachete) {
							currentEvent += ", "; // If you can also currently use the machete.
						} else if (gotMap) {
							currentEvent += ", "; // Or if you can also currently use the map.
						}
					}
					if(gotMachete) {
						currentEvent += "\"Machete\""; // If you can currently use the machete.
						if (gotMap) {
							currentEvent += ", "; // If you can also currently use the map.
						}
					}
					if(gotMap) {
						currentEvent += "\"Map\""; // If you can currently use the map.
					}
					if(!currentEvent.equals("")) { // If currentEvent contains any strings, it runs through this if statement.
						System.out.print("\"Use [" + currentEvent + "]\", ");
					}
					currentEvent = ""; // resets currentEvent back to blank.
				} // Help Use Item commands - End
				// Help Item Modifier commands - Start
				if(locationTracker == jungle && gotShovel && !derustShovel) {
					System.out.print("\"Derust Shovel\", "); // If you can currently derust the shovel.
				} 
				if(locationTracker == crack && gotMap && !completedMap) {
					System.out.print("\"Complete Map\", "); // If you can currently complete the map.
				}
				if((locationTracker == north || locationTracker == south && !altarTriggered) && gotBucket && !filledBucket) {
					System.out.print("\"Fill Bucket\", "); // If you can currently fill the bucket in either the north or south.
				} 
				if(locationTracker == shack && gotTorch && !litTorch) {
					System.out.print("\"Light Torch\", "); // If you can currently light the torch.
				}
				// Help Item Modifier commands - End
				System.out.println("\"Inventory\" "); // Always available ~ reveals items that you currently have.
				historyTracker += "You asked for help. \n"; // historyTracker adds that you asked for help for the end.
				// Help commands - End
			} else if (response.equalsIgnoreCase("North")) { // If the user inputs "North".
				if(locationTracker == north || locationTracker == west || locationTracker == east
					|| locationTracker == shack || locationTracker == ruins || locationTracker == jungle 
					|| locationTracker == crack || locationTracker == rainbow) { // Checks to see if they cannot go north.
					System.out.println("You cannot go North from here. Go another direction"); // tells them they cannot go north.
					historyTracker += "You tried to go North, but could not. \n"; // historyTracker adds that you tried to go north but failed.
					continue; // restarts while loop.
				} else {
					locationTracker -= 2; // Moves the player "north" 1 square.
					historyTracker += "You went North from your last position. \n"; // historyTracker adds that you went north.
				}				
			} else if (response.equalsIgnoreCase("South")) { // if the user inputs "South".
				if(locationTracker == south || locationTracker == west || locationTracker == east
						|| locationTracker == shack || locationTracker == ruins || locationTracker == jungle 
						|| locationTracker == crack || locationTracker == rainbow) { // Checks to see if they cannot go south.
					System.out.println("You cannot go South from here. Go another direction"); // tells them they cannot go south.
					historyTracker += "You tried to go South, but could not. \n"; // historyTracker adds that you tried to go south but failed.
					continue; // restarts while loop.
				} else {
					locationTracker += 2; // Moves the player "south" 1 square.
					historyTracker += "You went South from your last position. \n"; // historyTracker adds that you went south.
				}
			} else if (response.equalsIgnoreCase("East")) { // if the user inputs "East".
				if(locationTracker == east || locationTracker == north || locationTracker == south
						|| locationTracker == shack || locationTracker == ruins || locationTracker == jungle 
						|| locationTracker == crack || locationTracker == rainbow) { // Checks to see if they cannot go east.
					System.out.println("You cannot go East from here. Go another direction"); // tells them they cannot go east.
					historyTracker += "You tried to go East, but could not. \n"; // historyTracker adds that you tried to go east but failed.
					continue; // restarts while loop.
				} else {
					locationTracker += 1; // Moves the player "east" 1 square.
					historyTracker += "You went East from your last position. \n"; // historyTracker adds that you went east.
				}
			} else if (response.equalsIgnoreCase("West")) { // if the user inputs "West".
				if(locationTracker == west || locationTracker == north || locationTracker == south
						|| locationTracker == shack || locationTracker == ruins || locationTracker == jungle 
						|| locationTracker == crack || locationTracker == rainbow) { // Checks to see if they cannot go west.
					System.out.println("You cannot go West from here. Go another direction"); // tells them they cannot go west.
					historyTracker += "You tried to go West, but could not.\n"; // historyTracker adds that you tried to go east but failed.
					continue; // restarts while loop.
				} else {
					locationTracker -= 1; // Moves the player "west" 1 square.
					historyTracker += "You went West from your last position. \n"; // historyTracker adds that you went west.
				}
			} else if (response.equalsIgnoreCase("Enter") || response.equalsIgnoreCase("Enter ???") || response.equalsIgnoreCase("Enter Shack") ||
					response.equalsIgnoreCase("Enter Ruins") || response.equalsIgnoreCase("Enter Jungle") || 
					response.equalsIgnoreCase("Enter opening") || response.equalsIgnoreCase("Enter door") ||
					response.equalsIgnoreCase("Enter Crack")) { // if the user inputs "Enter", or some variant.
				if(locationTracker == north) { // if the user is in the "north" square.
					System.out.println("You enter the abandoned shack"); // tells them they entered the abandoned shack.
					historyTracker += "You entered the abandeoned shack. \n"; // historyTracker adds that you entered the abanonded shack.
					locationTracker = shack; // Sets locationTracker to shack.
				} else if (locationTracker == central) { // if the user is in the "central" square.
					if(roundsEscape == 0) { // If the roundsEscape variable to 0, then you cannot enter the ruins.
						System.out.println("The ruins are collapsed. You cannot enter it!"); // tells them they cannot entered the collapsed ruins.
						historyTracker += "You tried entered the ruins after it collasped. \n"; // adds you tried to enter the ruins but failed.
						continue; // restarts while loop.
					}
					System.out.println("You enter the impossible ruins"); // tells them they entered the ruins.
					historyTracker += "You entered the impossible ruins. \n"; // historyTracker adds that you entered the ruins.
					locationTracker = ruins; // Sets locationTracker to ruins.
				} else if (locationTracker == west) { // if the user is in the "west" square.
					System.out.println("You enter the small opening in the jungle."); // tells them they entered the jungle.
					historyTracker += "You entered the small opening in the jungle. \n"; // historyTracker adds that you entered the jungle.
					locationTracker = jungle; // Sets locationTracker to jungle.
				}  else if (locationTracker == south && altarTriggered) { // if the user is in the "south" square AND the altar is triggered.
					System.out.println("You look through the small hole in the valley."); // tells them they entered the crack.
					historyTracker += "You looked through the small hole in the valley. \n"; // historyTracker adds that you entered the crack.
					locationTracker = crack; // Sets locationTracker to crack.
				}else if (locationTracker == east && vinesCut) { // if the user is in the "east" square AND the vines are cut.
					System.out.println("You enter the rainbow door"); // tells them they entered the rainbow door.
					historyTracker += "You entered the rainbow door. \n"; // historyTracker adds that you entered the rainbow door.
					locationTracker = rainbow; // Sets locationTracker to rainbow.
				}
				else { // if the user cannot enter a new square because of some condition that has been met (or not met yet).
					System.out.println("You cannot enter anything here, but there is nothing here to enter."); // tells them they cannot enter.
					historyTracker += "You tried to enter something, but there was nothing there to enter"; // historyTracker adds you cannot enter.
				}
			} else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("Exit ???") || response.equalsIgnoreCase("Exit Shack") ||
					response.equalsIgnoreCase("Exit Ruins") || response.equalsIgnoreCase("Exit Jungle") || 
					response.equalsIgnoreCase("Exit door")) { // if the user inputs "Exit", or some variant.
				if(locationTracker == shack) { // if the user is in the "shack" square.
					System.out.println("You exit the shack"); // tells them they exited the shack.
					historyTracker += "You exited the Shack. \n"; // historyTracker adds that you exited the shack.
					locationTracker = north; // Sets locationTracker to north.
				} else if (locationTracker == ruins) { // if the user is in the "ruins" square.
					if(altarTriggered) { // runs if the altar event was triggered
						System.out.println("You exit the collapsing ruins."); // tells them they exited the collapsing ruins.
						historyTracker += "You exited the collapsing ruins. \n"; // historyTracker adds that you exited the collapsing ruins.
					} else { // runs this if the altar event was not triggered
						System.out.println("You exit the ruins.");  // tells them they exited the ruins.
						historyTracker += "You exited the ruins. \n"; // historyTracker adds that you exited the ruins.
					}
					locationTracker = central; // Sets locationTracker to central.
				} else if (locationTracker == jungle) { // if the user is in the "jungle" square.
					System.out.println("You exit the jungle."); // tells them they exited the jungle.
					historyTracker += "You exited the jungle. \n"; // historyTracker adds that you exited the jungle.
					locationTracker = west; // Sets locationTracker to west.
				} else if (locationTracker == crack) { // if the user is in the "crack" square.
					System.out.println("You stop looking through the small hole in the valley."); // tells them they exited the crack.
					historyTracker += "You looked through the small hole in the valley. \n"; // historyTracker adds that you exited the crack.
					locationTracker = south; // Sets locationTracker to south.
				} else if (locationTracker == rainbow) { // if the user is in the "rainbow" square.
					System.out.println("You exit rainbow door."); // tells them they exited the rainbow door.
					historyTracker += "You exited rainbow door. \n"; // historyTracker adds that you exited the rainbow door.
					locationTracker = east; // Sets locationTracker to east.
				}
			} else if (response.equalsIgnoreCase("Take Shovel")) { // if the user inputs "Take Shovel".
				if(locationTracker == north) { // if the user is in the "north" square. 
					if(gotShovel == true) { // If they already have the shovel.
						System.out.println("You already have the rusty shovel."); // tells them they already have the shovel.
						historyTracker += "You tried to pick up the shovel, but you already had it. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the shovel.
						System.out.println("You pick up the rusty shovel."); // tells them they take the rusty shovel.
						gotShovel = true; // sets code to true, showing they have shovel now.
						historyTracker += "You picked up the rusty shovel. \n"; // historyTracker adds they took the shovel.
					}
				} else { // if they aren't in the "north" square.
					System.out.println("There are no shovels near you."); // tells them there are no shovels in that square.
					historyTracker += "You tried to pick up the rusty shovel from the wrong location. \n"; // historyTracker adds this to itself.
				}
			} else if (response.equalsIgnoreCase("Take Bucket")) { // if the user inputs "Take Bucket". 
				if(locationTracker == north) { // if the user is in the "north" square. 
					if(gotBucket == true) { // If they already have the bucket.
						System.out.println("You already have the empty bucket."); // tells them they already have the bucket.
						historyTracker += "You tried to pick up the bucket, but you already had it. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the bucket.
						System.out.println("You pick up the empty bucket."); // tells them they take the empty bucket.
						gotBucket = true; // sets code to true, showing they have bucket now.
						historyTracker += "You picked up the empty bucket. \n"; // historyTracker adds they took the bucket. 
					}
				} else { // if they aren't in the "north" square.
					System.out.println("There are no buckets near you."); // tells them there are no buckets in that square.
					historyTracker += "You tried to pick up the empty bucket from the wrong location. \n"; // historyTracker adds this to itself.
				}
			} else if (response.equalsIgnoreCase("Take Torch")) {  // if the user inputs "Take Torch". 
				if(locationTracker == west) {  // if the user is in the "west" square. 
					if(gotTorch == true) { // If they already have the torch.
						System.out.println("You already have the unlit torch."); // tells them they already have the torch.
						historyTracker += "You tried to pick up the torch, but you already had it. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the torch.
						System.out.println("You pick up the unlit torch."); // tells them they take the unlit torch.
						gotTorch = true; // sets code to true, showing they have torch now.
						historyTracker += "You picked up the unlit torch. \n"; // historyTracker adds they took the torch. 
					}
				} else { // if they aren't in the "west" square.
					System.out.println("There are no torches near you."); // tells them there are no torches in that square.
					historyTracker += "You tried to pick up the unlit torch from the wrong location. \n"; // historyTracker adds this to itself.
				}
			} else if (response.equalsIgnoreCase("Take Map")) { // if the user inputs "Take Map". 
				if(locationTracker == shack) {  // if the user is in the "shack" square. 
					if(gotMap == true) { // If they already have the map.
						System.out.println("You already have the incomplete map."); // tells them they already have the map.
						historyTracker += "You tried to pick up the map, but you already had it. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the map.
						System.out.println("You pick up the incomplete map."); // tells them they take the incomplete map.
						gotMap = true; // sets code to true, showing they have map now.
						historyTracker += "You picked up the incomplete map. \n"; // historyTracker adds they took the torch. 
					}
				} else { // if they aren't in the "west" square.
					System.out.println("There are no maps near you.");  // tells them there are no maps in that square.
					historyTracker += "You tried to pick up the dusty map from the wrong location. \n"; // historyTracker adds this to itself.
				}
			} else if (response.equalsIgnoreCase("Take All")) { // if the user inputs "Take All". 
				if(locationTracker == north) { // if the user is in the "north" square.  
					if(gotShovel == false && gotBucket == false) { // If they don't have the shovel and bucket.
						System.out.println("You pick up the rusty shovel."); // tells them they take the rusty shovel.
						System.out.println("You pick up the empty bucket."); // tells them they take the empty bucket.
						historyTracker += "You pick up the rusty shovel. \n"; // historyTracker adds this to itself.
						historyTracker += "You pick up the empty bucket. \n"; // historyTracker adds this to itself.
						gotShovel = true; // sets code to true, showing they have shovel now.
						gotBucket = true; // sets code to true, showing they have bucket now.
					} else if (gotShovel == false && gotBucket == true) { // If they don't have the shovel but have the bucket.
						System.out.println("You pick up the rusty shovel."); // tells them they take the rusty shovel.
						historyTracker += "You pick up the rusty shovel. \n"; // historyTracker adds this to itself.
						gotShovel = true; // sets code to true, showing they have shovel now.
					} else if (gotShovel == true && gotBucket == false) { // If they don't have the bucket but have the shovel..
						System.out.println("You pick up the empty bucket."); // tells them they take the empty bucket.
						historyTracker += "You pick up the empty bucket. \n"; // historyTracker adds this to itself.
						gotBucket = true; // sets code to true, showing they have bucket now.
					}  else if (gotShovel == true && gotBucket == true) { // If they have both the shovel and bucket.
						System.out.println("You already have everything from here."); // tells them they took everything already.
						historyTracker += "You tried to pick up everything from the shore,"
								+ " but you already have it all. \n"; // historyTracker adds this to itself.
					}
				} else if (locationTracker == west) {  // if the user is in the "west" square.  
					if(gotTorch == true) { // If they have the torch.
						System.out.println("You already have everything from here."); // tells them they already have everything.
						historyTracker += "You tried to pick up everything from the jungle,"
								+ " but you already have it all. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the torch.
						System.out.println("You pick up the unlit torch."); // tells them they take the unlit torch.
						gotTorch = true; // sets code to true, showing they have torch now.
						historyTracker += "You picked up the unlit torch. \n"; // historyTracker adds this to itself
					}
				} else if(locationTracker == shack) { // If the user is in the "shack" square
					if(gotMap == true) { // If they already have the map.
						System.out.println("You already have everything from here."); // tells them they already have everything from this square.
						historyTracker += "You tried to pick up everything from the shack,"
								+ " but you already had it all. \n"; // historyTracker adds this to itself.
					} else { // if they don't have the map.
						System.out.println("You pick up the incomplete map."); // tells them they take the incomplete map.
						gotMap = true; // sets code to true, showing they have map now.
						historyTracker += "You picked up the incomplete map. \n"; // historyTracker adds they took the torch. 
					}
				}
				else { // if they aren't in a square that has an item.
					System.out.println("You notice there is nothing to pick up here."); // Tells them there is nothing to pick up.
					historyTracker += "You noticed there is nothing to take in the current square. \n"; // historyTracker adds they took nothing. 
				}
			} else if(response.equalsIgnoreCase("Derust Shovel")) { // if the user inputs "Derust Shovel".
				if(gotShovel) {
					if(derustShovel == false) {
						if(locationTracker == jungle) {
							System.out.println("You derust the shovel using the lemons and salt.");
							derustShovel = true;
							historyTracker += "You derusted the shovel with lemons and salt. \n";
						}
					} else {
						System.out.println("Your shovel is already derusted.");
						historyTracker += "You tried to derust a shovel that is already derusted.  \n";
					}
				} else {
					System.out.println("You don't have a shovel to derust.");
					historyTracker += "You tried to derust a shovel you don't have. \n";
				}
			} else if (response.equalsIgnoreCase("Fill bucket")) { // if the user inputs "Fill Bucket".
				if(gotBucket) {
					if(filledBucket == false) {
						if(locationTracker == north) {
							System.out.println("You fill the bucket using the water from the shoreline. The bucket is now full with Ocean Water.");
							filledBucket = true;
							bucketLiquid = "Ocean Water.";
							historyTracker += "You filled the bucket with ocean water. \n";
						} else if (locationTracker == south && !altarTriggered) {
							System.out.println("You fill the bucket using the liquid dripping from valley. "
									+ "The bucket is now full with strange liquid.");
							filledBucket = true;
							bucketLiquid = "strange liquid.";
							historyTracker += "You filled the bucket with strange liquid. \n";
						} else {
							System.out.println("You have no means to fill the bucket. \nMaybe another place will have a way.");
							historyTracker += "You tried to fill the bucket but don't have any way of filling it.  \n";
						}
					}
					else {
						System.out.println("Your bucket is already full with " + bucketLiquid);
						historyTracker += "You tried to fill up a bucket that is already full.  \n";
					}
				} else {
					System.out.println("You don't have a bucket to fill up.");
					historyTracker += "You tried to fill up a bucket you don't have. \n";
				}
				
			} else if (response.equalsIgnoreCase("Light Torch")) { // if the user inputs "Light Torch".
				if(gotTorch) {
					if(litTorch == false) {
						if(locationTracker == shack) {
							System.out.println("You light the torch using the lighter. The lighter is now empty.");
							litTorch = true;
							historyTracker += "You lit the torch on fire. \n";
						} else {
							System.out.println("You have no means to light the torch. \nMaybe another place will have a way.");
							historyTracker += "You tried to light a torch but don't have any way of lighting it.  \n";
						}
					}
					else {
						System.out.println("Your torch is already lit.");
						historyTracker += "You tried to light a torch that is already lit.  \n";
					}
				} else {
					System.out.println("You don't have a torch to light.");
					historyTracker += "You tried to light a torch you don't have. \n";
				}
				
			} else if (response.equalsIgnoreCase("Complete Map")) { // if the user inputs "Complete Map".
				if(gotMap) {
					if(completedMap == false) {
						if(locationTracker == crack) {
							System.out.println("You complete the map using the piece from the crack.");
							completedMap = true;
							historyTracker += "You completed the map. \n";
						} else {
							System.out.println("You have no means to completed the map. \nMaybe another place will have a way.");
							historyTracker += "You tried to completed the map but don't have any way of completing it.  \n";
						}
					}
					else {
						System.out.println("Your map is already completed.");
						historyTracker += "You tried to complete a map that is already completed. \n";
					}
				} else {
					System.out.println("You don't have a map to complete.");
					historyTracker += "You tried to complete a map that you don't have. \n";
				}
			} else if (response.equalsIgnoreCase("Inventory")) { // if the user inputs "Inventory".
				System.out.print("Checking Inventory:\nYou have ");
				historyTracker += "You checked your inventory; \n";
				if(gotShovel) {
					if(derustShovel == false)
						inventory += "a rusty shovel, ";
					else
						inventory += "a shiny shovel, ";
				}
				if(gotBucket) {
					if(filledBucket == false)
						inventory += "a empty bucket, ";
					else
						inventory += "a bucket full of water, ";
				}
				if(gotTorch) {
					if(litTorch == false)
						inventory += "a unlit torch, ";
					else
						inventory += "a lit torch, ";
				} 
				if (gotMap) {
					if(completedMap == false)
						inventory += "an incomplete map, ";
					else
						inventory += "a completed map, ";					
				}
				if(gotMachete) {
					inventory += "a sharp Machete, ";
				}
				if(inventory.equals("")) {
					System.out.println("nothing in your inventory");
					historyTracker += "You had nothing in your inventory. \n";
				} else {
					System.out.println(inventory + "and your wits in your inventory");
					historyTracker += "You had " + inventory + " in your inventory. \n";
					inventory = "";
				}
			} else if(response.equalsIgnoreCase("Use Shovel")) { // if the user inputs "Use Shovel".
				if (gotShovel == false) {
					System.out.println("You do not have a shovel to use.");
					historyTracker += "You tried to use a shovel, but you didn't have one. \n";
				}
				else if(derustShovel == false) {
					System.out.println("The shovel is rusty. Maybe find a way to derust it.");
					historyTracker += "You tried to use a shovel, but it was too rusty. \n";
				} else {
					if(locationTracker == central && altarTriggered == true) {
						System.out.println("You use the shovel, revealing that the silver piece was a machete, \nand you take the machete.");
						historyTracker += "You used the shovel, getting a machete. \n";
						gotMachete = true;
					}
					else {
						System.out.println("You try to use the shovel, but there is nothing to use it on.");
						historyTracker += "You tried to use the shovel, but there is nothing to use it on. \n";
					}
				}
			} else if(response.equalsIgnoreCase("Use Bucket")) { // if the user inputs "Use Bucket".
				if (gotBucket == false) {
					System.out.println("You do not have a bucket to use.");
					historyTracker += "You tried to use a bucket, but you didn't have one. \n";
				}
				else if(filledBucket == false) {
					System.out.println("The bucket is empty. Maybe find a way to fill it.");
					historyTracker += "You tried to use a bucket, but it was empty. \n";
				} else {
					if(!(locationTracker == ruins)) {
						System.out.println("You use the bucket, pouring out " + bucketLiquid + " Nothing happens.");
						historyTracker += "You used the bucket pouring out " + bucketLiquid + " but in the wrong location. \n";
					}
					else { 
						if(useTorchProperly) {
							if(bucketLiquid.equals("Ocean Water.")) {
								System.out.println("You use the bucket, pouring out Ocean Water on the altar, but nothing happens");
								historyTracker += "You used the bucket pouring out " + bucketLiquid + " on the altar. \n";
							} else {
								System.out.println("You use the bucket, pouring out the strange liquid on the altar. ");
								historyTracker += "You used the bucket pouring out " + bucketLiquid + " on the altar. \n";
								altarTriggered = true;
							}
							bucketLiquid = "";
							filledBucket = false;
						} else {
							System.out.println("You cannot see anything in here with it being pitch black.");
							historyTracker += "You tried to use the bucket to pour out " + bucketLiquid + " in the ruins, but it was too dark. \n";
						}
					}
					
				}
			} else if(response.equalsIgnoreCase("Use Torch")) { // if the user inputs "Use Torch".
				if (gotTorch == false) {
					System.out.println("You do not have a torch to use.");
					historyTracker += "You tried to use a torch, but you didn't have one. \n";
				}
				else if(litTorch == false) {
					System.out.println("The torch is unlit. Maybe find a way to light it.");
					historyTracker += "You tried to use a torch, but it was not lit. \n";
				} else {
					if(locationTracker == ruins)  {
						System.out.println("You use the torch in the ruins, dispelling the darkness.");
						historyTracker += "You used the torch in the ruins. \n";
						useTorchProperly = true;
					} else {
						System.out.println("You use the torch... but it has no effect.");
						historyTracker += "You used the torch in a place other than the ruins. \n";
						useTorchProperly = false;
					}
				}
			} else if (response.equalsIgnoreCase("Use Map")) { // if the user inputs "Use Map".
				if (gotMap == false) {
					System.out.println("You do not have a map to use.");
					historyTracker += "You tried to use a map, but you didn't have one. \n";
				}
				else if(completedMap == false) {
					System.out.println("The map is incomplete. Maybe find a way to complete it.");
					historyTracker += "You tried to use the map, but it was incomplete. \n";
				} else {
					if(locationTracker == rainbow) {
						System.out.println("You use the map, understanding the path ahead.");
						historyTracker += "You used the map properly. \n";
					}
					else {
						System.out.println("You try to use the map, but it does not seem to make sense in this area.");
						historyTracker += "You tried to use the map, but were in the wrong location. \n";
					}
				}
			} else if (response.equalsIgnoreCase("Use Machete")) { // if the user inputs "Use Machete".
				if (gotMachete == false) {
					System.out.println("You do not have a machete to use.");
					historyTracker += "You tried to use a machete, but you didn't have one. \n";
				} else {
					if(locationTracker == east) {
						System.out.println("You use the machete, cutting away the thorny vines.");
						historyTracker += "You used the machete, cutting away the vines. \n";
						vinesCut = true;
					}
					else {
						System.out.println("You try to use the machete, but there is nothing to use it on.");
						historyTracker += "You tried to use the machete, but there is nothing to use it on. \n";
					}
				}
			} else if (response.equalsIgnoreCase("End") || response.equalsIgnoreCase("End Game")) { // if the user inputs "End".
				System.out.println("The game ends. But you wonder, was there more you could do?");
				adventureAwaits = false;
				historyTracker += "You ended the game. \n";
			} else if(locationTracker == rainbow && maze && response.equalsIgnoreCase("yes")) { // if the user inputs "Yes".
				mazeNow = true;
				historyTracker += "You enter the maze. \n";
			} else { // if the user inputs a command not recognized 
				System.out.println("Sorry I do not understand that command. Use \"Help\" for commands you can use. \n");
				historyTracker += "You inputted an unknown command. \n";
			} //! ENDS THE response.equals LOOP!
			
			if(locationTracker == north) { // If the player is in the North
				if(lastPosition == locationTracker)
					System.out.print("At the never ending shoreline, you see ");
				else
				System.out.print("As you approach a never ending shoreline, you see ");
				if(gotShovel == false) {
					currentEvent += "a shovel, ";
				} else {
					currentEvent += "the spot shovel was, ";
				}
				if(gotBucket == false) {
					currentEvent += "a bucket, ";
				} else {
					currentEvent += "the spot where the bucket was, ";
				}
				if(visitedShack == false) {
					currentEvent += "and an abandoned shack.";
				} else {
					currentEvent += "and the shack.";
				}
				System.out.println(currentEvent + "\nWhat do you do?");
				
				currentEvent = "";
			} else if (locationTracker == west) { // If the player is in the West
				if(lastPosition == locationTracker)
					System.out.print("At the treeline that never ends, you see");
				else
				System.out.print("As you approach a treeline that extends on forever, you see ");
				if(gotTorch == false) {
					currentEvent += "a unlit torch, ";
				} else {
					currentEvent += "the spot torch was, ";
				}
				if(visitedJungle == false) {
					currentEvent += "and a small opening in the dense Jungle.";
				} else {
					currentEvent += "and the small opening in the Jungle.";
				}
				System.out.println(currentEvent + "\nWhat do you do?");
				
				currentEvent = "";
			} else if (locationTracker == central) { // If the player is in the Central square
				if(altarTriggered && !gotMachete)
					System.out.print("The ruins is thoroughly destroyed. \nYou see something silver sticking out. Maybe you can dig it out.");
				else if (altarTriggered) 
					System.out.print("The ruins is thoroughly destroyed.");
				else if(lastPosition == locationTracker)
					System.out.print("At the ruins that seem impossible, you see the entrance inward.");
				else
				System.out.print("As you approach the ruin that seems impossible, you see the entrance inward.");
				System.out.println("\nWhat do you do?");
			} else if (locationTracker == east) { // If the player is in the East
				if(vinesCut)
					System.out.print("With the thorny vines gone, you see that there is a opening to a rainbow door.");
				else if(lastPosition == locationTracker)
					System.out.print("There are still thorny vines blocking the way. \nMaybe you can cut them.");
				else
				System.out.print("As you get closer to the Mountain, you see \nthere is thorny vines blocking the way. \nMaybe you can cut them.");
				System.out.println("\nWhat do you do?");
			} else if (locationTracker == south) { // If the player is in the South
				if (altarTriggered && lastPosition == locationTracker) {
					System.out.print("Still in the valley, the crack is still there.");
				}
				else if(altarTriggered) {
					System.out.print("The strange liquid has stopped flowing down. There is a crack in the wall.");
				}
				else if(lastPosition == locationTracker)
					System.out.print("Still in the valley, the strange liquid is still dripping down from above. ");
				else
				System.out.print("You descend down into the valley, and see \na strange liquid dripping down from above. ");
				System.out.println("\nWhat do you do?");
			} else if (locationTracker == shack) { // If the player enters the Shack
				if(visitedShack == false) {
					System.out.print("The abandoned shack has a ");
				} else {
					System.out.print("The shack has a ");
				}
				if(litTorch) {
					currentEvent += "lighter that can be used, and ";
				} else {
					currentEvent += "lighter that is now empty, and ";
				}
				if(gotMap == false) {
					currentEvent += "a dusty map.";
				}
				else {
					currentEvent += "the spot where map was.";
				}
				System.out.println(currentEvent + "\nWhat do you do?");
				currentEvent = "";
				visitedShack = true;
			} else if (locationTracker == ruins) { // If the player enters the Ruins
				if(!useTorchProperly) {
					System.out.println("You see nothing as it is suddenly pitch black.");
				} else if (!altarTriggered){
					System.out.println("As you look into the ruins with the torch light, \nyou see a blue pedestal that has an small hole. "
							+ "\nOn the south side of the ruins, you see a depiction that shows a liquid being poured into the hole.");
				} else {
					System.out.println("The altar is triggered, you feel the ground shake. The ruins start to fall around you! Get out of there!");
					
				}
				System.out.println("What do you do?");
				visitedRuins = true;
			} else if (locationTracker == jungle) { // If the player enters the Jungle
				if(lastPosition == locationTracker)
					System.out.print("Inside the jungle opening, you see ");
				else
				System.out.print("As you enter the jungle opening, you see ");
				if(derustShovel == false) {
				currentEvent += "a table that has instructions "
						+ "\non how to derust metals with lemons and salt. How specific.";
				} else {
					currentEvent += "the now-empty table.";
				}
				System.out.println(currentEvent + "\nWhat do you do?");
				
				currentEvent = "";
				visitedJungle = true;
			} else if (locationTracker == rainbow) { // If the player enters the Rainbow Door 
				maze = true;
				if(lastPosition == locationTracker) {
					System.out.print("Still inside the rainbow door, you see a maze. ");
				} else {
					System.out.print("As you enter the rainbow door, you see a maze. ");
					currentEvent = "It seems like it would help, \nif you had a map you could use in order to nagivate through it. ";
				}
				currentEvent += "\nDo you wish to enter the maze? \"Yes\"/\"No\"?";
				System.out.println(currentEvent + "\nWhat do you do?");
				
				currentEvent = "";
			} else if (locationTracker == crack) { // If the player enters the Crack 
				if(completedMap && lastPosition == locationTracker)
					System.out.print("Still looking inside the crack, you see nothing of interest.");
				else if (completedMap)
					System.out.print("Looking inside the crack, you see nothing of interest.");
				else if(lastPosition == locationTracker)
					System.out.print("Still looking inside the crack, you see a piece of paper.");
				else
				System.out.print("As you look into this crack, you see a piece of paper.");
				System.out.println(currentEvent + "\nWhat do you do?");
				
				currentEvent = "";
			}
			
			//If the player triggers the Altar Event, and they haven't left the ruins yet.
			if(altarTriggered == true && locationTracker == ruins && roundsEscape != 0) {
				roundsEscape--;
			}
			
			//If they haven't left the ruins at the end of 3 rounds, it kills you.
			if(roundsEscape == 0 && locationTracker == ruins) {
				System.out.println("The ruins collaspe on you, killing you. End of the game!");
				adventureAwaits = false; // Ends the Game
				historyTracker += "You stayed inside the ruins until it crushed you to death. \n";
			}
			
			// Adds how many rounds it has been +1
			roundsPassed++;
			// Sets the lastPosition to the current position
			lastPosition = locationTracker;
			
			
			while(mazeNow){ // Sudden Maze Loop
				//Runs first time they enter the maze
				if(roundsInMaze == 0) {
					System.out.println("You enter into the maze. Hopefully you have a map to guide you.");
					if(completedMap == false) { // if they did not complete the map
						System.out.println("You enter into this maze. Without a completed map, you eventually get turned around and lost.");
						System.out.println("Your only help now is to go in random directions, and hope you get out. Good luck!");
						System.out.println("You can still exit the game at any time by using \"end\", or by escaping.");
					} else { // if they completed the map
						System.out.println("You can use the map to see what direction to go in.");
						System.out.println("You can still exit the game at any time by using \"end\", or by escaping the maze.");
					}
					System.out.println("What do you do?");
				}
				
				playerDirection = 0;
				
				// Round counter for both Maze and total.
				roundsInMaze++;
				roundsPassed++;
				// Randomizes which direction you have to go in, so it is completely randomly.
				mazeDirection = (int) (Math.random() * 4 ) + 1; 
				// Gets a second random number for Incomplete Map
				randomDirection = (int) (Math.random() * 4 ) + 1;
				
				response = s.nextLine(); // Gets Player response.
				if(response.equalsIgnoreCase("End")) { // if the user inputs End, ends the maze and game.
					System.out.println("The game ends. Too bad. You were so close to the end as well.");
					adventureAwaits = false;
					mazeNow = false;
					historyTracker += "You ended the game in the maze. \n";
					break;
				} else if (response.equalsIgnoreCase("Use map")) { // if user inputs "Use Map"
					if (gotMap == false) { // If the user doesn't have a map
						System.out.println("You do not have a map to use.");
						historyTracker += "You tried to use a map, but you didn't have one in the maze. \n";
					}
					else if(completedMap == false) { // if they have a map, but never completed it.
						if(randomDirection == mazeDirection) { // if the random number gods agree, you get the right direction.
							System.out.println("This map is incomplete. However you think the next direction to go to is ");
							historyTracker += "You tried to use the map, but it was incomplete in the maze and gave you the right direction. \n";
							if(mazeDirection == northMaze) {
								System.out.println("north.");
							} else if (mazeDirection == southMaze) {
								System.out.println("south.");
							} else if (mazeDirection == eastMaze) {
								System.out.println("east.");
							} else if (mazeDirection == westMaze) {
								System.out.println("west.");
							}
							previousDirection = mazeDirection;
							continue;
						} else { // If the random numbers disagree, you get the wrong direction displayed.
							System.out.println("This map is incomplete. However you think the next direction to go to is ");
							historyTracker += "You tried to use the map, but it was incomplete in the maze and gave you the wrong direction. \n";
							if(randomDirection == northMaze) {
								System.out.println("north.");
							} else if (randomDirection == southMaze) {
								System.out.println("south.");
							} else if (randomDirection == eastMaze) {
								System.out.println("east.");
							} else if (randomDirection == westMaze) {
								System.out.println("west.");
							}
							continue;
						}
					} else { // If you have the completed Map, it tells you the next direction to go in.
							System.out.print("You use the map. The next direction you should go to is ");
							if(mazeDirection == northMaze) {
								System.out.println("north.");
							} else if (mazeDirection == southMaze) {
								System.out.println("south.");
							} else if (mazeDirection == eastMaze) {
								System.out.println("east.");
							} else if (mazeDirection == westMaze) {
								System.out.println("west.");
							}
							// Sets the previousDirection to mazeDirection
							previousDirection = mazeDirection;
							historyTracker += "You used the map properly. \n";
							// restarts loop.
							continue;
					}
				} else if (response.equalsIgnoreCase("north")) { // If north is inputed, sets northMaze to playerDirection
					playerDirection = northMaze;
					historyTracker += "In the maze, you went north. \n";
				} else if (response.equalsIgnoreCase("south")) { // If south is inputed, sets southMaze to playerDirection
					playerDirection = southMaze;
					historyTracker += "In the maze, you went south. \n";
				} else if (response.equalsIgnoreCase("east")) { // If east is inputed, sets eastMaze to playerDirection
					playerDirection = eastMaze;
					historyTracker += "In the maze, you went east. \n";
				} else if (response.equalsIgnoreCase("west")) { // If west is inputed, sets westMaze to playerDirection
					playerDirection = westMaze;
					historyTracker += "In the maze, you went west. \n";
				} else { // If an unknown command is inputted, it says what commands to use.
					System.out.println("Sorry I do not understand that command. Use \"North\", \"South\", \"East\", \"West\", \"Use map\" or \"End\".");
					historyTracker += "You inputted an unknown command while in the maze. \n";
				}
				
				// If the player matches MazeDirection
				if(mazeDirection == playerDirection || previousDirection == playerDirection) {
					mazeEscapage++; // Increases the mazeEscapage number
					historyTracker += "The direction was correct. \n";
				} else {
					mazeEscapage = 0; //Resets mazeEscaoage number
					historyTracker += "The direction was incorrect. \n";
				}
				
				// If mazeEscapage is 4, they escape the maze, beat the game, and it reveals how many rounds it took.
				if(mazeEscapage == 4) {
					System.out.println("You escaped the maze!!! You beat the game! It only took " + roundsInMaze + " rounds to escape the maze!");
					historyTracker += "You escaped the maze and beat the game! \n";
					mazeNow = false;
					adventureAwaits = false;
				}
				
				
			} // Maze Code End
		} // Main Code End
		
		System.out.println("\nThanks for playing! Hopefully you found everything you were looking for.");
		System.out.println("You played " + roundsPassed + " rounds. \nLet's reveal your player History during the game: \n");
		System.out.print(historyTracker);
		s.close();
		System.exit(0);
		
		// This took a very long time to make, and to comment, so hopefully A. you enjoyed it, and B. the code is readable, and 
		// if not, C. the comments are readable and understandable
	}
}
