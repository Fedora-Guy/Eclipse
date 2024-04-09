/* Name: Keith Reis
 * Program Name: ThirstyPersonProblem
 * Due Date: 2/14/23
 * Description: Tests the Programmer's knowledge and capability of semaphores and critical sections.
 */

import java.util.Arrays;
import java.util.Random;

class HostCustomer {
  private int in = 0, sz = 2, out = 0, count = 0;
  private int[] buffer = new int[sz];
  
  public HostCustomer() {
    for(int i = 0; i < sz; i++)
      buffer[i] = -1;
  }
  public HostCustomer(int s) {
    sz = s;
    buffer = new int[sz];
    for (int i = 0; i < sz; i++)
      buffer[i] = -1;
  }
  
  private void add(int item) {
    buffer[in] = item;
    in = (in + 1) % buffer.length;
    String addStatement = Thread.currentThread().getName() + " adds ";
    switch (item) {
    	case 0:
    		addStatement += "ice";
    		break;
    	case 1:
    		addStatement += "water";
    		break;
    	case 2:
    		addStatement += "glass";
    		break;
    	default:
    		addStatement += "[ error, Item is: " + (item) + " ]";
    		break;
    }
    System.out.println(addStatement + ": " + Arrays.toString(buffer));
  }
  
  private int[] remove(int heldItem) { 
	int[] failed = {-1, -1};
    int[] items = new int[2];
    items[0] = buffer[out]; 
    if(items[0] == heldItem) { 
    	return failed;
    }
    buffer[out] = -1; 
    out = (out + 1) % buffer.length;
    items[1] = buffer[out]; 
    if(items[1] == heldItem) { 
    	out = (out - 1); 
    	buffer[out] = items[0]; 
    	return failed; 
    }
    buffer[out] = -1;
    out = (out + 1) % buffer.length;
    
    String removeStatement = Thread.currentThread().getName() + " gets ";
    switch(items[0]) {
    	case 0:
    		removeStatement += "ice";
    		break;
    	case 1:
    		removeStatement += "water";
    		break;
    	case 2:
    		removeStatement += "glass";
    		break;
    	default:
    		removeStatement += "[ error, Item[0] is: " + (items[0]) + " ]";
    		break;
    }
    removeStatement += " AND ";
    switch(items[1]) {
	case 0:
		removeStatement += "ice";
		break;
	case 1:
		removeStatement += "water";
		break;
	case 2:
		removeStatement += "glass";
		break;
	default:
		removeStatement += "[ error, Item[1] is: " + (items[1]) + " ]";
		break;
    }
    
    System.out.println(removeStatement + ": " + Arrays.toString(buffer));
    return items;
  }

  public synchronized void addToBuffer(int item, int item2) {
	String enterStatement = Thread.currentThread().getName() + " enters with ";
	switch (item) {
		case 0:
			enterStatement += "ice";
			break;
		case 1:
			enterStatement += "water";
			break;
		case 2:
			enterStatement += "glass";
			break;
		default:
			enterStatement += " [ error, Item is: " + (item) + " ]";
			break;
	}
	enterStatement += " AND ";
	switch (item2) {
	case 0:
		enterStatement += "ice.";
		break;
	case 1:
		enterStatement += "water.";
		break;
	case 2:
		enterStatement += "glass.";
		break;
	default:
		enterStatement += " [ error, Item2 is: " + (item2) + " ].";
		break;
	}
    System.out.println(enterStatement);
    while(count == buffer.length)
      try {
        System.out.println(Thread.currentThread().getName() + " goes to sleep");
        wait();
      } catch(InterruptedException ie) {
      }
    add(item);
    add(item2);
    count++;
    if (count == 1)
      notifyAll();
  }

  public synchronized int[] removeFromBuffer(int helditem) {
    System.out.println(Thread.currentThread().getName() + " enters");
    while(count == 0)
      try {
        System.out.println(Thread.currentThread().getName() + " goes to sleep");
        wait();
      } catch (InterruptedException ie) {
      }
    int[] items = new int[2];
    items = remove(helditem);
    if(items[0] == -1) { // It failed
    	int[] failed = {-1, -1};
    	return failed;
    }
    count--;
    if(count == buffer.length - 1)
      notifyAll();
    return items;
  }
}

