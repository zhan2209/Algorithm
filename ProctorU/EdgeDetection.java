/*
 * Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size, 
 * where W represent row and H represent column size and each cell represent pixel value of that image. You are also 
 * given a threshold X. For edge detection, you have to compute difference of a pixel value with each of its adjacent 
 * pixel and find maximum of all differences. And finally compare if that maximum difference is greater than 
 * threshold X. If so, then that pixel is an edge pixel and have to display it.
 */

public class EdgeDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] image = {
				1,1,1,1,1,
				1,9,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,};
		int width = 5;
		int [] rst = detectEdge(image, width, 2);
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < image.length / width; col++) {
				System.out.print(rst[row * width + col] + ",");
			}
			System.out.println();
		}
	}

	public static int[] detectEdge(int[] image, int width, int thresh) {
		if (image == null)
			throw new NullPointerException();
		if (width < 1 || image.length < width || image.length % width != 0)
			throw new IllegalArgumentException();
		
		int[] rst = new int[image.length];
		int numRows = image.length / width;
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < width; col++) {
				int curr = image[row * width + col];
				int xMin = col == 0 ? col : col - 1;
				int xMax = col == width - 1 ? col : col + 1;
				int yMin = row == 0 ? row : row - 1;
				int yMax = row == numRows - 1 ? row : row + 1;
				if (isEdge(image, width, xMin, xMax, yMin, yMax, curr, thresh)) 
					rst[row * width + col] = curr;
			}
		}
		return rst;
	}
	
	private static boolean isEdge(int[] image, int width, int xMin, int xMax, int yMin, int yMax, 
			int compare, int threshold) {
		// adjacent can be *EIGHT* directions
		for (int row = yMin; row <= yMax; row++) {
			for (int col = xMin; col <= xMax; col++) {
				if (Math.abs(compare - image[row * width + col]) > threshold)
					return true;
			}
		}
		return false;
	}
}
