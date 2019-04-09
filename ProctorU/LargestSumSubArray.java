/*
 * Find the largest sum contiguous sub array. The length of the returned sub array must be at least of length 2.
 */

import java.util.*;

public class LargestSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maximumSubarray(nums));
	}
	
	public static List<Integer> maximumSubarray(int[] nums) {
		List<Integer> rst = new ArrayList<>();
		if (nums == null || nums.length <= 1)
			return rst;
		
		int maxEndHere = nums[0];
		int maxTotal = nums[0];
		List<Integer> tmp = new ArrayList<>();
		tmp.add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (maxEndHere + nums[i] < nums[i]) { // same ending; new start or not?
				tmp.clear();
			}
			tmp.add(nums[i]);
			maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
			
			if (maxEndHere > maxTotal) {
				maxTotal = maxEndHere;
				rst = new ArrayList<>(tmp);
			}
		}
		return rst.size() >= 2 ? rst : new ArrayList<Integer>();
	}
	
/*
	public static int[] maximumSubarray(int[] nums) {
		int[] rst = new int[2];
		if (nums == null || nums.length == 0)
			return rst;
		
		int maxSum = 0;
		for (int l = 0; l < nums.length; l++) {
			int sum = nums[l];
			for (int r = l + 1; r < nums.length; r++) {
				sum += nums[r];
				if (sum > maxSum) {
					maxSum = sum;
					rst[0] = l;
					rst[1] = r;
				}
			}
		}
		return rst[1] - rst[0] <= 1 ? new int[2] : rst;
	}
*/
}
