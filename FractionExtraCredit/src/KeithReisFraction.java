
public class KeithReisFraction {
	//variables
	private int numerator = 0;
	private int denominator = 0;
	private int GCD = 0;
	private int baseNumerator = 0;
	private int baseDenominator = 0;
	
	public KeithReisFraction(int argNumber) {
		numerator = argNumber;
		denominator = 1;
		baseNumerator = numerator;
		baseDenominator = denominator;
	}
	
	public KeithReisFraction(int argNumerator, int argDenominator) {
		GCD = eulerGCD(argNumerator, argDenominator);
		numerator = (argNumerator / GCD);
		denominator = (argDenominator / GCD);
		
		if(denominator < 0) {
			denominator *= -1;
			numerator *= -1;
		}
		
		if(numerator == 0) {
			denominator = 1;
		}
		baseNumerator = numerator;
		baseDenominator = denominator;
	}
	
	public String toString() {
		String displayString = "";
		
		if(denominator == 1) {
			displayString += numerator;
		} else if (denominator == 0) {
			displayString = "Undefined";
		} else {
			displayString = numerator+"/"+denominator;
		}
		
		return displayString;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	
	public int eulerGCD(int arg1, int arg2) {
		if(arg1 < 0) {
			arg1 *= -1;
		} else if(arg2 < 0) {
			arg2 *= -1;
		}
		if(arg1 == 0 || arg2 == 0) {
			return 1;
		} 
		if(arg1 == arg2) {
			return arg1;
		}
		
		if(arg1 != arg2) {
			if(arg1 > arg2) {
				arg1 = arg1-arg2;
			} else {
				arg2 = arg2-arg1;
			}
		}
		
		return eulerGCD(arg1, arg2);
	}
	
	
	
	public double convertToDecimal() {
		return (double)numerator/denominator;
	}
	
	public KeithReisFraction reciprocal() {
		return new KeithReisFraction(denominator, numerator);
	}
	
	public KeithReisFraction plus(KeithReisFraction f) {
		int fraction1Numerator = numerator;
		int fraction1Denominator = denominator;
		int fraction2Numerator = f.getNumerator();
		int fraction2Denominator = f.getDenominator();
		
		fraction1Numerator *= fraction2Denominator;
		fraction1Denominator *= fraction2Denominator;
		fraction2Numerator *= denominator;
		fraction2Denominator *= denominator;
		
		int fractionFinalNumerator = fraction1Numerator + fraction2Numerator;
		int fractionFinalDenominator = fraction1Denominator;
		
		return new KeithReisFraction(fractionFinalNumerator, fractionFinalDenominator);
	}
	
	public KeithReisFraction minus(KeithReisFraction f) {
		int fraction1Numerator = numerator;
		int fraction1Denominator = denominator;
		int fraction2Numerator = f.getNumerator();
		int fraction2Denominator = f.getDenominator();
		
		fraction1Numerator *= fraction2Denominator;
		fraction1Denominator *= fraction2Denominator;
		fraction2Numerator *= denominator;
		fraction2Denominator *= denominator;
		
		int fractionFinalNumerator = fraction1Numerator - fraction2Numerator;
		int fractionFinalDenominator = fraction1Denominator;
		
		return new KeithReisFraction(fractionFinalNumerator, fractionFinalDenominator);
	}
	
	public KeithReisFraction times(KeithReisFraction f) {
		int fraction1Numerator = numerator;
		int fraction1Denominator = denominator;
		int fraction2Numerator = f.getNumerator();
		int fraction2Denominator = f.getDenominator();
		
		int fractionFinalNumerator = fraction1Numerator * fraction2Numerator;
		int fractionFinalDenominator = fraction1Denominator * fraction2Denominator;
		
		return new KeithReisFraction(fractionFinalNumerator, fractionFinalDenominator);
	}
	
	public KeithReisFraction divide(KeithReisFraction f) {
		return times(f.reciprocal());
	}
	
	/* //Non-Recursive 
	public KeithReisFraction toThePowerOfNonRecursive(int e) {
		
		int fractionFinalNumerator = numerator;
		int fractionFinalDenominator = denominator;
		
		while(e > 1) {
			fractionFinalNumerator *= numerator;
			fractionFinalDenominator *= denominator;
			e--;
		}
		
		return new KeithReisFraction(fractionFinalNumerator, fractionFinalDenominator);
	} */
	
	//! TODO FINISHED!!!
	public KeithReisFraction toThePowerOf(int e) {
//		System.out.println("Num: " + numerator + "\tDen: " + denominator + "\tE: " + e); FOR TESTING ONLY
		
		if(e != 0 && e != 1) {
			if(e < 0) {
				int temp = numerator;
				numerator = denominator;
				denominator = temp;
				
				int baseTemp = baseNumerator;
				baseNumerator = baseDenominator;
				baseDenominator = baseTemp;
				
				toThePowerOf((e)*-1);
			} else if(e > 0) {
				numerator *= baseNumerator;
				denominator *= baseDenominator;	
				toThePowerOf(e-1);
			}			
		} else if (e == 0) {
			numerator = 1;
			denominator = 1;
		} 
			return new KeithReisFraction(numerator, denominator);
	}
	
	/* //MAIN CODE FOR TESTING ONLY
	 public static void main(String[] args) {
		
		KeithReisFraction fraction1 = new KeithReisFraction(5, -6);
		KeithReisFraction fraction2 = new KeithReisFraction(15, 30);
		KeithReisFraction fraction3 = new KeithReisFraction(5, 6);
		KeithReisFraction fraction4 = new KeithReisFraction(1, 4);
		
		System.out.println(fraction1);
		System.out.println(fraction2);
		System.out.println(fraction3);
		System.out.println(fraction4);
		System.out.println();
		
//		System.out.println(fraction1.convertToDecimal());
//		System.out.println(fraction2.convertToDecimal());
//		System.out.println(fraction3.convertToDecimal());
//		System.out.println(fraction4.convertToDecimal());
		
//		System.out.println("addition: " + fraction3.plus(fraction4));
//		System.out.println(fraction3);
//		System.out.println(fraction4 + "\n");
		
//		System.out.println("subtraction: " + fraction4.minus(fraction4));
//		System.out.println(fraction3);
//		System.out.println(fraction4 + "\n");
		
//		System.out.println("multiplication: " + fraction3.times(fraction1));
//		System.out.println(fraction3);
//		System.out.println(fraction1 + "\n");
		
//		System.out.println("division: " + fraction3.divide(fraction1));
//		System.out.println(fraction3);
//		System.out.println(fraction1.reciprocal() + "\n");
		
//		System.out.println();
//		System.out.println(fraction3);
//		System.out.println("power: " + fraction3.toThePowerOfNonRecursive(0));
//		System.out.println(fraction3);
		
		System.out.println();
		System.out.println(fraction3);
		System.out.println("PAIN: " + fraction3.toThePowerOf(-8));
		System.out.println(fraction3.convertToDecimal());
	} */
}
