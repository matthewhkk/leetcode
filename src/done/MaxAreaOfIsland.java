package done;

public class MaxAreaOfIsland {

	int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rowSize = grid.length;
		int colSize = grid[0].length;

		int max = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = 0;
					max = Math.max(dfs(grid, rowSize, colSize, i, j), max);
				}
			}
		}

		return max;
	}

	public int dfs(int[][] grid, int rowSize, int colSize, int x, int y) {
		int result = 1;
		for (int[] d : direction) {
			int row = x + d[0];
			int col = y + d[1];

			if (row < 0 || row >= rowSize || col < 0 || col >= colSize || grid[row][col] != 1) {
				continue;
			}

			grid[row][col] = 0;
			result += dfs(grid, rowSize, colSize, row, col);
		}

		return result;
	}

	public static void main(String... args) {
		MaxAreaOfIsland mai = new MaxAreaOfIsland();
		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		int[][] grid1 = new int[][] {{1,0},{0,1}};
		System.out.println(mai.maxAreaOfIsland(grid1));
	}
}
