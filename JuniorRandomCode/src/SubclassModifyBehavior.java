
public class SubclassModifyBehavior {
	public static void main(String[] args) {
		A a = new A(3);
		B b = new B();
		System.out.println("A + 3: " + a.add(3));
		System.out.println("B + 3: " + b.add(3));
	}
}


class A {
	int x = 3;
	public A(int n) { x=n;	}
	public int add(int n) {
		return x + n;
	}
}

class B extends A {
	int x = 6;
	public B() {
		super(x);
	}
	
	public int add(int n) { }
}