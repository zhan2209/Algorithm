/*
 * Print all valid phone numbers of length n subject to following constraints:
 * If a number contains a 4, it should start with 4
 * No two consecutive digits can be same
 * Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
 */

import java.util.*;

public class TelephoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateTelephoneNumber(2));
	}
	
	public static List<String> generateTelephoneNumber(int n) {
		List<String> rst = new ArrayList<>();
		if (n <= 0)
			return rst;		
		helper(n, rst, new StringBuilder());
		return rst;
	}
	
// CANNOT use (char) of "int", will get NULL
// CANNOT use Character.toChars(int) here since int is within 0~9

	private static void helper(int n, List<String> rst, StringBuilder sb) {
		if (sb.length() == n) {
			rst.add(sb.toString());
			return;
		}
		for (char digit = '0'; digit < '9'; digit++) {
			if (digit == '2' || digit == '7')
				continue;
			if (digit == '4' && sb.length() > 0)
				continue;
			if (sb.length() > 0 && digit == sb.charAt(sb.length() - 1))
				continue;
			sb.append(digit);
			helper(n, rst, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
