/*
 * Suppose you want to do the subtraction of two numbers. Each digit of the numbers is divided and put in an array. 
 * Like A=[1, 2, 3, 4, 5], B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].Remember that your machine can’t 
 * hand numbers larger than 20.
 */

public class SubtractionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,3,4,5};
		int[] arr2 = {4,5,3,5};
		int rst = getNum(subtraction(arr1, arr2));		
		System.out.println(rst);
	}
	
	public static int[] subtraction(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null) 
			return null;
		if (arr1.length < arr2.length)
			return subtraction(arr2, arr1);	
		
		int [] rst = new int[arr1.length];
		int diff = 0; 
		int idx = arr1.length - 1;
		
		while (idx >= arr1.length - arr2.length) {
			int num1 = arr1[idx], num2 = arr2[idx - (arr1.length - arr2.length)];
			if (num1 + diff >= num2) {
				rst[idx--] = num1 + diff - num2;
				diff = 0;
			} else {
				rst[idx--] = num1 + diff + 10 - num2;
				diff = -1;
			}
		}
		
		if (idx < 0 && diff < 0) {
			System.out.print("-");
			return subtraction(arr2, arr1);
		}
		if (idx < 0)
			return rst;
		
		rst[idx] = diff == 0 ? arr1[idx] : arr1[idx] - 1;
		while (--idx >= 0) {
			rst[idx] = arr1[idx];
		}
		return rst;
	}
	
	private static int getNum(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = num * 10 + nums[i];
		}
		return num;
	}

}
