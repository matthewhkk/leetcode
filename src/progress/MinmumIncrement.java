package progress;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Q945
 */

public class MinmumIncrement {
    public int minIncrementForUnique(int[] A) 
    {
    	int[] array = new int[40001];
    	
    	for (int i : A){
    		array[i]++;
    	}
    	
    	Deque<Integer> stack = new LinkedList<>();
    	int sum = 0;
    	for (int i = 0 ;i < array.length; i++)
    	{
    		if (array[i] == 0 && !stack.isEmpty())
    		{
    			sum += i - stack.pop();
    		}
    		if (array[i] > 1)
    		{
    			for (int j = array[i]; j > 1 ; j--)
    			{
    				stack.push(i);
    			}
    		}
    	}
    	
    	int largest = 40001;
    	while(!stack.isEmpty())
    	{
    		sum += largest -stack.pop();
    		largest++;
    	}
    	
    	return sum;
    }
    
    public static void main(String... args)
    {
    	MinmumIncrement mi = new MinmumIncrement();
    	System.out.println(mi.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    	System.out.println(mi.minIncrementForUnique(new int[]{40000,39999,40000,39999}));
    }
}
