/*
 * Common character, 把一个 string 里面的最高频的字符和最低频的字符互换
 */

import java.util.*;

public class CommonCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(changeFrequency("AaCbBb"));
	}
	
	// suppose the most/least frequency only has *ONE* char
	// if we have both Upper and Lower Case, we only replace U by L if they are most/least frequent
	public static String changeFrequency(String input) {
		if (input == null || input.length() == 0)
			return input;
		
		Map<Character, Integer> map = new HashMap<>();	
		String tmp = input.toLowerCase();
		for (int i = 0; i < tmp.length(); i++) {
			char curr = tmp.charAt(i);
			if (map.containsKey(curr)) {
				map.put(curr, map.get(curr) + 1);
			} else {
				map.put(curr, 1);
			}
		}
		
		char most = ' ', least = ' ';
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (Character c : map.keySet()) {
			if (map.get(c) < min) {
				min = map.get(c);
				least = c;
			}
			if (map.get(c) > max) {
				max = map.get(c);
				most = c;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char curr = tmp.charAt(i);
			if (curr == least) {
				sb.append(most);
			} else if (curr == most) {
				sb.append(least);
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}

}
