/*
 * typing finger 的题,十根手指分别对应不同字母那道题；每个手指代表几个字母,然后 input 几个手指,求所有排列
 * Related: Keypad Permutations
 */

import java.util.*;

public class TypingFinger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(typingFinger("03"));
	}
	
	// suppose we have ten fingers corresponding to 26 upper case letters
	public static List<String> typingFinger(String input) {
		List<String> rst = new ArrayList<>();
		if (input == null || input.length() == 0)
			return rst;
		String[] map = {"AB","CD","EFG","HIJ","KL","MNO","PQ","RST","UVW","XYZ"};
		dfs(input, rst, new StringBuilder(), map, 0);
		return rst;
	}
	
	private static void dfs(String input, List<String> rst, StringBuilder sb, String[] map, int curr) {
		if (curr == input.length()) {
			rst.add(sb.toString());
			return;
		}
		int finger = input.charAt(curr) - '0';
		if (finger < 0 || finger > 9)
			throw new IllegalArgumentException();
		
		for (int i = 0; i < map[finger].length(); i++) {
			sb.append(map[finger].charAt(i));
			dfs(input, rst, sb, map, curr + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
