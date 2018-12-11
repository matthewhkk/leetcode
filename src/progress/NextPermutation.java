package progress;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums)
	{
		int lastIndex = nums.length -1;
		
		int i = 0;
		int j = lastIndex;
		
		int last = nums[lastIndex];
		for (int k = lastIndex - 1;k >= 0; k--)
		{
			if (nums[k] < last)
			{
				i = k+1;
				j = lastIndex - 1;
				
				while( i < j)
				{
					swap(nums, i++, j--);
				}
				
				while (lastIndex > k)
				{
					nums[lastIndex] = nums[--lastIndex];
				}
				nums[k]= last; 
				return;
			}
			else if (nums[k]> last )
			{
				continue;
			}
			
		}

		while ( i < j)
		{
			swap(nums, i++, j--);
		}
	}
	
	public void swap(int[] nums , int a, int b)
	{
		int temp = nums[a];
		nums[a]= nums[b];
		nums[b] = temp; 
	}

	public static void main(String... args)
	{
		NextPermutation nPermutation = new NextPermutation();
		int[] nums = {1,2,5,4,4,3};
		nPermutation.nextPermutation(nums);
		Arrays.stream(nums).forEach(System.out::println);
	}
}
