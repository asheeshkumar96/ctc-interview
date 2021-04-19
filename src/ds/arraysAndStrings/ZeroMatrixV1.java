package ds.arraysAndStrings;

/**
 * Write an algorithm such that if an element in an NxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrixV1 {
	
	private static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		// store the row and column index with value 0
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		// nullify rows
		for(int i = 0; i < row.length; i++) {
			if(row[i]) nullifyRow(matrix, i);
		}
		
		// nullify columns
		for(int j = 0; j < column.length; j++) {
			if(column[j]) nullifyColumn(matrix, j);
		}
	}
	
	private static void nullifyRow(int[][] matrix, int row) {
		for(int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	private static void nullifyColumn(int[][] matrix, int col) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
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
		int[][] matrix = new int[][] {
			new int[] { 5, 8, 1 },
			new int[] { 2, 0, 2 },
			new int[] { 3, 3, 5 }
		};
		System.out.println("Zero Matrix before making rows and columns zeroes");
		printMatrix(matrix);
		setZeros(matrix);
		System.out.println("After setting zeroes");
		printMatrix(matrix);
	}
}
