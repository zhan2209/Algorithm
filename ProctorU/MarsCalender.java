/*
 * 火星上一年有 12 个月,除了二月,其他月份都是 31 天。二月在 leap year 的时候是 30 天,不是 leap year 的时候是 29 天。leap year 的判断标准
 * 是年数可以被 4 整除,但是如果年数能被200 整除,但不能被 1000 整除的年不是 leap year,比如 1400 不是 leap year,但 2000 是 leap year。
 * 现在给定一个日期(mm/dd/yyyy),判断该日期是否合法,然后给出在这个日期以后的下一个leap day,即 02/30/xx。
 * 12 个月,每月都是 30 天, 只有 Leap year 的 2 月份是 31 天。给你一个 date, 输出下一个Leap day. 有个特殊的星球一年 12 个月,每月 30 天,
 * 闰年 2 月 31 天,闰年的条件是能除尽 200,但是不能除尽 400 的,除非能同时除尽 1000。问题是输入字符串“MM/DD/YYYY”判断是否 valid 
 */

public class MarsCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1 = new Date(1000, 2, 29);
		Date date2 = new Date(1001, 2, 29);
		Date date3 = new Date(1000, 2, 30);
		Date date4 = new Date(1001, 3, 30);
		
		Date next1 = nextLeapDay(date1);
		Date next2 = nextLeapDay(date2);
		Date next3 = nextLeapDay(date3);
		Date next4 = nextLeapDay(date4);
		
		System.out.println(next1.year + "/" + next1.mon + "/" + next1.day);
		System.out.println(next2.year + "/" + next2.mon + "/" + next2.day);
		System.out.println(next3.year + "/" + next3.mon + "/" + next3.day);
		System.out.println(next4.year + "/" + next4.mon + "/" + next4.day);
		
		System.out.println(isLeapYear(1204));
		System.out.println(isLeapYear(1200));
	}
	
	public static Date nextLeapDay(Date input) {
		if (input == null)
			throw new NullPointerException();
		if (!valid(input))
			throw new IllegalArgumentException();
		
		int year = input.year;
		if (isLeapYear(year)) {
			if (input.mon == 1 || (input.mon == 2 && input.day < 30)) 
				return new Date(year, 2, 30);
			year++;
		}
		while (!isLeapYear(year)) {
			year++;
		}
		return new Date(year, 2, 30);
	}
	
	private static boolean valid(Date date) {
		if (date.mon != 2) 
			return date.day >= 1 && date.day <= 31;
		return isLeapYear(date.year) ? 
				(date.day >= 1 && date.day <= 30) : (date.day >= 1 && date.day <= 29);
	}
	
	private static boolean isLeapYear(int year) {
		if (year % 4 != 0)
			return false;
		if (year % 200 == 0 && year % 1000 != 0)
			return false;
		return true;
	}

	static class Date {
		int year;
		int mon;
		int day;
		
		public Date(int year, int mon, int day) {
			this.year = year;
			this.mon = mon;
			this.day = day;
		}
	}
}



