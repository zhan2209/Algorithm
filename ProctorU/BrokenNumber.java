/*
 * 得到两个数,把第一个数拆成两个数,两个数和跟第二个数的差最小的给打印出来。但是两个数的和必须小于第二个数。
 * Ex. 第一个数是 10958 第二个数是 1000,10 + 958 = 968 这个就可以,但是 1095 + 8 = 1103 就不可以了
 */

import java.util.*;

public class BrokenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(brokenWays(10958, 1000));
	}

	public static List<List<Integer>> brokenWays(int num1, int num2) {
		List<List<Integer>> rst = new ArrayList<>();
		String num = String.valueOf(num1);
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i) == '0')
				continue; // second number *SHOULDN'T* start with 0
			int left = Integer.parseInt(num.substring(0, i));
			int right = Integer.parseInt(num.substring(i));
			if (left + right < num2) {
				List<Integer> list = new ArrayList<>();
				list.add(left);
				list.add(right);
				rst.add(list);
			}
		}
		return rst;
	}
}
