package done;

import java.util.stream.IntStream;

public class UniqueDigits {

	public static void main(String... args) 
	{
		UniqueDigits ud = new UniqueDigits();
		System.out.println(ud.countNumbersWithUniqueDigits(3));
		
//		System.out.println(ud.ncr(4,2));
//		System.out.println(ud.ncr(5,3));
//		System.out.println(ud.ncr(5,4));
//	
		
//		System.out.println(ud.factorial(5-3));
//		System.out.println(ud.factorial(5));
//		System.out.println(ud.factorial(4));
		
//		System.out.println(ud.zigma(2,5));
//		System.out.println(ud.zigma(2,4));
//		System.out.println(ud.zigma(3,6));
	}

//	public int countNumbersWithUniqueDigits(int n) 
//	{
//		if (n == 0)
//		{
//			return 1;
//		}
//		else if ( n > 10 )
//		{
//			return 0;
//		}
//		
//		int[] dp1 = new int[10];
//		int[] dp2 = new int[10];
//		
//		dp1[0] = 1;
//		dp2[0] = 9;
//		
//		int result = 0 ;
//		for (int i = 1; i < n ; i++)
//		{
//			dp1[i] = dp1[i-1]*(10-i);
//			dp2[i] = dp2[i-1]*(10-i-1);
//		}
//		
//
//		for (int i = 0; i < n ; i++)
//		{
//			result += dp1[i] + dp2[i];
//		}
//
//		return result;
//	}
	
	
	// this is actually not correct as it count leading zero as a new number
	public int countNumbersWithUniqueDigits(int n) 
	{
		if (n == 0)
		{
			return 1;
		}
		else if ( n > 10 )
		{
			return 0;
		}
		
		int[] dp1 = new int[11];
		
		dp1[0] = 1;
		dp1[1] = 10;
		dp1[2] = 81;
		
		int result = 0 ;
		for (int i = 3; i <= n ; i++)
		{
			dp1[i] = dp1[i-1] * ( 11 - i);
		}
		

		for (int i = 1; i <= n ; i++)
		{
			result += dp1[i];
		}

		return result;
	}
//	
	
//	public int countNumbersWithUniqueDigits(int n) 
//	{
//		if (n == 0)
//		{
//			return 1;
//		}
//		else if (n == 10)
//		{
//			return 9 * factorial(10);
//		}
//		else if (n > 10)
//		{
//			return 0;
//		}
//
//		
//		int partialResult = 1 ; 
//		
//		for (int i = n-1 , j = 0; i > 1 ; i--, j++)
//		{
//			partialResult +=  ncr(n,i) * zigma(9, 9-j);
//		}
//		
//		partialResult = partialResult * 10;
//		return (int) (Math.pow(10,n) - partialResult);
//	}
//	
//	public int factorial(int n)
//	{
//		return zigma(1,n);
//	}
//	
//	public int zigma(int from , int end)
//	{
//		return IntStream.rangeClosed(from,end).reduce(1, (x,y) -> x*y);
//	}
//	
//	public int ncr(int n, int r)
//	{
//		return zigma(r+1, n) / factorial(n-r);
//	}
}
