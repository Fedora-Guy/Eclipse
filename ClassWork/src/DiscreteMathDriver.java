
public class DiscreteMathDriver {
	public static void main(String[] agrs) {
		boolean p = DiscreteMath.F;
		System.out.println("p = " + p);
		
		boolean q = DiscreteMath.F;
		System.out.println("q = " + q);
		
		boolean notP = DiscreteMath.myNot(p);
		System.out.println("not P = " + notP);
		
		boolean pAndQ = DiscreteMath.myAnd(p,q);
		System.out.println("p AND q = " + pAndQ);
		
		boolean pOrQ = DiscreteMath.myOr(p,q);
		System.out.println("p OR q = " + pOrQ);
		
		boolean pXorQ = DiscreteMath.myXor(p,q);
		System.out.println("p XOR q = " + pXorQ);
		
		boolean ifPThenQ = DiscreteMath.myIf(p,q);
		System.out.println("IF p THEN q = " + ifPThenQ);
		
		boolean pIffQ = DiscreteMath.myIf(p,q);
		System.out.println("p IFF q = " + pIffQ);
	}
}
