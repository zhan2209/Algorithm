/*
 * Additive Number
 * Problem:Additive numbers are defined to be a positive integer whose digits form an additive sequence. 
 * E.g. 11235 (1+1=2, 1+2=3, 2+3=5). What makes it difficult is that 12,122,436 is also one (12+12=24, 12+24=36). 
 * Given a range of integers, find all the additive numbers in that range.
 */

import java.util.*;

public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAdditiveNumber(1, 11236));
		System.out.println(findAdditiveNumber(1, 11236).size());
	}

	public static List<Integer> findAdditiveNumber(int start, int end) {
		List<Integer> rst = new ArrayList<>();
		if (start > end)
			return rst;
		
		
		// method 1
		for (int num1 = start; num1 < end; num1++) {
			for (int num2 = num1; num1 + num2 < end; num2++) {				
				generate(rst, num1, num2, end);
			}
		}
		
		/*
		// method 2
		for (int num = start; num <= end; num++) {
			if (isAdditive(num))
				rst.add(num);
		}
		*/
		
		return rst;
	}
	
	private static void generate(List<Integer> rst, int num1, int num2, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append(num1);
		sb.append(num2);
		int sum = num1 + num2;
		sb.append(sum);
		int total = Integer.parseInt(sb.toString());
		
		while (total <= end) {
			rst.add(total);
			num1 = num2;
			num2 = sum;
			sum = num1 + num2;
			sb.append(sum);
			total = Integer.parseInt(sb.toString());
		}
	}
	
	private static boolean isAdditive(int num) {
		if (num < 100)
			return false;
		String str = String.valueOf(num);
		for (int i = 1; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String str1 = str.substring(0, i);
				String str2 = str.substring(i, j);
				StringBuilder totalStr = new StringBuilder();
				totalStr.append(str1 + str2);
				int num1 = Integer.parseInt(str1);
				int num2 = Integer.parseInt(str2);
				
				while (totalStr.length() < str.length()) {
					int sum = num1 + num2;
					totalStr.append(String.valueOf(sum));
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
