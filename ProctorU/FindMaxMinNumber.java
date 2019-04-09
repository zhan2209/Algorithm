/*
 * Take a series of integers as input till a zero is entered. Among these given integers, find the maximum of the 
 * odd numbers and the minimum of the even integers (not including zero) and print them.
 */

import java.util.*; // Scanner!!!

public class FindMaxMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMinMax();
	}
	
	public static void printMinMax() {
		Scanner input = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (input.hasNext()) {
			int next = input.nextInt();
			if (next == 0)
				break;
			if (next % 2 == 1) {
				max = Math.max(max, next);
			} else {
				min = Math.min(min, next);
			} 
		}
		System.out.println("The maxixmum number is: " + max);
		System.out.println("The minimum number is: " + min);
		input.close();
	}

}
