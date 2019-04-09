/*
 * The decimal and octal values of some numbers are both palindromes sometimes. Find such numbers within a given range.
 */

import java.util.*;

public class OctalAndDecimalPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPalindrome(1, 1000));
	}
	
	public static List<Integer> findPalindrome(int start, int end) {
		List<Integer> rst = new ArrayList<>();
		if (start > end)
			return rst;
		
		for (int i = start; i <= end; i++) {
			String deci = Integer.toString(i, 10);
			String oct = Integer.toString(i, 8);
			if (isPalindrome(deci) && isPalindrome(oct))
				rst.add(i);
		}
		return rst;
	}
	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

}
