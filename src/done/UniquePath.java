package done;

public class UniquePath {
    public int uniquePaths(int m, int n) {
    	if(m == 0 || n == 0)
    	{
    		return 0;
    	}
    	
    	int[][] grid = new int[m][n];
        for (int i = 0 ; i < m ; i++)
        {
        	for (int j = 0 ; j < n ; j++)
        	{
        		if(i== 0 || j==0)
        		{
        			grid[i][j] = 1;
        		}
        		else
        		{
        			grid[i][j]= grid[i-1][j] + grid[i][j-1];  
				}
        	}
        }
        return grid[m-1][n-1];
    }
    
    public static void main (String[] args)
    {
    	UniquePath up = new UniquePath();
    	System.out.println(up.uniquePaths(3, 2));
    	System.out.println(up.uniquePaths(7, 3));
    	System.out.println(up.uniquePaths(0, 0));
    	System.out.println(up.uniquePaths(1, 2));
    }
}
