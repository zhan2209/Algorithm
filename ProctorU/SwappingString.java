/*
 * Given two strings, you need to transpose the first string to the second string by means of only swaps between 2 
 * consecutive characters in the first string. This must be performed by doing a series of these swaps in order to 
 * get the second string.
 */

import java.util.*;

public class SwappingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swappingString("abc", "cab");
		swappingString("abc", "acc");
		swappingString("abc", "abb");
	}
	
	public static void swappingString(String s1, String s2) {
		if (s1 == null || s2 == null)
			throw new NullPointerException();
		if (s1.length() != s2.length())
			throw new IllegalArgumentException();
		
		char[] ch1 = s1.toCharArray();
		List<String> step = new ArrayList<>();
		
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] == s2.charAt(i))
				continue;
			
			int j = i + 1;
			for (; j < ch1.length; j++) {
				if (ch1[j] == s2.charAt(i)) {
					break;
				} else if (j == ch1.length - 1) {
					System.out.println("Two strings are not anagrams and cannot be transposed!");
					return;
				}
			}
			
			for (int curr = j; curr > i; curr--) { // can only swap *CONSECUTIVE*
				char tmp = ch1[curr];
				ch1[curr] = ch1[curr - 1];
				ch1[curr - 1] = tmp;
				step.add(String.valueOf(ch1));
			}
		}
		System.out.println("String1 has been trasposed to String2 with the following steps:");
		System.out.println(step);
	}

}
