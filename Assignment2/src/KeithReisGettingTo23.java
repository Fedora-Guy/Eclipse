/* Name: Keith Reis
 * Program Name: Getting to 23
 * Due Date: 2/16/22
 * Description: Using 4 ints, and a combination of math, see if they equal 23
 * Assistance: None
 */
import java.util.Random;

public class KeithReisGettingTo23 {
	public static void main(String[] agrs) {
		
		// Creates an Array 1-10, then randomizes it.
		// Next it puts the first four ints into a new Array.
		// Lastly it prints the four numbers
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Random random = new Random();
		for(int i = 0; i <= 9; i++) {
			int j = random.nextInt(i+1);
			int t = array[i]; 
			array[i] = array[j]; 
			array[j] = t;
		}
		int[] ints = {array[0], array[1], array[2], array[3]};
		System.out.println("Numbers: " + ints[0] + " "
				+ ints[1] + " " + ints[2] + " " + ints[3]);
		
		// Finds out if the numbers can equal 23
		// It kinda just brute forces it.
		// Explanation of code:
		// It has 4 loops for each variable of the ints[] array. Then it has 3 loops for the operator
		// Using switch statements and the 3 loops for the operator determines what the math equation looks like.
		// Then using the outer 4 loops it determines in what order the numbers are used.
		// (Since we know that we can't have repeated numbers, I have a check for this included in the code below)
		int response = 0;
		String[] nums = {"", "", "", ""};
		String[] ops = {"", "", ""};
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					for(int l = 0; l < 4; l++) {
						for(int pos1 = 0; pos1 < 4; pos1++) {
							for(int pos2 = 0; pos2 < 4; pos2++) {
								for(int pos3 = 0; pos3 < 4; pos3++) {
									switch(pos3) {
										case 0: 
											switch(pos2) {
												case 0:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) + ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "+"; ops[2] = "+";
															break;
														case 1:
															response = (((ints[i] - ints[j]) + ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "+"; ops[2] = "+";
															break;
														case 2:
															response = (((ints[i] / ints[j]) + ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "+"; ops[2] = "+";
															break;
														case 3:
															response = (((ints[i] * ints[j]) + ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "+"; ops[2] = "+";
															break;
														default:
															break;
													}
													break;
												case 1:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) - ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "-"; ops[2] = "+";
															break;
														case 1:
															response = (((ints[i] - ints[j]) - ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "-"; ops[2] = "+";
															break;
														case 2:
															response = (((ints[i] / ints[j]) - ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "-"; ops[2] = "+";
															break;
														case 3:
															response = (((ints[i] * ints[j]) - ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "-"; ops[2] = "+";
															break;
														default:
															break;
													}
													break;
												case 2:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) / ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "/"; ops[2] = "+";
															break;
														case 1:
															response = (((ints[i] - ints[j]) / ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "/"; ops[2] = "+";
															break;
														case 2:
															response = (((ints[i] / ints[j]) / ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "/"; ops[2] = "+";
															break;
														case 3:
															response = (((ints[i] * ints[j]) / ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "/"; ops[2] = "+";
															break;
														default:
															break;
													}
													break;
												case 3:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) * ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "*"; ops[2] = "+";
															break;
														case 1:
															response = (((ints[i] - ints[j]) * ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "*"; ops[2] = "+";
															break;
														case 2:
															response = (((ints[i] / ints[j]) * ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "*"; ops[2] = "+";
															break;
														case 3:
															response = (((ints[i] * ints[j]) * ints[k]) + ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "*"; ops[2] = "+";
															break;
														default:
															break;
													}
													break;
												default:
													break;
											}
											break;
										case 1:
											switch(pos2) {
												case 0:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) + ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "+"; ops[2] = "-";
															break;
														case 1:
															response = (((ints[i] - ints[j]) + ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "+"; ops[2] = "-";
															break;
														case 2:
															response = (((ints[i] / ints[j]) + ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "+"; ops[2] = "-";
															break;
														case 3:
															response = (((ints[i] * ints[j]) + ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "+"; ops[2] = "-";
															break;
														default:
															break;
													}
													break;
												case 1:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) - ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "-"; ops[2] = "-";
															break;
														case 1:
															response = (((ints[i] - ints[j]) - ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "-"; ops[2] = "-";
															break;
														case 2:
															response = (((ints[i] / ints[j]) - ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "-"; ops[2] = "-";
															break;
														case 3:
															response = (((ints[i] * ints[j]) - ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "-"; ops[2] = "-";
															break;
														default:
															break;
													}
													break;
												case 2:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) / ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "/"; ops[2] = "-";
															break;
														case 1:
															response = (((ints[i] - ints[j]) / ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "/"; ops[2] = "-";
															break;
														case 2:
															response = (((ints[i] / ints[j]) / ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "/"; ops[2] = "-";
															break;
														case 3:
															response = (((ints[i] * ints[j]) / ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "/"; ops[2] = "-";
															break;
														default:
															break;
													}
													break;
												case 3:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) * ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "*"; ops[2] = "-";
															break;
														case 1:
															response = (((ints[i] - ints[j]) * ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "*"; ops[2] = "-";
															break;
														case 2:
															response = (((ints[i] / ints[j]) * ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "*"; ops[2] = "-";
															break;
														case 3:
															response = (((ints[i] * ints[j]) * ints[k]) - ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "*"; ops[2] = "-";
															break;
														default:
															break;
													}
													break;
												default:
													break;
											}
											break;
										case 2:
											switch(pos2) {
												case 0:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) + ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "+"; ops[2] = "/";
															break;
														case 1:
															response = (((ints[i] - ints[j]) + ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "+"; ops[2] = "/";
															break;
														case 2:
															response = (((ints[i] / ints[j]) + ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "+"; ops[2] = "/";
															break;
														case 3:
															response = (((ints[i] * ints[j]) + ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "+"; ops[2] = "/";
															break;
														default:
															break;
													}
													break;
												case 1:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) - ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "-"; ops[2] = "/";
															break;
														case 1:
															response = (((ints[i] - ints[j]) - ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "-"; ops[2] = "/";
															break;
														case 2:
															response = (((ints[i] / ints[j]) - ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "-"; ops[2] = "/";
															break;
														case 3:
															response = (((ints[i] * ints[j]) - ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "-"; ops[2] = "/";
															break;
														default:
															break;
													}
													break;
												case 2:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) / ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "/"; ops[2] = "/";
															break;
														case 1:
															response = (((ints[i] - ints[j]) / ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "/"; ops[2] = "/";
															break;
														case 2:
															response = (((ints[i] / ints[j]) / ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "/"; ops[2] = "/";
															break;
														case 3:
															response = (((ints[i] * ints[j]) / ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "/"; ops[2] = "/";
															break;
														default:
															break;
													}
													break;
												case 3:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) * ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "*"; ops[2] = "/";
															break;
														case 1:
															response = (((ints[i] - ints[j]) * ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "*"; ops[2] = "/";
															break;
														case 2:
															response = (((ints[i] / ints[j]) * ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "*"; ops[2] = "/";
															break;
														case 3:
															response = (((ints[i] * ints[j]) * ints[k]) / ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "*"; ops[2] = "/";
															break;
														default:
															break;
													}
													break;
												default:
													break;
											}
											break;
										case 3:
											switch(pos2) {
												case 0:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) + ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "+"; ops[2] = "*";
															break;
														case 1:
															response = (((ints[i] - ints[j]) + ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "+"; ops[2] = "*";
															break;
														case 2:
															response = (((ints[i] / ints[j]) + ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "+"; ops[2] = "*";
															break;
														case 3:
															response = (((ints[i] * ints[j]) + ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "+"; ops[2] = "*";
															break;
														default:
															break;
													}
													break;
												case 1:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) - ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "-"; ops[2] = "*";
															break;
														case 1:
															response = (((ints[i] - ints[j]) - ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "-"; ops[2] = "*";
															break;
														case 2:
															response = (((ints[i] / ints[j]) - ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "-"; ops[2] = "*";
															break;
														case 3:
															response = (((ints[i] * ints[j]) - ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "-"; ops[2] = "*";
															break;
														default:
															break;
													}
													break;
												case 2:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) / ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "/"; ops[2] = "*";
															break;
														case 1:
															response = (((ints[i] - ints[j]) / ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "/"; ops[2] = "*";
															break;
														case 2:
															response = (((ints[i] / ints[j]) / ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "/"; ops[2] = "*";
															break;
														case 3:
															response = (((ints[i] * ints[j]) / ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "/"; ops[2] = "*";
															break;
														default:
															break;
													}
													break;
												case 3:
													switch(pos1) {
														case 0:
															response = (((ints[i] + ints[j]) * ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "+"; ops[1] = "*"; ops[2] = "*";
															break;
														case 1:
															response = (((ints[i] - ints[j]) * ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "-"; ops[1] = "*"; ops[2] = "*";
															break;
														case 2:
															response = (((ints[i] / ints[j]) * ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "/"; ops[1] = "*"; ops[2] = "*";
															break;
														case 3:
															response = (((ints[i] * ints[j]) * ints[k]) * ints[l]);
															nums[0] = "" + ints[i]; nums[1] = "" + ints[j];
															nums[2] = "" + ints[k]; nums[3] = "" + ints[l];
															ops[0] = "*"; ops[1] = "*"; ops[2] = "*";
															break;
														default:
															break;
													}
													break;
												default:
													break;
											}											
										default:
											break;
									}
									// If any of the ints equal each other, that response is invalid, so it resets response to 0.
									// Otherwise, if response equals 23, it prints them out.
									if(ints[i] == ints[j] || ints[i] == ints[k] || ints[i] == ints[l] || 
											ints[j] == ints[k] || ints[j] == ints[l] || ints[k] == ints[l]) {
										response = 0;
									} 
									
									if(response == 23) {
										System.out.println("(((" + nums[0] + ops[0] + nums[1] + ")" + ops[1]
												+ nums[2] + ")" + ops[2] + nums[3] + ") = 23");
										System.exit(0);
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("No Solution");
		
	}
}
