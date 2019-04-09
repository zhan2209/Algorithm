/*
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999. Only four decimal places are allowed. 
 * The output should be an irreducible fraction. E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
 */

public class DecimalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(irreducibleDecimal(0.35));
		System.out.println(irreducibleDecimal(0.36));
		System.out.println(irreducibleDecimal(0.1024));
	}
	
	public static String irreducibleDecimal(double num) {
		String decimal = String.valueOf(num);
		int dominator = Integer.parseInt(decimal.substring(2));
		int denominator = (int)Math.pow(10, decimal.length() - 2);
		for (int i = 2; i <= dominator; i++) {
			while (dominator % i == 0 && denominator % i == 0) {
				dominator /= i;
				denominator /= i;
			}
		}
		return dominator + "/" + denominator;
	}
}
