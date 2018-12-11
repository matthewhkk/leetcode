package done;

public class LongestIncreasingNumber {

	int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int rowSize = matrix.length;
		int colSize = matrix[0].length;

		int[][] lengthMatrix = new int[rowSize][colSize];
		boolean[][] visited = new boolean[rowSize][colSize];

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				lengthMatrix[i][j] = 1;
			}
		}

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (visited[i][j]) {
					continue;
				}

				visited[i][j] = true;
				int length = dfs(matrix, lengthMatrix, visited, i, j, rowSize,
						colSize);
				if (length > max) {
					max = length;
				}
			}
		}
		return max;
	}

	public int dfs(int[][] matrix, int[][] lengthMatrix, boolean[][] visited,
			int row, int col, int rowSize, int colSize) {
		int max = 0;
		for (int[] d : direction) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];

			if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize || matrix[row][col] <= matrix[nextRow][nextCol]) {
				continue;
			}
			int nextLength = 0;
			if (visited[nextRow][nextCol]) {
				nextLength = lengthMatrix[nextRow][nextCol];
			} else {
				visited[nextRow][nextCol] = true;
				nextLength = dfs(matrix, lengthMatrix, visited, nextRow, nextCol, rowSize, colSize);
			}

			if (nextLength > max) {
				max = nextLength;
			}
		}
		lengthMatrix[row][col] += max;

		return lengthMatrix[row][col];
	}

	public static void main(String... args) {
		int[][] matrix = new int[][] { { 7, 6, 3 },
									   { 8, 11, 2 },
									   { 9, 10, 1 } };

		LongestIncreasingNumber lin = new LongestIncreasingNumber();
		System.out.println(lin.longestIncreasingPath(matrix));

	}
}
