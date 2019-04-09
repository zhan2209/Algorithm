/*
 * Write, efficient code for extracting unique elements from a sorted list of array. 
 * e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
 */

import java.util.*;

public class UniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9};
		System.out.println(uniqueNumber(num));
	}
	
	public static List<Integer> uniqueNumber(int[] arr) {
		List<Integer> rst = new ArrayList<>();
		if (arr == null || arr.length == 0)
			return rst;
		
		for (int i = 0; i < arr.length - 1; i++) {
			rst.add(arr[i]);
			while (i + 1 < arr.length && arr[i + 1] == arr[i]) 
				i++;
		}
		if (arr.length > 1 && arr[arr.length - 1] != arr[arr.length - 2]) {
			rst.add(arr[arr.length - 1]);
		}
		return rst;
	}

}
