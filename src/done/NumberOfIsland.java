package done;

import java.util.Deque;
import java.util.LinkedList;


/*
 * Q200
 */

/*
 * Can achieve by union join
 */

public class NumberOfIsland {

	int[][] d = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rowSize = grid.length;
		int colSize = grid[0].length;

		int result = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {

				if (grid[i][j] == '1') {
					result += bfs(grid, rowSize, colSize, i, j);
				}
			}
		}

		return result;
	}

	public int bfs(char[][] grid, int rowSize, int colSize, int x, int y) {

		Deque<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x, y));

		while (!queue.isEmpty()) {
			Pair p = queue.pop();
			int i = p.x;
			int j = p.y;

			for (int[] direction : d) {
				int row = i + direction[0];
				int col = j + direction[1];

				if (row < 0 || row >= rowSize || col < 0 || col >= colSize
						|| grid[row][col] != '1') {
					continue;
				}

				queue.offer(new Pair(row, col));
				grid[row][col] = 'x';
			}

		}

		return 1;
	}

	class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String ... args)
	{
		char[][] grid = new char[][]{{'1','0','1','0'},
								     {'0','1','1','1'},
									 {'1','0','1','0'},
									 {'0','1','0','1'}};
		
		NumberOfIsland noi = new NumberOfIsland();
		System.out.println(noi.numIslands(grid));
	}
}
