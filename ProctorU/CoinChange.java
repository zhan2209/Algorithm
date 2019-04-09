/*
 * Something cost $10.25 and the customer pays with a $20 bill, the program will print out the most efficient 
 * "change-breakdown" which is 1 five, 4 ones, and 3 quarters. Find the minimum number of coins required to make 
 * change for a given sum (given unlimited number of N different denominations coin)
 */

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinChange(20, 10.25));
	}

	public static List<String> coinChange(double bill, double cost) {
		List<String> rst = new ArrayList<>();
		double[] coins = {50, 20, 10, 5, 1, 0.25, 0.1, 0.05, 0.01};
		double exchange = bill - cost;

		for (double value : coins) {
			if (exchange >= value) {
				int count = (int)(exchange / value);
				rst.add(count + " counts of " + value);
				exchange -= count * value;
			}
		}
		return rst;
	}

}
