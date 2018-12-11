package done;

import java.util.HashSet;
import java.util.Set;

/**
 * Q136
 * @author user
 *
 */

/*
 * Notes :
 * - Bit manipulation
 * - a xor a = 0
 * - 0 xor b = b
 */
public class SingleNumber {

	public int singleNumber(int[] nums)
	{
		Set<Integer> resultSet = new HashSet<>();
		
		for (int i : nums)
		{
			if (resultSet.contains(i))
			{
				resultSet.remove(i);
			}
			else
			{
				resultSet.add(i);
			}
		}
		
		int result = 0;
		for (int i : resultSet)
		{
			result = i;
		}
		return result;
	}
	
	/**
	 * public class Solution {
    	public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}
	 */
}
