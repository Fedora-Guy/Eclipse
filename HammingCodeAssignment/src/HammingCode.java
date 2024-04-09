/* Name: Keith Reis
 * Program Name: HammingCode
 * Due Date: 3/28/23
 * Description: Tests the Programmer's knowledge and capability of sending encrypted data and error-correction.
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Random;


public class HammingCode {
	static final boolean debug = false; // Use allow System.out.println for debugging purposes
	
	static final int MAX_ARRAY_SIZE = 1024; // An arbitrary number so I can use an array 
	public static void main(String[] args) {
		try {
			FileInputStream dataFile = new FileInputStream("src\\DataFile.txt");
			int[] pattern = new int[MAX_ARRAY_SIZE]; // Set to size MAX_ARRAY_SIZE
			int iteration = 0;
			int test = 0;
			// Read in DataFile
			BufferedInputStream scan = new BufferedInputStream(dataFile); 
			while(true) {
				test = scan.read(); // Reads ASCII Character as an Byte {maximum of 8 bits}
								
				if(test == -1) {
					break; // If we have reached the end of the file.
				} else if (iteration == MAX_ARRAY_SIZE-1) { // The contents of the file is larger than a pre-defined array size
					System.err.println("DataFile is larger than the MAX_ARRAY_SIZE in HammingCode");
					System.exit(0);
				} else {
					pattern[iteration] = test;
				}
				
				iteration++;
			}
			
			int length = iteration; // The original Length of the read-in File.
			
			if(debug) {
				System.out.println(length);
				System.out.println();
				System.out.println("Encoder.start(): ");
			}
			// Pass in the DataFile to the Encoder Class
			Encoder encoder = new Encoder(pattern, length);
			encoder.start();
			if(debug) {
				System.out.println("Done encoding");
			}
			// Create and start the Decoder Class
			Decoder decoder = new Decoder();
			decoder.start();
			if(debug) {
				System.out.println("Done decoding");
			}
			scan.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("The DataFile either doesn't exist OR it exists in the wrong spot");
			System.exit(0);
		}
	}

}


class Encoder {
	static final boolean debug = false;
	int length;
	int[] pattern;
	
	public Encoder (int[] pattern, int length) {
		this.pattern = pattern; // The Byte array
		this.length = length; // the length of the byte array that is used.
	}
	
	public void start () {
		
		// Done to clear the File if it had any content in it previously
		try {
			FileOutputStream outputSource = new FileOutputStream("src\\Encoded.txt");
			BufferedOutputStream encoded = new BufferedOutputStream(outputSource);
			encoded.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		// For Each Byte in the Array, send a new line to the Encoded.txt file
		// That New Line should be encoded (properly)
		
		for(int i = 0; i < length; i++) { // For each byte in the array
			// Check how many bits are in that byte, 
			// and how many redundant bits we must use for that one byte
			int currentByte = pattern[i];
			// How many Bits *required* for currentByte
			// 		Integer.SIZE {32} 	- 		The amount of Leading Zeros = The number of bits that are used for Data
			int dataBits = Integer.SIZE - Integer.numberOfLeadingZeros(currentByte);
			int parityBits = 0;
			while (Math.pow(2, parityBits) < (dataBits + parityBits + 1)) {
	        	parityBits++;
	        }
			int codewordBits = dataBits + parityBits; // The number of bits in our codeword
			
			// Encoding Here
						
			// Create a codewordArray that contains all the bits from the currentByte 
			// Every position that is a x^2 is a redundant bit {1, 2, 4, 8, 16, 32, 64, etc.}
			// Otherwise fill in from the binaryArray
			int[] codewordArray = new int[codewordBits];
			int currentdataBit = 0;
			for(int j = 0; j < codewordBits; j++) {
				// if j as a binary representation only has 1 bit
				if(Integer.bitCount(j+1) == 1) { // this position is a redundant bit
					codewordArray[j] = 0;
				} else {
					codewordArray[j] = ((currentByte >> currentdataBit) & 1); // right shifts by current data Bit, then grabs the lowest bit 100 0001
					currentdataBit++;
				}
			}
			
			// now we take our codewordArray and encode the parity bits
			for(int j = 0; j < codewordBits; j++) {
				if(Integer.bitCount(j+1) == 1) { // If our current position is a parity bit
					for(int k = 0; k < codewordBits; k++) { // Search through the array again
						if( (((j+1) & (k+1)) == (j+1)) && (j != k)) { // If the k bit is one of the bits the current parity bit cares about
							codewordArray[j] = codewordArray[j] ^ codewordArray[k]; // XOR/Parity; if neither or both are 1, set to 0. If just one of them contains 1, set to 1.
							if(debug) {
								System.out.println("j: " + j);
								System.out.println("k: " + k);
								System.out.println("j & k: " + (j&k));
								System.out.print("codewordArray, Parity Bit (j+1): " + (j) + " + k: " + k + ": ");
								for(int q = 0; q < codewordArray.length; q++) {
									System.out.print(codewordArray[q]);
								}
								System.out.println();
							}
						}
					}
				}
			}
			
			if(debug) {
				System.out.println("ASCII: " + pattern[i]);
				System.out.println("Character: " + Character.toString(pattern[i]));
				String binaryArray = Integer.toBinaryString(pattern[i]);
				System.out.println("binaryArray: " + binaryArray);
				System.out.println("dataBits: " + dataBits);
				System.out.println("parityBits: " + parityBits);
				System.out.println("codewordBits: " + codewordBits);
				System.out.println("codewordArray: ");
				for(int j = 0; j < codewordArray.length; j++) {
					System.out.print(codewordArray[j]);
				}
				System.out.println();
			}
			
			
			// Push the codewordArray to the Encoded.txt file
			try {
				FileOutputStream outputSource = new FileOutputStream("src\\Encoded.txt", true);
				BufferedOutputStream encoded = new BufferedOutputStream(outputSource);
				for(int j = 0; j < codewordBits; j++) {
					encoded.write(codewordArray[j]); // Write each bit out into the text document
				}
				encoded.write("\n".getBytes()); // Creates a new line character so each byte is on its own line
				encoded.flush();
				encoded.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
			
		}
		
		return;
	}
	
}

class Decoder {
	static final boolean debug = false;
	static final int MAX_ARRAY_SIZE = 1024; // An arbitrary number so I can use an array 

	public Decoder () {
		
	}
	
	public void start () {
		
		
		try {
			FileInputStream encodedFile = new FileInputStream("src\\Encoded.txt");
			// Read in the Encoded File
			BufferedInputStream scan = new BufferedInputStream(encodedFile); 
			// Done to clear the File if it had any content in it previous
			FileOutputStream outputSource = new FileOutputStream("src\\Decoded.txt");
			BufferedOutputStream decoded = new BufferedOutputStream(outputSource);

			int test = 0; // The read-in value from the encoded File
			int length = 0; // How many characters are in the encoded File
			int[] entireMessage = new int[MAX_ARRAY_SIZE]; // Set to size MAX_ARRAY_SIZE so i can use this
			int iteration = 0;
			while(true) {
				
				test = scan.read();
				
				if(test == -1) {
					break; // Once we have reached the end of the file
				} else if (test == 10) { // If we have reached a new line character, aka a new character in the encoded File
					entireMessage[iteration] = test;
					length++; // increment by one for each character
				} else if (iteration == MAX_ARRAY_SIZE-1) { // The contents of the file is larger than a pre-defined array size
					System.err.println("Encoded.txt is larger than the MAX_ARRAY_SIZE in Decoded");
					System.exit(0);
				} else { // Otherwise we have a byte of data that is equivalent to a 1 or 0
					entireMessage[iteration] = test;
				}
				iteration++;
			}
			
			// Decoding the entireMessage
			
			// Create a for loop for every Character ~ aka from 0 until length
			int offset = 0;
			for(int i = 0; i < length; i++) {
				// figure out how many codewordBits are in this particular codeword
				int codewordBits = 0;
				while(true) {
					if(entireMessage[codewordBits+offset] == 10) {
						break;
					} else {
						codewordBits++;
					}
				}
				
				// Create a new array of size codewordBits from the entireMessage array for the current codeword
				int[] currentCodeword = new int[codewordBits];
				for(int j = 0; j < currentCodeword.length; j++) {
					currentCodeword[j] = entireMessage[j+offset];
				}
				offset+=codewordBits+1;
				
				// How many bits are Data Bits? How many bits are Parity Bits?
				// We know 2^r >= (m+r) + 1, where m is Data bits, and r is parity
				// so therefore 2^r >= codewordBits -> math.ceil(ln(codewordBits)/ln(2)) = r
				int parityBits = (int)Math.ceil(Math.log(codewordBits)/Math.log(2));
				int dataBits = codewordBits - parityBits;
				
				
				// Corrupting a random bit, randomly
				Random random = new Random();
				if(random.nextBoolean()) {
					int bitPosition = random.nextInt(codewordBits);
					currentCodeword[bitPosition] = (currentCodeword[bitPosition] ^ 1); // Flips this bit
					if(debug) {
						System.out.println("bitPosition: " + bitPosition);
					}
				}
				
				// Let's start Decoding
				boolean errorDetected = false;
				for(int j = 0; j < codewordBits; j++) {
					if(Integer.bitCount(j+1) == 1) { // If our current position of j is a parity bit
						int givenParity = currentCodeword[j];
						int calculatedParity = 0;
						for(int k = 0; k < codewordBits; k++) { // Search through the array again
							if(((j+1) & (k+1)) == (j+1) && (j != k)) { // If the k bit is one of the bits this parity cares about, AND it's not the parity bit itself
								calculatedParity = calculatedParity ^ currentCodeword[k];
								if(debug) {
									System.out.println("j: " + j);
									System.out.println("k: " + k);
									System.out.println("calculatedParity: " + calculatedParity);
								}
							}
						}

						// Decoding Logic
						if(givenParity != calculatedParity) { // There is a bit error somewhere
							errorDetected = true;
						}
						
						
						if(debug) {
							System.out.println("givenParity: " + givenParity);
							System.out.println("calculatedParity: " + calculatedParity);
							System.out.println("currentCodeword: ");
							for(int k = 0; k < currentCodeword.length; k++) {
								System.out.print(currentCodeword[k]);
							}
							System.out.println();
							System.out.println("errorDetected: " + errorDetected);
							System.out.println();
						}
					}
				}
				
				// An error was detected, let's fix it
				// Example
				// original:  11000000110
				// corrupted: 11000010110
				int errorLocation = 0;
				if(errorDetected) { // Loop through ALL the 1-bits and XOR them as you go
					for(int j = 0; j < codewordBits; j++) {
						if(currentCodeword[j] == 1) {
							errorLocation ^= (j+1);
						}
					}
					// After looping through all of them, errorLocation's binary should be the index that is wrong
					// Reverse the bit at errorLocation (minus 1 to accommodate for array location)
					
					errorLocation--;
					currentCodeword[errorLocation] = (currentCodeword[errorLocation] ^ 1);
					if(debug) {
						System.out.println("errorLocation: " + errorLocation);
						System.out.println("currentCodeword: " + currentCodeword);
					}
				}				
				// Once the decoding has finished, let's get the Data Bits, and then print out the correct thing to Decoded.txt
				int[] dataArray = new int[dataBits];
				int dataPosition = 0;
				for(int j = 0; j < codewordBits; j++) {
					if(Integer.bitCount((j+1)) > 1) { // If it's not a parity Bit
						dataArray[dataPosition] = currentCodeword[j];
						dataPosition++;
					}
				}
				
				// Convert the dataArray back into ASCII, then write that into the Decoded.txt file
				int data = 0;
				for(int j = 0; j < dataBits; j++) {
					if(dataArray[j] == 1) {
						data += (int)Math.pow(2.0, j);
					}
				}
				decoded.write(data);
				
				if(debug) {
					System.out.println("i: " + i);
					System.out.println("codewordBits: " + codewordBits);
					System.out.println("parityBits: " + parityBits);
					System.out.println("dataBits: " + dataBits);
					System.out.println("currentCodeword: " + currentCodeword);
					System.out.println("entireMessage: " + entireMessage);
					System.out.println("dataArray: " + dataArray);
					System.out.println("Character: " + Character.toString(data));
				}
				
			}
			decoded.close();
			scan.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		return;
	}
}