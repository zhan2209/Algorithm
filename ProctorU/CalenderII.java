/*
 * Calendar II (Related)
 * 1. If Jan 1 2011 is Tuesday then what will be the name of the day for march 6 2064 and print that. 
 * 		*********getDay*********
 * 2. Find no. of days between Jan 1st and entered date
 * 		*********diffDay*********
 * 3. Write a program to generate all palindrome dates by taking the beginning and ending dates as an input from the 
 * 		user. The format of the date is given as MMDDYYYY. (Palindrome date: a date is said to be a palindrome when 
 * 		it is expressed in MMDDYYYY format, it reads the same both ways. Given 2 years as input (ex. 2000, 2010), print
 * 		out all the dates which are palindrome dates.
 * 		*********getNextDay + findPalindromeDate*********
 * 4. Given a year, print the calendar (all dates).
 * 		*********getNextDay + printCalender*********
 * 5. Convert date from mmddyy to words
 */

import java.util.*;

public class CalenderII {

	public static void main(String[] args) {
		// help to check: 
		// http://www.timeanddate.com/date/durationresult.html?m1=11&d1=20&y1=2012&m2=3&d2=20&y2=2013
		
		// TODO Auto-generated method stub
		Date date = new Date(2012, 11, 20);
		Date date1 = new Date(2012, 11, 29);
		Date date2 = new Date(2012, 12, 3);
		Date date3 = new Date(2013, 3, 20);
		Date date4 = new Date(2016, 3, 20);
		Date date5 = new Date(2016, 12, 3);
		System.out.println(diffDay(date, date1));
		System.out.println(diffDay(date, date2));
		System.out.println(diffDay(date, date3));
		System.out.println(diffDay(date, date4));
		System.out.println(diffDay(date, date5));
		System.out.println(getDay(date, date3, 2));
		System.out.println(date1.dateToString());
		date1.getNextDay();
		System.out.println(date1.dateToString());
	}

	// name the day of date2 compare to date1
	// use int to denote the weekday of date1, "0-6" ~ "Sun-Sat" 
	public static String getDay(Date date1, Date date2, int weekday) {
		int diff = 0;
		if (date2.compareTo(date1) < 0) { 
			diff = -diffDay(date2, date1); // *TRICKY* date2 is before date1
		} else {
			diff = diffDay(date1, date2);
		}

		String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		return days[(weekday + (diff % 7)) % 7]; // prevent OutOfBound
	}
	
	public static int diffDay(Date date1, Date date2) {
		int prior1 = date1.daysPriorDate(), prior2 = date2.daysPriorDate();
		int days;
		if (date1.year == date2.year) {
			days = prior2 - prior1; 
		} else {
			days = isLeapYear(date1.year) ? 366 - prior1 + prior2 : 365 - prior1 + prior2;
		}
		for (int year = date1.year + 1; year < date2.year; year++) {
			days += isLeapYear(year) ? 366 : 365;
		}
		return days;
	}
	
	public static List<Date> palindromDate(Date date1, Date date2) {
		List<Date> rst = new ArrayList<>();
		Date date = date1;
		while (date.compareTo(date2) <= 0) {
			if (isPalindrome(date)) {
				rst.add(date);
			}
			date.getNextDay();
		}
		return rst;
	}
	
	public static List<Date> printCalender(int year) {
		List<Date> list = new ArrayList<>();
		Date date = new Date(year, 1, 1);
		Date last = new Date(year, 12, 31);
		while (date.compareTo(last) <= 0) {
			list.add(date);
			date.getNextDay();
		}
		return list;
	}

	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
		
	private static boolean isPalindrome(Date date) {
		String str = date.dateToString();
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}
		return true;
	}	

}

class Date {
	int year;
	int mon;
	int day;

	public Date(int year, int mon, int day) {
		this.year = year;
		this.mon = mon;
		this.day = day;
	}
	
	public String dateToString() {
		StringBuilder sb = new StringBuilder();
		if (mon < 10) {
			sb.append("0" + mon);
		} else if (mon >= 10) {
			sb.append(mon);
		}
		if (day < 10) {
			sb.append("0" + day);
		} else if (day >= 10) {
			sb.append(day);
		}
		sb.append(year);
		return sb.toString();
	}
	
	public int daysPriorDate() {
		int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		int days = 0;
		for (int curr = 1; curr < mon; curr++) {
			days += monthDay[curr - 1];
			if (curr == 2 && isLeapYear())
				days += 1;
		}
		days += day;
		return days;
	}	
	
	public void getNextDay() {
		day++;
		if (mon == 2) {
			if (isLeapYear() && day > 29) {
				mon++;
				day -= 29;
			} else if (!isLeapYear() && day > 28) {
				mon++;
				day -= 28;
			}
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			if (day > 30) {
				mon++;
				day -= 30;
			}
		} else {
			if (day > 31) {
				mon++;
				day -= 31;
			}
		}
		
		if (mon > 12) {
			mon -= 12;
			year++;
		}
	}
	
	public boolean isLeapYear() {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	public int compareTo(Date date) {
		if (this.year != date.year)
			return this.year - date.year;
		if (this.mon != date.mon)
			return this.mon - date.mon;
		return this.day - date.day;
	}
}
