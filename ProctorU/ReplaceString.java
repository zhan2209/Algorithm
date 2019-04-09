/*
 * From a given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
 * Example Input: " A boy is playing in a garden  "
 * Example Output: " ONE boy is playing in one garden  "
 * -- Not that 'A' and 'a' are to be replaced only when they are single characters, not as part of another word.
 */

public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceString("A boy is playing in a garden"));
	}
	
	public static String replaceString(String str) {
		if (str == null || str.length() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		String[] split = str.split(" ");
		for (String s : split) {
			if (s.equals("a")) {
				sb.append("one");
			} else if (s.equals("A")) {
				sb.append("ONE");
			} else {
				sb.append(s);
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
