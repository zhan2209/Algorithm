/*
 * 你有三种篮子能装, 6,9,20。 给你一个数 N, 找出所有正好装完 N 的组合
 */

import java.util.*;

public class FillBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fillBasket(128));
	}
	
	public static Set<List<String>> fillBasket(int total) {
		Set<List<String>> rst = new HashSet<>();
		if (total < 6)
			return rst;
		dfs(total, rst, 0, 0, 0);
		return rst;
	}
	
	private static void dfs(int total, Set<List<String>> rst, int count1, int count2, int count3) {
		if (total < 0)
			return;
		if (total == 0) {
			List<String> list = new ArrayList<>();
			list.add(count1 + " basket 6");
			list.add(count2 + " basket 9");
			list.add(count3 + " basket 20");
			rst.add(list);
		}
		dfs(total - 6, rst, count1 + 1, count2, count3);
		dfs(total - 9, rst, count1, count2 + 1, count3);
		dfs(total - 20, rst, count1, count2, count3 + 1);
	}

}
