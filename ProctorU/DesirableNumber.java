/*
 * A number is called 'desirable' if all the digits are strictly ascending eg: 159 as 1<5<9. You know that your rival 
 * has a strictly numeric password that is 'desirable'. Your close ally has given you the number of digits (N) in your 
 * rival's password. Write code that takes in'N' as input and prints out all possible 'desirable' numbers that can be 
 * formed with N digits.
 */
import java.util.*;

public class DesirableNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDesirableNumber(3));
	}
	
	public static List<String> findDesirableNumber(int n) {
		List<String> rst = new ArrayList<>();
		if (n <= 0)
			return rst;
		helper(n, rst, new StringBuilder(), 0);
		return rst;
	}
	
	private static void helper(int n, List<String> rst, StringBuilder sb, int digit) {
		if (sb.length() == n) {
			rst.add(sb.toString());
			return;
		}
		for (int i = digit; i <= 9; i++) {
			sb.append(i);
			helper(n, rst, sb, i + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
