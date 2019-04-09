/*
 * In 1-9 keypad one key is not working. If someone enters a password then not working key will not be entered. You 
 * have given expected password and entered password. Check that entered password is valid or not. Ex: entered 164, 
 * expected 18684 (you need to take care as when u enter 18684 and 164 only both will be taken as 164 input)
 */

// invalid could be: input contains different types/counts of char from expected

import java.util.*;

public class ValidPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validPassword("164","18684"));
		System.out.println(validPassword("164","128684"));
		System.out.println(validPassword("1164","18684"));
		System.out.println(validPassword("1643","18684"));
	}
	
	// use Set to count and jump the not working key
	public static boolean validPassword(String input, String expected) {
		if (input == null)
			return expected == null;
		if (input.length() == 0)
			return expected.length() == 0;
		if (input.length() > expected.length())
			return false;
		
		int curr1 = 0, curr2 = 0;
		Set<Character> set = new HashSet<>();
		while (curr1 < input.length() && curr2 < expected.length()) {
			if (input.charAt(curr1) == expected.charAt(curr2)) {
				curr1++;
				curr2++;
			} else {
				if (set.contains(expected.charAt(curr2))) {
					curr2++;
				} else {
					if (!set.isEmpty())
						return false;
					set.add(expected.charAt(curr2));
				}
			}
		}
		return curr1 == input.length();
	}

	/*
	// use Map taking counts
	public static boolean validPassword(String input, String expected) {
		if (input == null)
			return expected == null;
		if (input.length() == 0)
			return expected.length() == 0;
		if (input.length() > expected.length())
			return false;			
			
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < expected.length(); i++) {
			char curr = expected.charAt(i);
			if (map.containsKey(curr)) {
				map.put(curr, map.get(curr) + 1);
			} else {
				map.put(curr, 1);
			}
		}
		
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			if (!map.containsKey(curr)) // expected doesn't have this, or input have extra counts
				return false;
			map.put(curr, map.get(curr) - 1);
			if (map.get(curr) == 0) { 
				map.remove(curr); 
			}
		}
		
		return map.size() <= 1;
	}
	 */
}
