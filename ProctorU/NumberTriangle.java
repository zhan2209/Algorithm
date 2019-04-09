/*
 * Given an array {{4,7,3,6,7}}
 * Construct a triangle like
			   {{81}}
			 {{40, 41}}
		   {{21, 19, 22}}
		  {{11, 10, 9, 13}}
		{{4 , 7 , 3 , 6 , 7}}
 * 给定一组数 ex. 5,6,23,45, 返回:
 * 			5 , 6 , 23 , 45
 *  		 11 , 29 , 68
 *    		   40 , 97
 *      		 137
 */

import java.util.*;

public class NumberTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(6);
		list.add(23);
		list.add(45);
		System.out.println(numberTriangle(list));
	}
	
	public static List<List<Integer>> numberTriangle(List<Integer> input) {
		List<List<Integer>> rst = new ArrayList<>();
		if (input == null || input.size() == 0)
			return rst;
		rst.add(input);
		while (input.size() > 1) {
			List<Integer> curr = new ArrayList<>();
			for (int i = 0; i < input.size() - 1; i++) {
				curr.add(input.get(i) + input.get(i + 1));
			}
			rst.add(curr);
			input = curr;
		}
		return rst;
	}

}
