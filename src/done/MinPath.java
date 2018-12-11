package done;

/**
 * Q64
 * @author user
 *
 */
public class MinPath {

    public int minPathSum(int[][] grid) {
    	if(grid.length == 0)
    	{
    		return 0;
    	}
    	
    	int rowSize = grid.length;
    	int colSize = grid[0].length;
    	
    	for (int i = 0; i < rowSize ; i++)
    	{
    		for (int j = 0; j < colSize; j++)
    		{
    			if( i == 0 && j == 0)
    			{
    				continue;
    			}
    			
    			int up = i-1 < 0 ? Integer.MAX_VALUE : grid[i-1][j];
    			int left = j-1 < 0 ? Integer.MAX_VALUE : grid[i][j-1];
    			grid[i][j] = Math.min(up, left) + grid[i][j]; 
    		}
    	}
     
    	return grid[rowSize-1][colSize-1];
    }
    
/*
 * ref solution
 *     
 *  int m = grid.length, n = grid[0].length;
    for(int i = 0; i < m; i++){
    	for(int j = 0; j < n; j++){
    	if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
    	if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
    	if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    	}
    }
    return grid[m-1][n-1];
*/    
    public static void main (String... args)
    {
    	int[][] test = {{1,3,1},
    					{1,5,1},
    					{4,2,1}};
    	MinPath mp = new MinPath();
    	System.out.println(mp.minPathSum(test));
    }
}
