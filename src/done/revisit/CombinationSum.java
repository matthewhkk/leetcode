package done.revisit;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/*
 * Q39
 */

/*
 * It's unnecessary for us to loop the previous number
 * if there are a solution that need to use the previous number, then this solution should be found in the previous loop
 * 
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Deque<Integer> stack = new LinkedList<>();
		
		dfs(list, stack, candidates, target, target, 0 );

		return list;
	}

	public void dfs(List<List<Integer>> list, Deque<Integer> stack, int[] candidates, int target, int remain, int start) {
		if (remain == 0) {
			list.add(new ArrayList<>(stack));
			return;
		}

		for (int j = start ; j < candidates.length ; j++) {
			int i = candidates[j];
			if (remain - i >= 0) {
				stack.push(i);
				dfs(list, stack, candidates, target, remain - i, j);
				stack.pop();
			}
		}

	}
	
	public static void main(String ... args)
	{
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(new int[]{2,3,4,5},8));
	}
}
