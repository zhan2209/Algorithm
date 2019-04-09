/*
 * You know a password is well-ordered string. Well-ordered string means that the order of the characters is in an
 * alphabetical increasing order. Like “abEm” is a well-ordered number. However, “abmE” is not a well-order number.
 * Given an input# that tells you also how many digits are in the password, print all possible passwords.
 */
import java.util.*;

public class WellOrderedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printPassword(2));
	}

	public static List<String> printPassword(int num) {
		List<String> rst = new ArrayList<>();
		if (num <= 0)
			return rst;
		findPassword(num, rst, "", 0, 0);
		return rst;
	}

	private static void findPassword(int num, List<String> rst, String str, int curr, int diff) {
		if (str.length() == num) {
			rst.add(str.toString());
			return;
		}

		for(int i = diff; i < 26; i++) {
			// could be messed up with StringBuilder, although String has a longer runtime for insertion
			findPassword(num, rst, str + (char)('a' + i), curr + 1, diff + 1);
			findPassword(num, rst, str + (char)('A' + i), curr + 1, diff + 1);
		}

	}

}
