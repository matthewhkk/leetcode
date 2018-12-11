package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KDigit {
	
	public static void main (String... args)
	{
		
		String strr = "1222222";
		String str1 = "121";
		System.out.println(removeKDigits(strr, 4));
	}
	
	
    public static String removeKDigits(String num , int k)
    {
    	String result = "";
    	int len = num.length();
    	List<Integer> resultList = new ArrayList<>();

    	resultList.add(-1);
    	for (int i = 0 ; i < num.length(); i++)
    	{

    		int now = Integer.parseInt(String.valueOf(num.charAt(i)));
    		
    		if (k == 0 )
    		{
    			resultList.add(now);
    			continue;
    		}
    		
    		int next = 0;
    		
    		if ( i+1 == len)
    		{
    			next = -1;
    		}
    		else
    		{
    			next = Integer.parseInt(String.valueOf(num.charAt(i+1)));
    		}
    		
    		if (now > getLast(resultList) && now >next)
    		{
    			k--;
    		}
    		else if (now < getLast(resultList))
    		{
    			removeLast(resultList);
    			i--;
    			k--;
    		}
    		else 
    		{
    			resultList.add(now);
    		}
    	}
    	
    	for ( int i = 0 ; i < k ; i++)
    	{
    		removeLast(resultList);
    	}
    	
    	resultList.remove(0);
    	
    	
    	for (int i = 0 ; i < resultList.size(); i++)
    	{
    		result = result + String.valueOf(resultList.get(i));
    	}
    	
    	result = result.replaceFirst("^0+(?!$)", "");
    	return result.length() ==  0 ? "0" : result;
    }
    
    public static <E> E getLast(List<E> list)
    {
    	return list.get(list.size() - 1);
    }
    
    public static <E> void removeLast(List<E> list)
    {
    	list.remove(list.size() - 1);
    }
    
    public static TreeMap<Integer, List<Integer>> createMap(String num)
    {
        TreeMap<Integer, List<Integer>> numMap = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0 ; i < num.length() ; i++)
        {
            Integer tempInt = Integer.parseInt(String.valueOf(num.charAt(i)));
            
            if (!numMap.containsKey(tempInt))
            {
            	List<Integer> tempList = new ArrayList<>();
            	tempList.add(i);
            	numMap.put(tempInt, tempList);
            }
            else 
            {
            	numMap.get(tempInt).add(i);
            }
           
        }
        
        return numMap;
    }
}
