package done;

import java.util.Arrays;

public class Permutation {
	
	public void permutation(String[] strList, int start, int end)
	{
		if (start == end)
		{
			printArray(strList);
			return;
		}
		
		for (int i = start; i < end ; i++)
		{
			swap(strList, start, i);
			permutation(strList, start+1, end);
			swap(strList,  start,  i);
		}
	}
	
	public void swap(String[] strList, int pos1, int pos2)
	{
		String tempString = strList[pos1];
		strList[pos1] = strList[pos2];
		strList[pos2] = tempString; 
	}

	public static void main(String[] argsStrings)
	{
		Permutation permutation = new Permutation();
		String[] strList = {"1","2","3","4"};
		permutation.permutation(strList, 0, strList.length);
	}
	
	public void printArray(String[] list)
	{
		Arrays.asList(list).stream().forEach(System.out::print);
		System.out.println();
	}
}
