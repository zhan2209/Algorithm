/*
 * First, let user input a number, say 1. Then, the function will generate the next 10 numbers, which satisfy 
 * this condition: 1, 11,21,1211,111221,312211... explanation: first number 1; second number is one 1, so 11; 
 * third number is two1(previous number), so 21. next number one 2 one 1, so 1211 and so on...
 */

import java.util.*;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay("2"));
	}

	public static List<String> countAndSay(String start) {
		List<String> rst = new ArrayList<>();
		if (start == null || start.length() == 0)
			return rst;
		
		for (int i = 1; i <= 10; i++) {
			rst.add(start);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < start.length(); j++) {
				int count = 1; // important "start value"
				while (j + 1 < start.length() && start.charAt(j) == start.charAt(j + 1)) {
					count++;
					j++;
				}
				sb.append("" + count + start.charAt(j));
			}
			start = sb.toString();
		}
		return rst;
	}
}
