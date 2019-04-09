/*
 * Get a date (mon/day/year) from user. Print exact the week of dates (Sun to Sat). 
 * ex -- 	input: 2/20/2001 if the day is Wednesday
 *			output: Sunday 2/17/2001
					Monday 2/18/2001
					Tuesday 2/19/2001
					Wednesday 2/20/2001
					Thursday 2/21/2001
					Friday 2/22/2001
					Saturday 2/23/2002
 */

import java.util.*; 

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printWeek("1/29/2001", 3));
		System.out.println(printWeek("2/29/2001", 3));
		System.out.println(printWeek("4/29/2001", 3));
		System.out.println(printWeek("12/29/2001", 3));
	}

	public static List<String> printWeek(String date, int weekday) {
		List<String> rst = new ArrayList<>();
		String[] mdy = date.split("/");
		int mon = Integer.parseInt(mdy[0]);
		int day = Integer.parseInt(mdy[1]);
		int year = Integer.parseInt(mdy[2]);
		String[] week = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturaday"};

		for (int i = 0; i < 7; i++) {
			String currDay = getDate(mon, day, year, week, i, i - weekday);
			rst.add(currDay);
		}
		return rst;
	}

	private static String getDate(int mon, int day, int year, String[] week, int curr, int diff) {
		StringBuilder sb = new StringBuilder();
		sb.append(week[curr] + " ");
		day += diff;
		// need to deal with diff > 0 AND diff < 0
		// need to categorize by *MONTH* at first
		if (mon == 2) {
			if (day > 28 && !isLeapYear(year)) {
				day -= 28;
				mon++;
			}else if (day > 29 && isLeapYear(year)) {
				day -= 29;
				mon++;
			} 
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			if (day > 30) {
				day -= 30;
				mon++;
			}
		} else {
			if (day > 31) {
				day -= 31;
				mon++;
			}
		}
		if (mon > 12) {
			year++;
			mon -= 12;
		}

		sb.append(mon + "/" + day + "/" + year);
		return sb.toString();
	}

	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

}
