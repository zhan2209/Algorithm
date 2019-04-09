/*
 * Write a program to add the substring. eg :say you have a list {1 7 6 3 5 8 9} and user is entering a sum 16. 
 * Output should display (2-4) that is {7 6 3} cause 7+6+3=16.
 */

import java.util.*;

public class SubstringAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1,7,6,3,5,8,9};
		System.out.println(subarraySum(num1, 16));
		System.out.println(subarraySum(num1, 20));
		System.out.println(subarraySum(num1, 8));
		System.out.println(subarraySum(num1, 1));
		System.out.println(subarraySum(num1, 9));
	}

	public static List<String> subarraySum(int[] nums, int target) {
		List<String> rst = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return rst;
		int l = 0, sum = 0;
		for (int r = 0; r < nums.length; r++) { // keep shift right
			sum += nums[r];
			if (sum == target) {
				addRange(rst, l, r);
			} else {
				while (l < r && sum > target) {
					sum -= nums[l++]; // only shift left when exceed
					if (sum == target) { // tricky: remember to check
						addRange(rst, l, r);
					}
				}
			}
		}
		return rst;
	}

	private static void addRange(List<String> rst, int l, int r) {
		if (l == r) {
			rst.add("" + (l + 1));
		} else {
			rst.add((l + 1) + "-" + (r + 1));
		}
	}

}
