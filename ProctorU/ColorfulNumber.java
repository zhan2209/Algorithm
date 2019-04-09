/*
 * A number can be broken into different sub-sequence parts. Suppose a number 3245 can be broken into parts like 
 * 3 2 4 5 32 24 45 324 245. And this number is a colorful number, since product of every digit of a sub-sequence 
 * are different. That is,3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. But 326 is not a colorful number 
 * as it generates 3 2 6 (3*2)=6 (2*6)=12. You have to write a function that tells if the given number is a colorful.
 */

import java.util.*;

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(colorfulNumber(232));
		System.out.println(colorfulNumber(233));
		System.out.println(colorfulNumber(235));
		System.out.println(colorfulNumber(236));
	}
	
	public static boolean colorfulNumber(int num) {
		if (num < 10)
			return true;
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		while (num != 0) {
			int digit = num % 10;
			if (set.contains(digit))
				return false;
			set.add(digit);
			list.add(digit); // can convert to String as well
			num /= 10;
		}
		
		for (int i = 0; i < list.size(); i++) {
			int prod = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				prod *= list.get(j);
				if (set.contains(prod))
					return false;
				set.add(prod);
			}
		}
		return true;
	}

}
