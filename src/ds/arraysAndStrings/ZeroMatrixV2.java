package ds.arraysAndStrings;

public class ZeroMatrixV2 {
	
	// elegent solution
	private static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
		// check if first row has a zero
		for(int j = 0; j < matrix[0].length; j++)  {
			if(matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		// check if first column has a zero
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				columnHasZero = true;
				break;
			}
		}
		
		// check for zeroes in the rest of the array
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix.length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// nullify rows based on values in first column
		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
		// nullify columns based on values in first row
		for(int j = 1; j < matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		// nullify first row
		if(rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		// nullify first column
		if(columnHasZero) {
			nullifyColumn(matrix, 0);
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
			new int[] { 0, 8, 1 },
			new int[] { 2, 7, 2 },
			new int[] { 3, 3, 5 }
		};
		System.out.println("Zero Matrix before making rows and columns zeroes");
		printMatrix(matrix);
		setZeros(matrix);
		System.out.println("After setting zeroes");
		printMatrix(matrix);
	}
}
