package done;

/**
 * Q34
 * @author user
 *
 */
public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        if(nums.length != 0)
        {
        	searchInRange(nums, result, 0, nums.length-1, target);
        }
        
        if(result[0] == Integer.MAX_VALUE)
        {
        	result[0] = -1;
        	result[1] = -1;
        }
        return result;
    }
    
    private void searchInRange(int[] nums, int[] result, int start, int end, int target)
    {
    	
       	int mid = (end + start) / 2;
    	if(start >= end)
    	{
    		updateResult(nums, result, mid, target);
    		return;
    	}
 
    	if (target == nums[mid])
    	{
    		updateResult(nums, result, mid, target);
    		searchInRange(nums, result, start, mid, target);
    		searchInRange(nums, result, mid+1, end, target);
    	}
    	else if (target < nums[mid])
    	{
    		searchInRange(nums, result, start, mid, target);
    	}
    	else
    	{
    		searchInRange(nums, result, mid+1, end, target);
    	}
    }
    
    public void updateResult(int[] nums, int[] result, int mid, int target)
    {
    	if (target == nums[mid])
    	{
    		if (mid< result[0])
    		{
    			result[0] = mid;
    		}
    		
    		if (mid > result[1])
    		{
    			result[1] = mid;
    		}
    	}
    }
    
    public static void main (String[] args)
    {
    	FindFirstAndLast ffa = new FindFirstAndLast();
    	int[] nums = {1};
    	int target = 1;
    	int[] result = ffa.searchRange(nums, target);
    	System.out.println(result[0] + "," + result[1]);
    }
}
