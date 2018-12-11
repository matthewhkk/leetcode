package done;

import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

/**
 * Q 70
 * @author user
 *
 */
public class ClimbingStair {
	public int climbStairs(int n)
	{
		int[] list = new int[Math.max(n,2)];
		list[0] = 1;
		list[1] = 2;
		for(int i = 2; i < n; i++)
		{
			list[i] = list[i-1] + list[i-2] ; 
		}
		
		return list[n-1];
	}
	
	public static void main(String[] args)
	{
		ClimbingStair cs = new ClimbingStair();
		System.out.println(cs.climbStairs(5));
	}
}
