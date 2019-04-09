/*
 * AEIOU (Gibberize String)
 * Taking string as an input from user. After taking, consider a,A,e,E,i,I,o,O,u,U, if these letters appear in the 
 * string... then replace them with a^, A^ ,e^ ,E^ ,i^ ,I^ ,o^ ,O^ ,u^ ,U^. Leave the first three eligible letters 
 * from the starting of the string.
 */

public class AEIOU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertVowel("My name is Amy. I like orange."));
	}
	
	public static String convertVowel(String input) {
		if (input == null || input.length() <= 3)
			return input;
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			sb.append(curr);
			if (isVowel(Character.toLowerCase(curr))) {
				count++;
				if (count > 3)
					sb.append('^');
			}
		}
		return sb.toString();
	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
}
