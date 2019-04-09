/*
 * Reduction:
 * 输入 一个 numeric string,逐步去除里面重复的数字,直至做到没有重复为止. Ex: 1000034435 -> 1335 -> 15
 * 第一道是给一个 String, 要求写个函数消掉 String 中连续重复的字符。要求最终的 String 里不能有连续相同的字符。
 * 比如 abbac, 先消掉 bb,再消掉 aa,最后应该返回 c
 */

import java.util.*;

public class Reduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduction("1000034435"));
	}

	public static String reduction(String input) {
		if (input == null || input.length() <= 1)
			return input;

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < input.length()) {
			char curr = input.charAt(i);
			if (stack.isEmpty()) {
				stack.push(curr);
				i++;
			} else {
				if (stack.peek() == curr) {
					stack.pop();
					while (i < input.length() && input.charAt(i) == curr) {
						i++;
					}
				} else {
					stack.push(curr);
					i++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

}
