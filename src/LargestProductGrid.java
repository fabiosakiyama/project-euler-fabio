import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LaDivina
 * 
 */
public class LargestProductGrid {

	public static void main(String args[]) {

		int[][] grid = new int[20][20];
		populateGrid(grid);
		long currentProduct = 0;
		long greatestProduct = 0;

		for (int line = 0; line < 20; line++) {
			for (int column = 0; column < 20; column++) {

				// Check 3 numbers to the top
				if (enoughNumbersToTheTop(line)) {
					currentProduct = productToTheTop(grid, line, column);
					if (currentProduct > greatestProduct) {
						greatestProduct = currentProduct;
					}
				}

				// Check 3 numbers diagonally top right
				if (enoughNumbersDiagonallyToTheTopRight(line, column)) {
					currentProduct = productDiagonallyToTheTopRight(grid, line, column);
					if (currentProduct > greatestProduct) {
						greatestProduct = currentProduct;
					}
				}

				// Check 3 numbers to the right (17, 18, 19)
				if (enoughNumbersToTheRight(column)) {
					currentProduct = productToTheRight(grid, line, column);
					if (currentProduct > greatestProduct) {
						greatestProduct = currentProduct;
					}
				}

				// Check 3 numbers diagonally bottom right
				if (enoughNumbersDiagonallyToTheBottomRight(line, column)) {
					currentProduct = productDiagonallyToTheBottomRight(grid, line, column);
					if (currentProduct > greatestProduct) {
						greatestProduct = currentProduct;
					}
				}

				// Check 3 numbers to the bottom
				if (enoughNumbersToTheBottom(line)) {
					currentProduct = productToTheBottom(grid, line, column);
					if (currentProduct > greatestProduct) {
						greatestProduct = currentProduct;
					}
				}
			}
		}
		System.out.println(greatestProduct);

	}

	private static boolean enoughNumbersToTheBottom(int line) {
		return line < 17;
	}

	private static boolean enoughNumbersDiagonallyToTheBottomRight(int line, int column) {
		return line < 17 && column < 17;
	}

	private static boolean enoughNumbersDiagonallyToTheTopRight(int line, int column) {
		return line > 2 && column < 17;
	}

	private static boolean enoughNumbersToTheTop(int line) {
		return line > 2;
	}

	private static boolean enoughNumbersToTheRight(int column) {
		return column < 17;
	}

	private static long productToTheBottom(int[][] grid, int i, int j) {
		long currentProduct;
		currentProduct = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
		return currentProduct;
	}

	private static long productDiagonallyToTheBottomRight(int[][] grid, int i, int j) {
		long currentProduct;
		currentProduct = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
		return currentProduct;
	}

	private static long productDiagonallyToTheTopRight(int[][] grid, int i, int j) {
		long currentProduct;
		currentProduct = grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3];
		return currentProduct;
	}

	private static long productToTheTop(int[][] grid, int i, int j) {
		long currentProduct;
		currentProduct = grid[i][j] * grid[i - 1][j] * grid[i - 2][j] * grid[i - 3][j];
		return currentProduct;
	}

	private static long productToTheRight(int[][] grid, int i, int j) {
		long currentProduct;
		currentProduct = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
		return currentProduct;
	}

	private static void populateGrid(int[][] grid) {

		List<String> gridInLines = loadGrid();
		for (int i = 0; i < 20; i++) {
			String[] split = gridInLines.get(i).split(" ");
			for (int j = 0; j < 20; j++) {
				grid[i][j] = Integer.parseInt(split[j]);
			}
		}

	}

	private static List<String> loadGrid() {
		List<String> gridInLines = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/matriz.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				gridInLines.add(str);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		return gridInLines;
	}
}
