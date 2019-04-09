/*
 * There are 2 roommates. Each one prepares a list for grocery store. Make a combined list without any duplicates.
 * 两个排序数组去除重复输出。。。这个题很蛋疼, 描述了一堆乱七八糟的东西,读了好几遍题才明白意思
 * Cheater: given 2 sorted arrays, each of them only contains 7 elements, each element is a digit number (0-9). 
 * Combine them, remove duplicate, return a new sorted array.(不太懂为什么这道题叫 cheater)
 * 
 * 第一题是新题,考前楼主才在面经贴里看到,这里直接引用那位同学的帖子里的原话,我找不到原帖了==“大概就是有一个游戏,两个入口,每个人进入入口的 id 是
 * 自己的手机号,只能投一个入口,有些人在两个入口都投了自己的手机号.返回一个 list,包含两个如果所有的不重复的手机号,并且是排序的,输入是两个 array,
 * 没说手机号的形式,我用的是 string. 补充点细节就是这两个入口的 list 都是 sorted,所以楼主直接就把手机号当作 int 做了,就是先要删除重复的手机号,
 * 然后再 combine 在一起
 */

import java.util.*;

public class Cheater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,1,2,3,3,3,4,5,5,6};
		int[] arr2 = {1,2,2,2,2,5,6,7,7,8};
		System.out.println(Arrays.toString(combineSortedArray(arr1, arr2)));
	}

	public static int[] combineSortedArray(int[] arr1, int[] arr2) {
		// could go more in details for the null case 
		if (arr1 == null || arr2 == null)
			throw new NullPointerException();

		int[] rst = new int[arr1.length + arr2.length];
		int count = 0, index1 = 0, index2 = 0;
		while (index1 < arr1.length || index2 < arr2.length) {
			if (index1 < arr1.length && index2 < arr2.length) {
				rst[count] = Math.min(arr1[index1], arr2[index2]);				
			} else if (index1 < arr1.length) {
				rst[count] = arr1[index1];
			} else if (index2 < arr2.length){
				rst[count] = arr2[index2];
			}
			index1 = shift(arr1, index1, rst[count]);
			index2 = shift(arr2, index2, rst[count]);
			count++;
		}
		return Arrays.copyOf(rst, count);
	}

	private static int shift(int[] arr, int index, int value) {
		while (index < arr.length && arr[index] == value) {
			index++;
		}
		return index;
	}


}