class Host extends Thread {
	  private HostCustomer hostCustomer;
	  
	  public Host(int i, HostCustomer hc) {
	    super("host" + i); // naming a Host thread;
	    hostCustomer = hc;
	  }

	  private int[] produce() {
	    int[] item = new int[2];
	    item[0] = (new Random()).nextInt(3); // 0-2
	    item[1] = (new Random()).nextInt(3);  
	    while(item[0] == item[1]) {
	    	item[1] = (new Random()).nextInt(3);
	    }
	    String produceStatement = getName() + " produces ";
	    switch(item[0]){
	    	case 0:
	    		produceStatement += "ice";
	    		break;
	    	case 1:
	    		produceStatement += "water";
	    		break;
	    	case 2:
	    		produceStatement += "glass";
	    		break;
	    	default:
	    		produceStatement += " [ error, Item is: " + (item[0]) + " ]";
	    		break;
	    }
	    produceStatement += " AND ";
	    switch(item[1]){
    	case 0:
    		produceStatement += "ice.";
    		break;
    	case 1:
    		produceStatement += "water.";
    		break;
    	case 2:
    		produceStatement += "glass.";
    		break;
    	default:
    		produceStatement += " [ error, Item is: " + (item[1]) + " ].";
    		break;
	    }
	    System.out.println(produceStatement);
	    return item;
	  }
	  public void run() {
	    while(true) {
	      int[] item = new int[2];
	      item = produce();
	      hostCustomer.addToBuffer(item[0], item[1]);
	      try {
	        sleep(300);
	      } catch (InterruptedException ie) {
	      }
	    }
	  }
	}

	class Customer extends Thread {
	  private HostCustomer hostCustomer;
	  private int helditem = -1; 

	  public Customer(int i, HostCustomer hc) {
	    super("Customer" + (i-1)); // naming a Customer thread;
	    helditem = (i-1); // 0, 1, 2 -> Ice, water, glass
	    hostCustomer = hc;
	  }
	  
	  private void consume (int item, int item2) {
		  String consumeStatement;
		  consumeStatement = getName() + " consumes";
	    switch((item)) {
	    	case 0: // Ice
	    		consumeStatement += " ice ";
	    		break;
	    	case 1: // Water
	    		consumeStatement += " water ";
	    		break;
	    	case 2: // Glass
	    		consumeStatement += " glass ";
	    		break;
	    	default:
	    		consumeStatement += " [ error, Item is: " + (item) + " ] "; 
	    		break;
	    }
	    consumeStatement += "AND";
	    switch((item2)) {
    	case 0: // Ice
    		consumeStatement += " ice.";
    		break;
    	case 1: // Water
    		consumeStatement += " water.";
    		break;
    	case 2: // Glass
    		consumeStatement += " glass.";
    		break;
    	default:
    		consumeStatement += " [ error, Item2 is: " + (item2) + " ]."; 
    		break;
	    }
	    System.out.println(consumeStatement);
	  }
	  
	  public void run() {
	    while(true) {
	      int[] item = hostCustomer.removeFromBuffer(helditem);
	      if(item[0] != -1) {
	    	  consume(item[0], item[1]);
	      }
	      try {
	        sleep(300);
	      } catch (InterruptedException ie) {
	      }
	    }
	  }
	}
	
	public class TestHostCustomer { // The Testing Class
	  public static void main(String[] args) {
		System.out.println("Customer0 is holding Ice"); // 0 = Ice
		System.out.println("Customer1 is holding Water"); // 1 = Water
		System.out.println("Customer2 is holding A Glass"); // 2 = A Glass
		HostCustomer hc = new HostCustomer(2); // How Big Our Buffer is
	    for(int i = 1; i <= 3; i++)
	      (new Customer(i, hc)).start(); // How Many Thirsty People we Have
	    for(int i = 1; i <= 1; i++)
	      (new Host(i, hc)).start(); // How Many Servers we Have
	    Thread a[] = new Thread[Thread.activeCount()];
	    Thread.enumerate(a);
	    System.out.println(Arrays.toString(a));
	  }
	}