package done;

import java.io.PushbackInputStream;
import java.util.Deque;
import java.util.LinkedList;




import org.junit.Assert;
import org.junit.Test;

/*
 * Q921
 */


public class MinimumAddToMakeParentheses {
	public int minAddToMakeValid(String s)
	{
		if (s.length() == 0)
		{
			return 0;
		}
		
		Deque<Character> stack = new LinkedList<>();
		stack.push(s.charAt(0));
		
		for (int i = 1; i < s.length() ; i++)
		{
			char newest = s.charAt(i);
			
			if (stack.size() == 0 || stack.peek() == ')' || newest == '(')
			{
				stack.push(newest);
			}
			else
			{
				stack.pop();
			}
		}
		return stack.size();
	}
	
	public static void main(String... args)
	{
		MinimumAddToMakeParentheses mamp = new MinimumAddToMakeParentheses();
		System.out.println(mamp.minAddToMakeValid("())"));
		System.out.println(mamp.minAddToMakeValid("((("));
		System.out.println(mamp.minAddToMakeValid("()"));
		System.out.println(mamp.minAddToMakeValid("()))(("));
	}
	
}
