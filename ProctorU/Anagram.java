/*
 * *Anagram
 * Enumerate all possible anagrams of a random string where capital letters, numbers, and symbols are not allowed to 
 * move within the string.
 * 1.大写字母不能变小写 2.大写字母或者其他字符位置不变 3.不能有数字 0-9. 4. 根据小写字符输出 anagrams.
 * Ex. Input: tree
 * Output: tree, rett, rete, reet, etre, eetr, eert, eter, eret, teer, reet...
 * 
 * Given a password in number: write an algorithm to print all possible combinations of that password. 
 * Hint: try from to go from all possible combinations of lower bound to the valid upper bounds.
 */

import java.util.*;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAllAnagrams("*g2ee~ee3J"));
	}
	
	public static Set<String> findAllAnagrams(String str) {
		Set<String> rst = new HashSet<>(); // in case of duplicate char
		if (str == null || str.length() == 0)
			return rst;

		// I didn't find better way to exempt digits
		// Indeed, we need an Array/ArrayList to help swap anyway
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				continue;
			list.add(str.charAt(i));
		}
		
		rst.add(list.toString());
		for (int l = 0; l < list.size(); l++) {
			if (!Character.isLowerCase(list.get(l)))
				continue;
			for (int r = l + 1; r < list.size(); r++) {
				if ((Character.isLowerCase(list.get(r)))) {
					swap(list, l, r);
					rst.add(list.toString());
					swap(list, l, r);
				}
			}
		}
		return rst;
	}

	private static void swap(List<Character> list, int l, int r) {
		char c = list.get(l);
		list.set(l, list.get(r));
		list.set(r, c);
	}

}
