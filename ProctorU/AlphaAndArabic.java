/*
 * 每个字母对应一个数字。输入一串字母, 当出现某个字母比后面那个小, 则前面的运算要变成减法再与后面的相加
 * ex. CAB: -14 -1+ 4 = -11 CBA: 14+4+1 = 16
 * 计算一串字母的值, 给一个值表 A-1 B-13 C-110 。。。然后计算给定串的值, 右边串有大于当前的就算负数,大于就算正数 
 * ex. CBA 110+13+1 = 124 ABC -1-13+110=96
 */

public class AlphaAndArabic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNum("C"));
		System.out.println(getNum("A"));
		System.out.println(getNum("B"));
		System.out.println(getNum("CAB"));
		System.out.println(getNum("CBA"));
	}
	
	// suppose each Character has value of its Integer value
	public static int getNum(String input) {
		if (input == null)
			throw new NullPointerException();
		if (input.length() == 0)
			throw new IllegalArgumentException();
		
		int sum = (int)input.charAt(0);
		for (int i = 1; i < input.length(); i++) { // compare with previous
			char curr = input.charAt(i);
			if (curr >= input.charAt(i - 1)) {
				sum = -sum;
			} 
			sum += (int)curr;
		}
		return sum;
	}

}
