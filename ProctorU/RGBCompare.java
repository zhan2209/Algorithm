/*
 * Given a string of RGB value (rr, gg, bb) which represents in hexadecimal. Compare if rr or gg or bb is the biggest, 
 * or two of those values are equal and larger than the third one, or three values are equal with each other.
 */

import java.util.*;

public class RGBCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compareRGB("(01, 02, 02)");
		compareRGB("(03, 02, 01)");
		compareRGB("(ff, ff, ff)");
	}

	// rgb input as "(rr, gg, bb)"
	public static void compareRGB(String rgb) {
		if (rgb == null)
			throw new NullPointerException();
		if (rgb.length() != 12)
			throw new IllegalArgumentException();
		
		int rValue = Integer.parseInt(rgb.substring(1, 3), 16);
		int gValue = Integer.parseInt(rgb.substring(5, 7), 16);
		int bValue = Integer.parseInt(rgb.substring(9, 11), 16);
		RGB rr = new RGB("R", rValue);
		RGB gg = new RGB("G", gValue);
		RGB bb = new RGB("B", bValue);
		
		List<RGB> list = new ArrayList<>();
		list.add(rr);
		list.add(gg);
		list.add(bb);
		Collections.sort(list, new rgbComparator());
		
		if (list.get(0).value == list.get(2).value) {
			System.out.println("R, G, and B are equal!");
		} else if (list.get(0).value == list.get(1).value) {
			System.out.println(helper(list.get(0).color, list.get(1).color, "smaller", list.get(2).color));
		} else if (list.get(1).value == list.get(2).value) {
			System.out.println(helper(list.get(1).color, list.get(2).color, "larger", list.get(0).color));
		} else {
			System.out.println("R, G, and B are different! " + list.get(2).color + " is the largest, "
					+ list.get(1).color + " is the second largest, and "
					+ list.get(0).color + " is the smallest!");
		}
	}
	
	private static String helper(String rgb1, String rgb2, String compare, String rgb3) {
		return rgb1 + " is equal to " + rgb2 + " , and both are " + compare + " than " + rgb3;
	}
}

class RGB {
	String color;
	int value;
	
	public RGB(String color, int value) {
		this.color = color;
		this.value = value;
	}
}

class rgbComparator implements Comparator<RGB> {
	@Override
	public int compare(RGB rgb1, RGB rgb2) {
		return rgb1.value - rgb2.value;
	}
}
