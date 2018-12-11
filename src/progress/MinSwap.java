package progress;

import java.util.Arrays;

public class MinSwap {

	public static void main(String ... args)
	{
		MinSwap ms = new MinSwap();
		
		int[] a = {0,7,8,10,10,11,12,13,19,18};
		int[] b = {4,4,5,7,11,14,15,16,17,20};
		
		System.out.println(ms.minSwap(a,b));
	}
	
	public int minSwap(int[] a, int [] b)
	{
		
		int counter = 0;
		
		for ( int i = 1 ; i < a.length ; i++)
		{
			if(a[i] <= a[i-1] || b[i] <= b[i-1])
			{
				swap(i, a, b);
				counter++;
			}
		}
		
		return counter;
	}
	
	public void swap(int index , int a[] , int b[])
	{
		int temp = a[index];
		b[index] = a[index];
		a[index] = temp;
	}
}
