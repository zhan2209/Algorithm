/*
 * Print continuous alphabets from a sequence of arbitrary alphabets. For example:
 * Input: abcdefljdflsjflmnopflsjflasjftuvwxyz
 * Output: abcdef; lmnop; tuvwxyz
 * Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz
 * Output: abcdef; lmnop; tuvwxyz
 */

import java.util.*;

public class ContinuousAlphabets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(continuousAlphabets("abcdefljdflsjflmnopflsjflasjftuvwxyz"));
		System.out.println(continuousAlphabets("AbcDefljdflsjflmnopflsjflasjftuvWxYz"));
	}
	
	public static List<String> continuousAlphabets(String str) {
		List<String> rst = new ArrayList<>();
		if (str == null || str.length() == 0)
			return rst;
		str = str.toLowerCase();
		for (int l = 0; l + 1< str.length(); l++) {
			if (str.charAt(l + 1) != str.charAt(l) + 1)
				continue;
			int r = l;
			while (r + 1 < str.length() && str.charAt(r + 1) == str.charAt(r) + 1) {
				r++;
			}
			rst.add(str.substring(l, r + 1));
			l = r + 1;
		}
		return rst;
	}

}
