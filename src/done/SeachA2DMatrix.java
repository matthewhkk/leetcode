package done;

public class SeachA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        if(matrix == null || matrix.length == 0)
        {
        	return false;
        }
        
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        
        if(colSize == 0)
        {
        	return false;
        }
        
        for (int i = 0 ; i < rowSize; i++)
        {
        	if (target > matrix[i][colSize-1])
        	{
        		continue;
        	}
        	return binarySearch2(matrix[i], target);
        }
        
        return false;
    }
    
    public boolean binarySearch2(int[] array, int target)
    {
    	int start = 0;
    	int end = array.length-1;
    	
    	while(start <= end)
    	{
    		int mid = (start + end)/2;
    		if (array[mid] == target)
    		{
    			return true;
    		}
    		else if (target > array[mid])
    		{
    			start = mid + 1;
    		}
    		else
    		{
    			end = mid-1;
			}
    		
    	}
    	
    	return false;
    }
    
    public boolean binarySearch(int[] array, int start, int end, int target)
    {
    	if (start >= end)
    	{
    		return false;
    	}
    	int mid = (start + end)/2;
    	
    	if (array[mid] == target )
    	{
    		return true;
    	}
    	else if (target > array[mid])
    	{
    		return binarySearch(array, mid+1, end, target);
    	}
    	else
    	{
    		return binarySearch(array, start, mid, target);
    	}
    	
    }
    
    
    
    public static void main (String ... args)
    {
    	SeachA2DMatrix sm = new SeachA2DMatrix();
//    	int[] array = {1,3,5,9,10};
//    	int target = 3;
//    	System.out.println(sm.binarySearch2(array, target));
    	
    	int[][] matrix = {{}};
    	int target = 13;
    	System.out.println(sm.searchMatrix(matrix, target));
    	
    }
}
