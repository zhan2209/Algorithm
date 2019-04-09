/*
 * If given a number find a number if it is colorful. A number is said to be colorful if all its possible unique 
 * permutations multiplication result different. 
 * Ex. If n=1234 then permutations are (1,2),(1,3),(1,4),(2,3),(2,4),(3,4),(1,2,3),(1,2,4),(2,3,4). 
 * That’s it, no other combination and if any of them repeats then number is not colorful.
 * (Find if given set of elements 2, 4, 3 form a colorful number?)
 */

import java.util.*;

public class ColorfulNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,4};
		System.out.println(canFormColorful(nums1));
		int[] nums2 = {1,2,3,2};
		System.out.println(canFormColorful(nums2));
	}

	public static boolean canFormColorful(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		Set<List<Integer>> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		if (hasDuplicate(nums, set, list, 0))
			return false;
		return true;
	}

	private static boolean hasDuplicate(int[] nums, Set<List<Integer>> set, List<Integer> list, int l) {
		boolean checkDuplicate = false;
		for (int r = l; r < nums.length; r++) {
			list.add(nums[r]);
			if (list.size() <= 1 || list.size() == nums.length)
			if (set.contains(list))
				return true;
			set.add(list);
			checkDuplicate = checkDuplicate || hasDuplicate(nums, set, list, r + 1);
			list.remove(list.size() - 1);
		}
		return checkDuplicate;
	}

}
