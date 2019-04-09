/*
 * Phone has letters on the number keys. For example, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... , 
 * and number 9 has WXYZ. Write a program that will print out all of the possible combination of those letters 
 * depending on the input.
 */

import java.util.*;

public class KeypadPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(keypadPermutation("29"));
	}
	
	public static List<String> keypadPermutation(String digits) {
		List<String> rst = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return rst;
		String[] map = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXTZ"};
		helper(digits, rst, map, new StringBuilder(), 0);
		return rst;
	}
	
	private static void helper(String digits, List<String> rst, String[] map, StringBuilder sb, int curr) {
		if (curr == digits.length()) {
			rst.add(sb.toString());
			return;
		}
		if (digits.charAt(curr) < '2' || digits.charAt(curr) > '9') 
			throw new IllegalArgumentException();
		String str = map[(digits.charAt(curr) - '0') - 2]; // since map shifts "2"
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			helper(digits, rst, map, sb, curr + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
