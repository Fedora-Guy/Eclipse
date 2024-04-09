import java.util.Scanner; 

public class HighScore {
	
  static int highest = 0;
  static Scanner sc = new Scanner(System.in);
	
  static void addPlayer(String player[],int score[]){
    
    if(highest >= 10){
      System.out.println("Array is full");
    }
    else{                  // look at where at print. add a next line in the first else statement. 
      System.out.print("Enter player name:");
      player[highest] = sc.next();
      System.out.print("Enter " + player[highest]+" scores:");
      score[highest] = sc.nextInt();
      highest++;
    }
  }
  static void printPlayers(String player[],int score[]){
    if (highest == 0)        //If array is empty; no player saved
      System.out.println();
    else {
      for(int i=0;i<highest;i++){
        System.out.println(player[i]+": "+score[i]);
      }
      System.out.println();
    }
  }
  static void searchPlayer(String player[],int score[], String name){
    for (int i = 0; i < highest ; i++) {
      if (player[i].equals(name)) {
        System.out.println(name+": "+score[i]);////
		return;
  }
    }
    System.out.println(name + " wasn't found!");

  }
  static void deleteplayer(String player[],int score[],String name){
      int pos;
      for(pos = 0; pos < highest; pos++) {
        if(player[pos].equals(name)){
			player[pos] = null;
			score[pos] = 0;
			highest--;
			return;
        }
      }
  }
  public static void main(String[] args) {
    String players[] = new String[10];
    int score[] = new int[10];
    int choice;
    do{
      System.out.print("Enter 1 to add player, 2 to print all players, 3 to search player, 4 to delete player, or 10 to exit:");
      choice = sc.nextInt();
      switch(choice){
        case 1: addPlayer(players,score);break;
        case 2: printPlayers(players,score); break;
        case 3: System.out.print("Enter player name:");
                String name = sc.next();
                searchPlayer(players,score,name); break;
        case 4: System.out.print("Enter player name:");
                String name2 = sc.next();
                deleteplayer(players,score,name2); break;
        default:
		  		break;
      } 
    }
 while(choice!=10);
	  System.out.println();
  }
}
