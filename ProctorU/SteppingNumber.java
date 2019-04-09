/*
 * A number is called as a stepping number if the adjacent digits are having a difference of 1. 
 * eg. 8,343,545 are stepping numbers. While 890, 098 are not. The difference between a ‘9’ and ‘0’ should not be 
 * considered as 1. Given start number(s) and an end number (e) your function should list out all the stepping numbers 
 * in the range including both the numbers s & e.
 */

import java.util.*;

public class SteppingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> rst = findSteppingNumber(1, 1101);
		System.out.println(rst.size());
		System.out.println(rst);
	}
	
	public static List<Integer> findSteppingNumber(int start, int end) {
		List<Integer> rst = new ArrayList<>();
		if (start > end)
			return rst;
		String s = String.valueOf(start);
		String e = String.valueOf(end);
		for (int len = s.length(); len <= e.length(); len++) {
			for (int curr = 1; curr <= 9; curr++) {
				helper(rst, start, end, len - 1, curr); // "curr" has taken "1"
			}
		}
		return rst;
	}
	
	private static void helper(List<Integer> rst, int start, int end, int len, int curr) {
		if (len == 0) {
			if (curr >= start && curr <= end) 
				rst.add(curr);
			return;
		}
		int last = curr % 10;
		if (last == 0) {
			helper(rst, start, end, len - 1, curr * 10 + 1);
		} else if (last == 9) {
			helper(rst, start, end, len - 1, curr * 10 + 8);
		} else {
			helper(rst, start, end, len - 1, curr * 10 + last - 1);
			helper(rst, start, end, len - 1, curr * 10 + last + 1);
		}
	}
}
