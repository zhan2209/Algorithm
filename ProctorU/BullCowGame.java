/*
 * There’s a word guessing game. One person think a word, and the other one guess a word, both words have the same 
 * length. The person should return the number of bulls and cows for the guessing. Bulls represent the number of same 
 * characters in the same spots, whereas cows represent the number of characters guessed right but in the wrong spots. 
 * Write a program with two input strings, return the number of bulls and cows.
 */

import java.util.*;

public class BullCowGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "dusts";
		String str2 = "studs";
		System.out.println(bullCow(str1, str2));
	}

	public static String bullCow(String expect, String guess) {
		if (expect == null || guess == null)
			throw new NullPointerException();
		if (expect.length() != guess.length())
			throw new IllegalArgumentException();
		
		int bull = 0, cow = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < expect.length(); i++) {
			char exp = expect.charAt(i);
			char gue = guess.charAt(i);
			if (exp == gue) {
				bull++;
			} else {
				if (map.containsKey(exp)) {
					map.put(exp, map.get(exp) + 1);
				} else if (!map.containsKey(exp)) {
					map.put(exp, 1);
				} 
				if (map.containsKey(gue)) {
					map.put(gue, map.get(gue) - 1);
				} else if (!map.containsKey(gue)) {
					map.put(gue, -1);
				}
			}
		}
		
		for (int value : map.values()) {
			if (value == 0)
				cow++;
		}
		return "Bulls: " + bull + ", Cows: " + cow;
	}
}
