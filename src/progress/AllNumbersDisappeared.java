package progress;

import java.util.List;
import java.util.ArrayList;

public class AllNumbersDisappeared {
	
	public List<Integer> findDisappearedNumbers(int[] nums)
	{
		List<Integer> resultList = new ArrayList<>();
		
		if (nums == null || nums.length == 0)
		{
			return resultList;
		}
		
		for (int i : nums)
		{
			nums[Math.abs(i)-1] *= nums[Math.abs(i)-1] < 0 ? 1 : -1;
		}
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			if (nums[i] > 0)
			{
				resultList.add(i+1);
			}
		}
		
		return resultList;
	}
	
	public static void main(String... args)
	{
		AllNumbersDisappeared and = new AllNumbersDisappeared();
		System.out.println(and.findDisappearedNumbers(new int []{4,3,2,7,8,2,3,2}));
	}

}
