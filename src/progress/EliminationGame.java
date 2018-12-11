package progress;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class EliminationGame {
	
	/*
	 * First approach , too slow
	 */
	public int lastRemaining(int n) {
		if ( n == 1)
		{
			return 1;
		}
		
		Deque<Integer> stackA = new LinkedList<>();
		Deque<Integer> stackB = new LinkedList<>();

		for (int i = 2; i <= n; i = i + 2) {
			stackA.push(i);
		}

		if(stackA.size() == 1)
		{
			return stackA.pop();
		}
		while (true) {
			while (!stackA.isEmpty()) {
				stackA.pop();
				if (!stackA.isEmpty()) {
					stackB.push(stackA.pop());
				}
			}
			if (stackB.size() > 1) {
				Deque<Integer> temp = stackA;
				stackA = stackB;
				stackB = temp;
			} else {
				return stackB.pop();
			}
		}

	}
	
	
	public static void main(String... args)
	{
		EliminationGame eg = new EliminationGame();
		System.out.println(eg.lastRemaining(10000000));
//		IntStream.range(1, 100).forEach(i -> System.out.println(eg.lastRemaining(i)));
		
		
		
	}

}
