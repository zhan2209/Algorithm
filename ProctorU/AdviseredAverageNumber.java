/*
 * Write a program to display the advisered average for the list of numbers my omitting the three largest number 
 * in the series. E.g. 3,6,12,55,289,600,534,900,172. avg=(3+6+12+55+289+172)/6 and eliminating 534,900,600
 */
public class AdviseredAverageNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,6,12,55,289,600,534,900,172};
		System.out.println(avgNumber(nums));
	}
	
	public static int avgNumber(int[] nums) {
		if (nums == null || nums.length <= 3)
			return 0;
		
		int sum = nums[0] + nums[1] + nums[2];
		int max1 = Math.min(nums[0], Math.min(nums[1], nums[2]));
		int max3 = Math.max(nums[0], Math.max(nums[1], nums[2]));
		int max2 = sum - max1 - max3;
		
		for (int i = 3; i < nums.length; i++) {
			int curr = nums[i];
			sum += curr;
			if (curr <= max1)
				continue;
			if (curr > max1 && curr <= max2) {
				max1 = curr;
			} else if (curr > max2 && curr <= max3) {
				max1 = max2;
				max2 = curr;
			} else {
				max1 = max2;
				max2 = max3;
				max3 = curr;
			}
		}
		
		sum -= (max1 + max2 + max3);
		return sum / (nums.length - 3);
	}
	
}
