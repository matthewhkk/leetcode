package done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
	
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> list = new ArrayList<>();

		combin(list, new LinkedList<Integer>(), n , k, 1);
		
		return list;
	}
	
	public void combin(List<List<Integer>> resultList, Deque<Integer> stack, int n, int k , int cur)
	{
		if (stack.size() == k)
		{
			resultList.add(new ArrayList<>(stack));
			return;
		}
		
		
		for (int i = cur ; i <= n ; i++)
		{
			stack.push(i);		
			combin(resultList, stack, n, k, i+1);
			stack.pop();
		}
	}
	
	public static void main(String... args)
	{
		Combinations combinations = new Combinations();
		System.out.println(combinations.combine(1, 0));
	}
	
}
