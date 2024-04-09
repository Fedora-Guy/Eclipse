// Juliette Troxell 
// Program #8 
// Create file of integers, tests if number of ints is a square of some int n, and if so print 2d array. 
// Then test if array forms magic square 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program8 {

  public static boolean checkMagicNumber(int[][] array, int size) {
    int sum = 0;
    int magicNumber = 0;
    // get the magic number
    for (int i = 0; i < size; i++) {
      magicNumber += array[0][i];
    }
    // check row
    for (int i = 0; i < size; i++) {
      sum = 0;
      for (int j = 0; j < array.length; j++) {
        sum += array[i][j];
      }
      if (sum != magicNumber) return false;
    }
    // check columns
    for (int i = 0; i < size; i++) {
      sum = 0;
      for (int j = 0; j < array.length; j++) {
        sum += array[j][i];
      }
      if (sum != magicNumber) return false;
    }
    sum = 0;
    // check diagonals
    for (int i = 0; i < size; i++) {
      sum += array[i][i];
    }
    if (sum != magicNumber) return false;
    sum = 0;
    for (int i = 0; i < size; i++) {
      sum += array[i][size - i - 1];
    }
    if (sum != magicNumber) return false;
    return true;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    Scanner readFile = null;
    try {
      System.out.println("Enter file name : ");
      String name = sc.next();
      readFile = new Scanner(new File(name));
      while (readFile.hasNext()) {
        int size = readFile.nextInt();
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            array[i][j] = readFile.nextInt();
          }
        }
        if (checkMagicNumber(array, size)) {
          System.out.println("Its a magic number");
        } else {
          System.out.println("Its not a magic number");
        }
      }
    } catch (FileNotFoundException x) {
      System.out.println("Wrong file name");
    }
  }
}
