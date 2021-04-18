package ds.arraysAndStrings;

/* rotates using transpose and horizontal fliping */
public class RotateMatrixPractice {

	private static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		
		// transpose of matrix
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// reversing every row
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0;  j <= matrix.length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
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
