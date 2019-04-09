/*
 * Given a string that has{},[],() and characters. Check if the string is balanced. 
 * E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
 */

import java.util.*;

public class BalancedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanced("{a[(b)]}"));
		System.out.println(balanced("{a[(b])}"));
	}
	
	public static boolean balanced(String str) {
		if (str == null || str.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (curr == '{' || curr == '[' || curr == '(') {
				stack.push(curr);
			} else if (curr == '}' || curr == ']' || curr == ')') {
				if (stack.isEmpty() || !match(stack.pop(), curr))
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	private static boolean match(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
	}

}
