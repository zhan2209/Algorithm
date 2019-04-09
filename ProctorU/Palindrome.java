/*
 * Print all palindromes of size greater than or equal to 3 of a given string. (How to do it with DP)?
 */

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAllPalindrome("abacolocxhooooh"));
	}

	public static Set<String> findAllPalindrome(String str) {
		Set<String> rst = new HashSet<>();
		if (rst == null || str.length() == 0)
			return rst;
		for (int i = 0; i < str.length(); i++) {
			findPalindrome(rst, str, i, i);
			findPalindrome(rst, str, i, i + 1);
		}
		return rst;
	}
	
	private static void findPalindrome(Set<String> rst, String str, int beg, int end) {
		while (beg >= 0 && end <= str.length() - 1 && str.charAt(beg) == str.charAt(end)) {
			if (end - beg + 1 >= 3) {
				rst.add(str.substring(beg, end + 1));
			}
			beg--;
			end++;
		}
	}
}
