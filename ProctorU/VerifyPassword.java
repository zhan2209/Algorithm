/*
 * Verify if the given password is valid/invalid
1. must be 5-12 characters long
2. must contain at least one number and one lower-case character
3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)
 */

public class VerifyPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(verifyPassword("qsqsqsqs"));
		System.out.println(verifyPassword("123123"));
		System.out.println(verifyPassword("12312qs"));
		System.out.println(verifyPassword("123123qs"));
		System.out.println(verifyPassword("123qs123"));
	}
	
	public static boolean verifyPassword(String input) {
		if (input == null || input.length() < 5 || input.length() > 12)
			return false;
		
		int l = 0;
		int countNum = Character.isDigit(input.charAt(l)) ? 1 : 0;
		int countLow = Character.isLowerCase(input.charAt(l)) ? 1 : 0;

		for (int r = 1; r < input.length(); r++) {
			if (Character.isDigit(input.charAt(r))) {
				countNum++;
			}
			if (Character.isLowerCase(input.charAt(r))) {
				countLow++;
			}
			if (input.charAt(l) == input.charAt(r)) {
				int len = r - l;
				if (r + len <= input.length()) {
					String lSub = input.substring(l, l + len);
					String rSub = input.substring(r, r + len);
					if (lSub.equals(rSub))
						return false;
				}
				l = r;
			}
		}
		
		return countNum >= 1 && countLow >= 1;
	}

}
