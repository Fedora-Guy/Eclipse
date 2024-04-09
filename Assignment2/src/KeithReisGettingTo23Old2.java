import java.util.Random;

public class KeithReisGettingTo23Old2 {
	public static void main(String[] args) {
		int[] integers = new int[10];
		for(int i = 0; i < 10; i++) {
			integers[i] = i+1;
		}
		Random random = new Random();
		for(int i = 0; i<integers.length; i++) {
			int j = random.nextInt(i+1);
			int t = integers[i]; integers[i] = integers[j]; integers[j] = t;
		}
		
		int firstNumber = integers[0];
		int secondNumber = integers[1];
		int thirdNumber = integers[2];
		int fourthNumber = integers[3];
		
		System.out.println("Numbers: " + firstNumber + " " + secondNumber + " " + thirdNumber + " " + fourthNumber);
		
		boolean equals23 = false;
		//Attempt 1
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					for(int l = 0; l < 4; l++) {
						
					}
				}
			}
		}
		int response = 0;
		//Attempt 2
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if(k == 0) {
						if(j == 0) {
							if( i == 0) {
								response = firstNumber + secondNumber + thirdNumber + fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber + thirdNumber + fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber + thirdNumber + fourthNumber;
							} else {
								response = firstNumber / secondNumber + thirdNumber + fourthNumber;
							}
						} else if ( j == 1) {
							if( i == 0) {
								response = firstNumber + secondNumber - thirdNumber + fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber - thirdNumber + fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber - thirdNumber + fourthNumber;
							} else {
								response = firstNumber / secondNumber - thirdNumber + fourthNumber;
							}
						} else if ( j == 2) {
							if( i == 0) {
								response = firstNumber + secondNumber * thirdNumber + fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber * thirdNumber + fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber * thirdNumber + fourthNumber;
							} else {
								response = firstNumber / secondNumber * thirdNumber + fourthNumber;
							}
						} else {
							if( i == 0) {
								response = firstNumber + secondNumber / thirdNumber + fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber / thirdNumber + fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber / thirdNumber + fourthNumber;
							} else {
								response = firstNumber / secondNumber / thirdNumber + fourthNumber;
							}
						}
					} else if ( k == 1) {
						if(j == 0) {
							if( i == 0) {
								response = firstNumber + secondNumber + thirdNumber - fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber + thirdNumber - fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber + thirdNumber - fourthNumber;
							} else {
								response = firstNumber / secondNumber + thirdNumber - fourthNumber;
							}
						} else if ( j == 1) {
							if( i == 0) {
								response = firstNumber + secondNumber - thirdNumber - fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber - thirdNumber - fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber - thirdNumber - fourthNumber;
							} else {
								response = firstNumber / secondNumber - thirdNumber - fourthNumber;
							}
						} else if ( j == 2) {
							if( i == 0) {
								response = firstNumber + secondNumber * thirdNumber - fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber * thirdNumber - fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber * thirdNumber - fourthNumber;
							} else {
								response = firstNumber / secondNumber * thirdNumber - fourthNumber;
							}
						} else {
							if( i == 0) {
								response = firstNumber + secondNumber / thirdNumber - fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber / thirdNumber - fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber / thirdNumber - fourthNumber;
							} else {
								response = firstNumber / secondNumber / thirdNumber - fourthNumber;
							}
						}
					} else if ( k == 2) {
						if(j == 0) {
							if( i == 0) {
								response = firstNumber + secondNumber + thirdNumber * fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber + thirdNumber * fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber + thirdNumber * fourthNumber;
							} else {
								response = firstNumber / secondNumber + thirdNumber * fourthNumber;
							}
						} else if ( j == 1) {
							if( i == 0) {
								response = firstNumber + secondNumber - thirdNumber * fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber - thirdNumber * fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber - thirdNumber * fourthNumber;
							} else {
								response = firstNumber / secondNumber - thirdNumber * fourthNumber;
							}
						} else if ( j == 2) {
							if( i == 0) {
								response = firstNumber + secondNumber * thirdNumber * fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber * thirdNumber * fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber * thirdNumber * fourthNumber;
							} else {
								response = firstNumber / secondNumber * thirdNumber * fourthNumber;
							}
						} else {
							if( i == 0) {
								response = firstNumber + secondNumber / thirdNumber * fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber / thirdNumber * fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber / thirdNumber * fourthNumber;
							} else {
								response = firstNumber / secondNumber / thirdNumber * fourthNumber;
							}
						}
					} else {
						if(j == 0) {
							if( i == 0) {
								response = firstNumber + secondNumber + thirdNumber / fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber + thirdNumber / fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber + thirdNumber / fourthNumber;
							} else {
								response = firstNumber / secondNumber + thirdNumber / fourthNumber;
							}
						} else if ( j == 1) {
							if( i == 0) {
								response = firstNumber + secondNumber - thirdNumber / fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber - thirdNumber / fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber - thirdNumber / fourthNumber;
							} else {
								response = firstNumber / secondNumber - thirdNumber / fourthNumber;
							}
						} else if ( j == 2) {
							if( i == 0) {
								response = firstNumber + secondNumber * thirdNumber / fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber * thirdNumber / fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber * thirdNumber / fourthNumber;
							} else {
								response = firstNumber / secondNumber * thirdNumber / fourthNumber;
							}
						} else {
							if( i == 0) {
								response = firstNumber + secondNumber / thirdNumber / fourthNumber;
							} else if( i == 1) {
								response = firstNumber - secondNumber / thirdNumber / fourthNumber;
							} else if( i == 2) {
								response = firstNumber * secondNumber / thirdNumber / fourthNumber;
							} else {
								response = firstNumber / secondNumber / thirdNumber / fourthNumber;
							}
						}
					}
					
					if(response == 23) {
						System.out.println(i + " " + j + " " + k);
						System.exit(0);
					}
				}
			}
		}
		
	}
	
	
}
