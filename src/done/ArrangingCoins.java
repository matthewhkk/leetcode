package done;

/*
 * Q 441
 */

/*
 * Note
 * First approach
 * 
 * Math :
 * return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
 * 
 * Be careful to n as n can be Integer.MAX_VALUE
 * In such case, n * 8 will be overflow
 * So, cast it to long
 * 
 * Second approach
 * 
 * Iteration :
 * List in arrangeCoins 1, but really slow
 * 
 * Third approach:
 * Binary search:
 * start with low =0 and high = n, with mid = (high + low )/ 2
 * use mid to check if mid * (mid + 1) / 2 > n
 * 
 */
public class ArrangingCoins {

	public int arrangeCoins1(int n) {

		int counter = 0;
		int sum = 0;
		while (sum + (counter + 1) <= n) {
			counter++;
			sum += counter;
		}

		return counter;
	}
	
	public int arrangeCoins(int n)
	{
		return (int) Math.floor(Math.sqrt(((double) n)/2 + (double)1/16) * 2 - 0.5);  
	}
	
	public static void main(String... args)
	{
		System.out.println(1>> 1);
	}
	
}
