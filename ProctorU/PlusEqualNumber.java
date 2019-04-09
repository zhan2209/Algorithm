/*
 * Given a number find whether the digits in the number can be used to form an equation with + and '='. That is if 
 * the number is 123, we can have an equation of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
 */

public class PlusEqualNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		formEquation(123);
		formEquation(17512);
	}
	
	public static void formEquation(int num) {
		if (num < 100)
			throw new IllegalArgumentException();
		
		boolean form = false;
		String numStr = String.valueOf(num);
		for (int i = 1; i < numStr.length(); i++) {
			for (int j = i + 1; j < numStr.length(); j++) {
					int num1 = Integer.parseInt(numStr.substring(0, i));
					int num2 = Integer.parseInt(numStr.substring(i, j));
					int num3 = Integer.parseInt(numStr.substring(j));
					// only insert "+" and "=" *BUT* cannot change the order 
					if (num1 + num2 == num3) {
						form = true;
						System.out.println(num1 + "+" + num2 + "=" + num3);
					} else if (num2 + num3 == num1) {
						form = true;
						System.out.println(num2 + "+" + num3 + "=" + num1);
					}
			}
		}
		if (!form) {
			System.out.println("This number cannot form an equation!");
		}
	}

}
