class ThirstyPerson extends Thread {
  private final String name;
  private final int requiredItem;
  private int firstItem;
  private int secondItem;
  private boolean hasItems;

  public ThirstyPerson(String name, int requiredItem) {
    this.name = name;
    this.requiredItem = requiredItem;
    this.hasItems = false;
  }

  public void run() {
    while (true) {
      synchronized (this) {
        while (!hasItems) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (firstItem != requiredItem && secondItem != requiredItem) {
        	System.out.println("\tfirstItem: " + firstItem);
        	System.out.println("\tsecondItem: " + secondItem);
          System.out.println("\t" + name + " is drinking");
          System.out.println();
          firstItem = 0;
          secondItem = 0;
          hasItems = false;
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          hasItems = false;
        }
        notifyAll();
      }
    }
  }
public synchronized void setItems(int firstItem, int secondItem) {
    this.firstItem = firstItem;
    this.secondItem = secondItem;
    hasItems = true;
    notifyAll();
  }
}

class Server extends Thread {
  private ThirstyPerson[] thirstyPeople;

  public Server(ThirstyPerson[] thirstyPeople) {
    this.thirstyPeople = thirstyPeople;
  }

  public void run() {
    while (true) {
      int firstItem = (int) (Math.random() * 3) + 1;
      int secondItem = 0;
      do {
    	  secondItem = (int) (Math.random() * 3) + 1;
      } while(firstItem == secondItem);
      
      for (ThirstyPerson thirstyPerson : thirstyPeople) {
        thirstyPerson.setItems(firstItem, secondItem);
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class Main {
  public static void main(String[] args) {
    ThirstyPerson person1 = new ThirstyPerson("Person 1", 1);
    ThirstyPerson person2 = new ThirstyPerson("Person 2", 2);
    ThirstyPerson person3 = new ThirstyPerson("Person 3", 3);
    ThirstyPerson[] thirstyPeople = { person1, person2, person3 };
    Server server = new Server(thirstyPeople);
    person1.start();
    person2.start();
    person3.start();
    server.start();
  }
}