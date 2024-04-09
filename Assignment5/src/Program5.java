import java.util.Random;
import java.util.Arrays;

public class Program5 {

    public static Random random = new Random();

    static class Customer implements Comparable<Customer> {
	int num;                  // number of the customer.
	public int arrivalTime;   // time customer arrives at check-out line (in seconds since 7:00 AM).
	public int taskTime;      // number of seconds it will take to serve the customer.
	public int serviceTime;   // time (in seconds since 7:00 AM) that customer was served.
	public Customer() {}
	public Customer(int num, int arrivalTime, int taskTime) {
	    this.num = num;
	    this.arrivalTime = arrivalTime;
	    this.taskTime = taskTime;
	    serviceTime = -1; // customer not served yet.
	}
	public String toString() {
	    return "(" + num + ":" + arrivalTime + "," + taskTime + "," + serviceTime + "," + (serviceTime - arrivalTime) + ")";
	}
	public int compareTo(Customer a) {
	    return arrivalTime - a.arrivalTime;
	}
	public void setNum(int num) {
	    this.num = num;
	}
	public void setServiceTime(int serviceTime) {
	    this.serviceTime = serviceTime;
	}
	public int endTime() {
	    return serviceTime + taskTime;
	}
    }

    static class Cashier {
	int num;                  // number of the cashier.
	public Customer customer; // customer that the cashier is waiting on.
	public int idleTime;      // time that the cashier becomes idle.
	public Cashier() {}
	public Cashier(int num, Customer customer, int idleTime) {
	    this.num = num;
	    this.customer = customer;
	    this.idleTime = idleTime;
	}
	public Cashier(int num) {
	    this(num, null, 0);
	}
	public String toString() {
	    return "(" + num + ": " + customer + "," + idleTime + ")";
	}
	public void setIdleTime(int idleTime) {
	    this.idleTime = idleTime;
	}
    }

    public static Customer[] genCustomers(int N) {
	Customer[] customers = new Customer[N];
	for(int i=0; i<N; i++) {
	    int arrivalTime = (int)(Math.max(Math.min((random.nextGaussian() + 3.25) / 7 * 54000, 54000-1), 0));
	    int taskTime = (int)(Math.max((random.nextGaussian() + 3.25) * 60, 60));
	    customers[i] = new Customer(0, arrivalTime, taskTime);
	}
	Arrays.sort(customers);
	for(int i=0; i<N; i++)
	    customers[i].setNum(i);
	return customers;
    }
}