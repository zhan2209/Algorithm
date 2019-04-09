/*
 * There is one kind of numbers call Fibbonaci Number, which satisfy the following situation: 
 * A. can be spilt into several numbers;
 * B. The first two numbers are the same, the next number is equal to the sum of previous two 
 * eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
 * If you are given a range by the user, find all numbers that are Fibbonaci numbers.
 */

import java.util.*;

public class FibbonaciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(fibbonaci(1,12122437));
		System.out.println(isFibbonaci(1125));
	}

	public static List<Integer> fibbonaci(int start, int end) {
		List<Integer> rst = new ArrayList<>();
		if (start > end)
			return rst;
		for (int num = start; num <= end; num++) {
			if (isFibbonaci(num))
				rst.add(num);
		}
		return rst;
	}

	private static boolean isFibbonaci(int num) {
		if (num < 100)
			return false;
		String str = String.valueOf(num);
		for (int i = 1; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String str1 = str.substring(0, i);
				String str2 = str.substring(i, j);
				if (!str1.equals(str2))
					continue;

				StringBuilder totalStr = new StringBuilder();
				totalStr.append(str1 + str2);
				int num1 = Integer.parseInt(str1);
				int num2 = Integer.parseInt(str2);

				while (totalStr.length() < str.length()) {
					int sum = num1 + num2;
					totalStr.append(sum);
					num1 = num2;
					num2 = sum;
				}
				if (totalStr.toString().equals(str))
					return true;
			}
		}
		return false;
	}
}
