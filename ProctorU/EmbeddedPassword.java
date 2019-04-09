/* 
 * Embedded Password:给一个 string 都是 字母, 选出 符合条件的 字母串;
 * 		a. 每次读 N, 2N, 3N, 4N ..... 位置上的字母, 直到 N^2;
 * 		b. 每个符合条件的字母 at least 3 元音字母. 如果 odd length, 中间那个必需是元音; 
 * 		c. 如果 even length , 中间 2 个必需是 same 元音, 而且同时 uppercase or lowercase. 
 * 		d. 每个字符串 first, last 必需 uppercase
 * 
 * 从一个 String 里面取出 index 为 1N,2N,3N ... N*N 的字符组成密码.有几个限制条件:第一个和最后一个字母是大写;至少三个 vowel,不区分大小写;
 * 如果组成的密码是 odd,中间那个字母必须为 vowel, 如果是偶数,中间两个为 vowel。最后打印出符合条件的字符串。 
 * 例如: zzzAEzzazPzazziWzzzCzzzzAzz, if N=4, 输出为 AaaW, N=5, 输出为 EPICA)
 * 
 * 以前没见过但是不难。给一串,按照特定的规则从里面取出字符组成字符串,规则是:index 为 N, 1N, 2N, .... N*N (N 从 4 开始)的字符取出组成字符串,
 * 组成的这个字符串还需要符合一定的规则:1. 第一个和最后一个字符是大写字母。 2。最少要有 3 个元音字母,不分大小写。3 如果所组成字符串长度是奇数,那么
 * 中间那个字母必须是元音。4. 如果长度是偶数,中间两个必须是相同的元音。如果满足上述条件打印出来。输出打印在所给字符串中所有符合条件的组成的字符串。
 * 例如:zzzAEzzazPzazzIWzzzCzzzzAzz, N 可以等于 4 (AaaW)也可以等于5(EPICA), 但是不能等于 6 了,因为字符串没有 6*6 那么长
 */

import java.util.*;

public class EmbeddedPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(embeddedPassword("zzzAEzzazPzazzIWzzzCzzzzAzz")); // should check *SUBSTRING*
	}

	public static List<String> embeddedPassword(String input) {
		List<String> rst = new ArrayList<>();
		if (input == null || input.length() < 3)
			return rst;
		
		for (int n = 1; n * n < input.length(); n++) { //每次读 N, 2N, 3N, 4N ... 位置上的字母, 直到 N^2
			StringBuilder sb = new StringBuilder();
			int countVowel = 0;
			for (int i = n - 1; i < input.length(); i += n) {
				char curr = input.charAt(i);
				sb.append(curr);
				if (isVowel(Character.toLowerCase(curr)))
					countVowel++;
				if (countVowel >= 3) { // at least 3 元音字母
					checkString(rst, sb.toString(), sb.length());					
				}
			}
		}
		return rst;
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	private static void checkString(List<String> rst, String str, int strLen) {
		char first = str.charAt(0), last = str.charAt(strLen - 1);
		if (!Character.isUpperCase(first) || !Character.isUpperCase(last))
			return; // 每个字符串 first, last 必需 uppercase
		if (strLen % 2 == 1) {
			char middle = str.charAt(strLen / 2);
			if (!isVowel(Character.toLowerCase(middle)))
				return; // 如果 odd strLength, 中间那个必需是元音
		} else {
			char midL = str.charAt(strLen / 2 - 1);
			char midR = str.charAt(strLen / 2);
			if (!isVowel(Character.toLowerCase(midL)) || !isVowel(Character.toLowerCase(midR)))
				return; // 如果 even strLength , 中间 2 个必需是 same 元音
			if (Character.isLowerCase(midL) != Character.isLowerCase(midR))
				return; // 而且同时 uppercase or lowercase
		}
		rst.add(str.toString());
	}
}
