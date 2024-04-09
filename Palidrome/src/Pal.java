import java.util.Stack;
import java.util.Queue;
import java.io.IOException;
import java.util.LinkedList;

public class Pal {
	
	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<Character>();
		char c;
		System.out.print("Enter string to check > ");
		try {
			while(!Character.isWhitespace(c  = (char)System.in.read())) {
				stack.push(c);
				queue.add(c);
			}
		}
		catch(IOException e) {
			System.out.println("Something went wrong: " + e);
			return;
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() != queue.remove()) {
				System.out.println("Not a palindrome.");
				return;
			}
		}
		System.out.println("Palindrome.");
	}
}
