/*
 * You are given a telephone keyboard
 * 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separator
 * if you type "2", you will get 'A', that is "2"-'A', "22"-'B' ,"222"-'C', "2222"-'D'
 * However, the digits can repeated many times "22222"-you get 'A' again
 * You can use "#" to separate characters, for example "2#22", you get "AB". 
 * However, you may also have consecutive different digits without separator:"23"-'AD'.  
 * If you type "*", it means space.
 * You a given a sequence of digits, translate it into a text message
 */

public class SMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(translate("2#22"));
		System.out.println(translate("2#222222"));
		System.out.println(translate("23"));
		System.out.println(translate("2*22"));
		System.out.println(translate("2222"));
		System.out.println(translate("2233444"));
	}

	public static String translate(String digits) {
		if (digits == null || digits.length() == 0)
			return digits;

		String[] map = {"0","1","ABC2","DFE3","GHI4","JKL5","MNO6","PQRS7","TUV8","WXYZ9"};
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < digits.length(); i++) {
			char curr = digits.charAt(i);
			if (curr == '#')
				continue;
			if (curr == '*') {
				sb.append(' ');
			} else { // curr >= '0' && curr <= '9'
				int index = 0;
				while (i + 1 < digits.length() && digits.charAt(i + 1) == curr) {
					i++;
					index++;
				}
				String str = map[curr - '0']; // how to convert char to int
				sb.append(str.charAt(index % str.length()));
			}
		}
		
		/*
		int l = 0;
		while (l < digits.length()) {
			char curr = digits.charAt(l);
			if (curr >= '0' && curr <= '9') {				
				int r = l + 1;
				while (r < digits.length() && digits.charAt(r) == curr) {
					r++;
				}
				String str = map[curr - '0'];
				sb.append(str.charAt((r - l - 1) % str.length())); // length --> index 
				l = r;
			} else {
				if (curr == '*') {
					sb.append(' ');
				} // else '#' 
				l++;
			}
		} 
		*/

		return sb.toString();
	}
}

