/*
 * We are given a specific time(like 02:23), we need to get the angle between hour and minute(less than 180)
 */

public class ClockAngle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(angle(2, 23));
	}
	
	public static double angle(int hh, int mm) {
		double hhAngle = (hh % 12) * (360 / 12) + mm * ((360 / 12) / 60);
		double mmAngle = mm * (360 / 60);
		double angle = Math.abs(hhAngle - mmAngle);
		return angle < 180 ? angle : 360 - angle;
	}

}
