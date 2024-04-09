/* Name: Keith Reis
 * Program Name: Store
 * Due Date: 4/8/22
 * Description: Simulate traffic in a store to discover the best cashier per customer number
 * Assistance: None
 */
import java.util.LinkedList;
import java.util.Queue;

public class Store {
	public static void main(String[] args) {
		// Runs through the whole program from 6 to 12 to get varying results.
		// Through my testing, the best result is: 8 cashiers
		// Where it has roughly a 1.6% wait time average (((waitTime/1000)/54000)*100)
		// and a roughly 43.0% idle time average (((idleTime/cashiers)/54000)*100)
		// A second close is 7 cashiers
		// with 3.5 % wait time average, and 34.6 % idle time average
		for(int NumOfCashiers = 6; NumOfCashiers <= 12; NumOfCashiers++) {
			int cashiers = NumOfCashiers;
			int customers = 1000;
			double waitTime = 0;
			double idleTime = 0;
			int taskTime = 0;
			int finishTime = 0;
			
			// Generates the array of customers, then puts the Sorted Customers into a queue
			Program5.Customer[] generatedCustomers = Program5.genCustomers(customers);
			Queue<Program5.Customer> queue = new LinkedList<>();
			for(int i = 0; i < customers; i++) {
				queue.add(generatedCustomers[i]);
			}
			
			// Generates an Array of Cashiers based on the NumOfCashiers
			Program5.Cashier Cashiers[] = new Program5.Cashier[cashiers];
			for(int i = 0; i < cashiers; i++) {
				Cashiers[i] = new Program5.Cashier(i);
			}
			
			// Simulation
			// CurrentCustomer is the object that all Cashiers pull from.
			Program5.Customer currentCustomer = null;
			for(int i = 0; i < 54000 && queue.isEmpty() != true; i++) {
				
				for(int j = 0; j < cashiers; j++) {
					// If currentCustomer is null, grab one from queue.
					if(currentCustomer == null) {
						currentCustomer = queue.poll();
					}
					
					// If the current Cashier does not have a Customer, 
					// it sees if it can take the currentCustomer.
					// If it can, it takes the currentCustomer, 
					// otherwise it adds to idleTime
					if(Cashiers[j].customer == null) {
						if(currentCustomer.arrivalTime <= i) {
							Cashiers[j].customer = currentCustomer;
							currentCustomer = null;
						} else {
							idleTime++;
						}
					}
					
					// If the current Cashier does have a Customer, 
					// it first checks if the service time has been set.
					// if it has not, it sets it to the current time (i), and adds the
					// to the wait time. If service time was set, it then checks if the 
					// Customer's endtime has been reached. If it has, it frees the 
					// Customer, and adds the taskTime the Customer took.
					if(Cashiers[j].customer != null) {
						if(Cashiers[j].customer.serviceTime == -1) {
							Cashiers[j].customer.setServiceTime(i);
							waitTime += Cashiers[j].customer.serviceTime - Cashiers[j].customer.arrivalTime;
						} else if(Cashiers[j].customer.endTime() <= i) {
							taskTime += Cashiers[j].customer.taskTime;
							Cashiers[j].customer = null;
						}
					}
				}
				
				// updates every cycle so if the Queue becomes empty, 
				// it knows where it finished at
				finishTime = i;
				
			}	
			
			System.out.println("Number of cashiers = " + cashiers);
			System.out.println("Number of customers = " + customers);
			System.out.printf("Average wait time = %.2f seconds\n", (waitTime));
			System.out.printf("Average idle time = %.2f seconds\n", (idleTime/cashiers));
			System.out.println("Total task time = " + taskTime + " seconds");
			System.out.println("Last customer was finished being served at time: " + finishTime);
			System.out.println();
		}
		
	}
}
