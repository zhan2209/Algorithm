/*
 * Convert String into new string ex. ”abcD”->”cdeF” and “plxY” -> “rnzA”
 */

public class ConvertString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("abcD"));
		System.out.println(convert("plxY"));
	}
	
	public static String convert(String input) {
		if (input == null || input.length() == 0)
			return input;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			char next; 
			if (Character.isLowerCase(curr)) {
				next = (char)('a' + (curr - 'a' + 2) % 26);
			} else {
				next = (char)('A' + (curr - 'A' + 2) % 26);
			}
			sb.append(next);
		}
		return sb.toString();
	}
}
