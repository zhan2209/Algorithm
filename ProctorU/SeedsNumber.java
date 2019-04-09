/*
 * Find the seed of a number.
 * Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. Find all possible seed for a given number.
 */

import java.util.*;

public class SeedsNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSeed(1716));
	}

	public static List<Integer> findSeed(int num) {
		List<Integer> rst = new ArrayList<>();
		for (int curr = 10; curr <= num; curr++) {
			if (getSeed(curr) == num)
				rst.add(curr);
		}
		return rst;
	}
	
	private static int getSeed(int curr) {
		int prod = curr;
		while (curr > 0) {
			prod *= curr % 10;
			curr /= 10;
		}
		return prod;
	}
}
