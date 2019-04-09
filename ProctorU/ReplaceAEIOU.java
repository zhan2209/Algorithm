/*
 * Replace a,e,i,o,u with A,E,I,O,U. 
 * At most four eligible letters from the rear of the string are replaced.
 * The first three eligible letters in the string are always exempted from replacement.
 */

public class ReplaceAEIOU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceVowel("a"));
		System.out.println(replaceVowel("aeio"));
		System.out.println(replaceVowel("ajleijksfou"));
		System.out.println(replaceVowel("ajleijkiaesfou"));
	}
	
	public static String replaceVowel(String str) {
		if (str == null || str.length() < 4)
			return str;
		
		char[] arr = str.toCharArray(); // will need extra O(n) memory anyway
		StringBuilder sb = new StringBuilder();
		int left = 0, count = 0;
		for (; left < str.length() && count < 3; left++) {
			if (isVowel(arr[left]))
				count++;
		}
		
		count = 0;
		for (int right = str.length() - 1; right >= left && count < 4; right--) {
			if (isVowel(arr[right])) {
				arr[right] = (char)(arr[right] + 'A' - 'a');
				count++;
			}
		}
		
		for (char c : arr) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
