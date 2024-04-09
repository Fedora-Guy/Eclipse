public class Fibonnaci {
  
  private static int value = 0;
   
  public Fibonnaci(int argValue) {
    value = value + argValue;
  }
  
  public Fibonnaci next() {
    Fibonnaci newFibonnaci = new Fibonnaci(value);    
    return newFibonnaci;
  }

  public String toString() {
    return "value = " + value;
  }

  public static void main(String[] args) {
    Fibonnaci test = new Fibonnaci(1);
    Fibonnaci nextFibonnaci = test.next();
    test.next();
    System.out.println(nextFibonnaci);
    Fibonnaci nextFibonnaci2 = nextFibonnaci.next();
    System.out.println(nextFibonnaci2);
  }
}