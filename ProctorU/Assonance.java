/*
 * 新题:Assonance。大意是把一个 String 里所有元音开头的单词放到一起,其他单词顺序不变。比如输入时"my apple has another enough work 
 * soccer engineer",输出就是"my apple another has enough engineer work soccer",把所有 a 开头的放到第一个 a 开头的后面,e/i/o/u
 * 也一样,其他单词按照原先后顺序排列。简单的一点是默认输入只有字母和空格,split 一下很容易地。
 */

import java.util.*;

public class Assonance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(assonance("my apple has another enough work soccer engineer"));
	}
	
	public static String assonance(String input) {
		if (input == null || input.length() == 0)
			return input;
		
		ArrayList[] vowelList = new ArrayList[5]; // or HashMap
		for (int i = 0; i < vowelList.length; i++) {
			vowelList[i] = new ArrayList<>();
		}
		
		String[] words = input.split(" ");
		for (String s : words) {
			char first = Character.toLowerCase(s.charAt(0));
			if (isVowel(first)) {
				vowelList[first - 'a'].add(s);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			char first = Character.toLowerCase(word.charAt(0));
			if (!isVowel(first)) {
				sb.append(word + " ");
			} else {
				List<String> list = vowelList[first - 'a'];
				if (!list.isEmpty()) {
					for (String s : list) {
						sb.append(s + " ");
					}
					list.clear();
				}
			}
		}
		return sb.toString().trim();
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
