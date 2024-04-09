
public class DiscreteMath {
	public static boolean T = true;
	public static boolean F = false;
	
	public static boolean myNot(boolean p) {
		if(p)
			return F;
		else
			return T;
	}
	
	public static boolean myAnd(boolean p, boolean q) {
		if(p && q)
			return T;
		else
			return F;
	}
	
	public static boolean myOr(boolean p, boolean q) {
		if(p || q)
			return T;
		else
			return F;
	}
	
	public static boolean myXor(boolean p, boolean q) {
		if(p || q && !(p && q))
			return T;
		else
			return F;
	}
	
	public static boolean myIf(boolean p, boolean q) {
		if(p && !q)
			return F;
		else
			return T;
	}
	
	public static boolean myIff(boolean p, boolean q) {
		if(p == q)
			return T;
		else
			return F;
	}
}
