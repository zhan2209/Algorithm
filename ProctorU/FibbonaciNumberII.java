/*
 * Given start and end integer as user input, generate all integers with the following property.
 * Example:
 * 123, 1+2=3, valid number
 * 121224, 12+12=24, valid number
 * 1235 1+2=3, 2+3=5, valid
 * 125 1+2<5, invalid
 */

public class FibbonaciNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("123"));
		System.out.println(isValid("121224"));
		System.out.println(isValid("1235"));
		System.out.println(isValid("125"));
	}
	
	public static boolean isValid(String num) {
		if (num == null || num.length() < 3)
			return false;
		for (int i = 1; i < num.length(); i++) {
			for (int j = i + 1; j < num.length(); j++) {
				String str1 = num.substring(0, i);
				String str2 = num.substring(i, j);
				StringBuilder sb = new StringBuilder();
				sb.append(str1 + str2);
				int num1 = Integer.parseInt(str1);
				int num2 = Integer.parseInt(str2);
				
				while (sb.length() < num.length()) {
					int sum = num1 + num2;
					sb.append(sum);
					num1 = num2;
					num2 = sum;					
				}
				if (sb.toString().equals(num))
					return true;
			}
		}
		return false;
	}

}
