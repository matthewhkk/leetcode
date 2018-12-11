package fail_revisit;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/*
 * Q417
 */

/*
 * Note
 */
public class PacificAtlanticWaterFlow {
	public List<int []> pacificAtlantic(int[][] matrix)
	{
		List<int []> resultList = new ArrayList<>();
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return resultList;
		}
		
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		boolean[][] flowMatrix = new boolean[matrix.length][matrix[0].length];
		boolean[][] visitiedMatrix = new boolean[matrix.length][matrix[0].length];
		Deque<Coord> stack = new LinkedList<>();
		
		for (int i = 0; i <rowSize ; i++)
		{
			flowMatrix[i][0] = true;
			visitiedMatrix[i][0] = true;
		}
		
		for (int j = 0; j <colSize ; j++)
		{
			flowMatrix[0][j] = true;
			visitiedMatrix[0][j] = true;
		}
		
		stack.push(new Coord(1, 1));
		for (int i = 1 ; i < rowSize; i++)
		{
			for (int j = 1; j < colSize ;j++)
			{
				while(!stack.isEmpty())
				{
					Coord coord = stack.pop();
					int ci = coord.i;
					int cj = coord.j;
					visitiedMatrix[ci][cj]= true;
					
					if (ci - 1 > 0 && !visitiedMatrix[ci-1][cj])
					{
						stack.push(new Coord(ci-1,cj));
					}
					if (ci + 1 < rowSize - 1 && !visitiedMatrix[ci+1][cj])
					{
						stack.push(new Coord(ci+1,cj));
					}
					if (cj - 1 > 0 && !visitiedMatrix[ci][cj-1])
					{
						stack.push(new Coord(ci,cj-1));
					}
					if (cj + 1 < colSize - 1 && !visitiedMatrix[ci][cj+1])
					{
						stack.push(new Coord(ci,cj+1));
					}
					
				}
				
				if (visitiedMatrix[i][j])
				{
					continue;
				}
				
				
			}
		}
		
		return resultList;
	}
	
	class Coord
	{
		int i;
		int j;
		
		Coord (int i , int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
