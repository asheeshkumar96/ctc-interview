package ds.arraysAndStrings;

/**
 * Given an image represented by NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image 
 * by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
	
	// official
	private static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		
		for(int layer = 0; layer <  n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i]; // save top
				
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				// bottom -> left 
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom 
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		
		return true;
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix= new int[][] {
								new int[] {1, 2, 3},
								new int[] {4, 5, 6},
								new int[] {7, 8, 9},
							};
		System.out.println("Before rotation");
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("After rotation");
		printMatrix(matrix);
	}
}
