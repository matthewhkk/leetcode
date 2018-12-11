package done;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Thief {
    public Integer[] robList(int[] nums) {
    	int numOfHouse = nums.length;
    	Integer[] result = new Integer[numOfHouse];
    	
    	if (numOfHouse == 0)
    	{
    		return result;
    	}

    	
    	result[0] = nums[0];
    	
    	if (numOfHouse < 2)
    	{
    		return result;
    	}
        result[1] = Math.max(nums[0], nums[1]);
        
        if (numOfHouse < 3)
    	{
    		return result;
    	}
        result[2] = Math.max(nums[0] + nums[2], nums[1]);
        
        
        		
        for (int i = 3 ; i < numOfHouse ; i++)
        {
        	result[i] = nums[i] + Math.max(result[i-2], result[i-3]);
        }
        
        return result;
    }
    
    public int rob (int[] nums)
    {
    	if (nums.length == 0 )
    	{
    		return 0;
    	}
    	Integer[] result = robList(nums);
    	List<Integer> list = Arrays.asList(result);
    	return Collections.max(list);
    }
    
    public static void main (String ... args)
    {
    	Thief t = new Thief();
    	int[] test = {2};
    	System.out.println(t.rob(test));
    
    }
}
