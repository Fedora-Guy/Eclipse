
class PrimeExample {
	
	public static void main(String args[]) {
		BackUp backup = new BackUp();
		backup.close();
	}
}


class BackUp {
	
	public BackUp() {
		System.out.println("I'm in the same file as PrimeExample nerd");
	}
	
	void close() {
		System.exit(0);
	}
}
