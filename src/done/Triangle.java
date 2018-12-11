package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		
		
		if ( triangle == null || triangle.size() == 0)
		{
			return 0;
		}
		else if (triangle.size() == 1)
		{
			return triangle.get(0).get(0);
		}
		
		for (int i = 1 ; i < triangle.size() ; i++)
		{
			List<Integer> upperRow = triangle.get(i-1); 
			List<Integer> row = triangle.get(i); 
			for (int j = 0 ; j < row.size() ; j++)
			{
				int current = row.get(j);
				if (j == 0 )
				{
					row.set(j, upperRow.get(0) + current);  
				}
				else if ( j == row.size()-1)
				{
					row.set(j, upperRow.get(upperRow.size()-1) + current);
				}
				else
				{
					row.set(j, Math.min(upperRow.get(j-1), upperRow.get(j)) + current);
				}
			}
		}
		
		 
		
		List<Integer> lastRow = triangle.get(triangle.size() -1);
		
		int result = lastRow.get(0) ;
		for(int i : lastRow)
		{
			if ( i < result)
			{
				result = i;
			}
		}
		
		return result;
	}
	
	public static void main (String ... args)
	{
		List<List<Integer>> triangle = new ArrayList<>();
//		triangle.add(Arrays.asList(new Integer[] {2}));
//		triangle.add(Arrays.asList(new Integer[] {3,4}));
//		triangle.add(Arrays.asList(new Integer[] {6,5,7}));
//		triangle.add(Arrays.asList(new Integer[] {4,1,8,3}));
		
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));
		
	}
}
