package runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Runner {

	/**
	 * This method fills the matrix of specified size with random numbers
	 * @param n – number of columns
	 * @param m – number of rows
	 * @return randomMatrix
	 */
	private static int[][] createRandomMatrix(int n, int m) {
		int[][] randomMatrix = new int [n][m];

	    Random rand = new Random(); 
	    for (int i = 0; i < n; i++) {     
	        for (int j = 0; j < m; j++) {
	            Integer r = rand.nextInt() % 100; 
	            randomMatrix[i][j] = Math.abs(r);
	        }
	    }
	    return randomMatrix;
	}

	/**
	 * this method rotates specified matrix on 90 degrees clockwise
	 * @param mtrx
	 * @return rotated
	 */
	private static int[][] rotateMatrixClockwise(int[][] mtrx) {
		int a = mtrx.length;
	    int b = mtrx[0].length;
	    int[][] rotated = new int[b][a];
	    for (int i = 0; i < b; ++i) {
	        for (int j = 0; j < a; ++j) {
	            rotated[i][j] = mtrx[a - j - 1][i];
	        }
	    }
	    return rotated;
	}
	
	/**
	 * this method rotates specified matrix on 90 degrees counterclockwise
	 * @param mtrx
	 * @return rotated
	 */
	private static int[][] rotateMatrixCounterclockwise(int[][] mtrx) {
		int a = mtrx.length;
	    int b = mtrx[0].length;
	    int[][] rotated = new int[b][a];
	    for (int i = 0; i < b; ++i) {
	        for (int j = 0; j < a; ++j) {
	            rotated[i][j] = mtrx[j][b - i - 1];
	        }
	    }
	    return rotated;
	}
	
	/**
	 * Prints ready matrix
	 * @param matrix
	 */
	public static void printMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length;j++) {
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	/**
	 * Read user's input numbers from console 
	 * @return
	 * @throws IOException
	 */
	private static int readNumbers() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int i = 0;
		
		s = br.readLine();
		try{
            i = Integer.parseInt(s);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            System.exit(1);
        }
		if (i <= 0) {
			System.err.println("Number must be greater than zero");
			System.out.println("Exit(1)");
			System.exit(1);
		}
		return i;
	}
	

	public static void main(String[] args) throws IOException {
		
		int rows = 0;
		int columns = 0;
		
		System.out.println("This is an app to rotate matrix on 90 degrees clockwise");
		
		System.out.println("Please input number of rows:\t");
		rows = readNumbers();
		
		System.out.println("Please input number of columns:\t");
		columns = readNumbers();
		
		int[][] initial = createRandomMatrix(rows, columns);
		
		System.out.println("Original matrix:");
		printMatrix(initial);
		System.out.println();

		
		int[][] rotated = rotateMatrixClockwise(initial);
		System.out.println("The matrix rotated clockwise");
		printMatrix(rotated);

		System.out.println();
		
		rotated = rotateMatrixCounterclockwise(initial);
		System.out.println("The matrix rotated counterclockwise");
		printMatrix(rotated);
	}
}
