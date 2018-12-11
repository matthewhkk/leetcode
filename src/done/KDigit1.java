package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class KDigit1 {
	public static void main (String... args)
	{
		
		String strr = "10010012010";
		System.out.println(createMap("32351"));
		System.out.println(removeKdigits(strr, 1));
		System.out.println(removeKdigits(strr, 2));
		System.out.println(removeKdigits(strr, 3));
		System.out.println(removeKdigits(strr, 4));
		System.out.println(removeKdigits(strr, 5));
		System.out.println(removeKdigits(strr, 6));
	}
	
	public static String removeKdigits(String num, int k) 
    {

    	if (k >= num.length())
    	{
    		return "0";
    	}
    	
    	int index = 0 ; 
    	int lastIndex = -1;
    	
    	while(true)
    	{
    		index = num.indexOf('0',lastIndex + 1);
    		
    		if(index == -1)
    		{
    			break;
    		}
    		else 
    		{
    			int diff = index - (lastIndex + 1);
    			if (k >= diff)
    			{
    				k = k - diff;
    				lastIndex = index;
    			}
    			else 
    			{
    				break;
    			}
    		}
    	}

    	num = num.substring(lastIndex+1);
//    	int lastZeroIndex = num.indexOf('0');
//    	
//    	String remainingStr = lastZeroIndex == - 1 ? num : num.substring(0, lastZeroIndex);
//    	System.out.println("Remaining Str : " + remainingStr + " , k = " + k + " ");
//    	
//    	TreeMap<Integer, Integer> numMap = createMap(remainingStr);
//    	
//    	for ( int i : numMap.keySet())
//        {
//			int numOfDigit = numMap.get(i);
//			int removeIter = k >= numOfDigit ? numOfDigit : k ;
//			
//			for ( int j = 0 ; j < removeIter ; j++)
//			{
//				remainingStr = remainingStr.replaceFirst(String.valueOf(i), "");
//			}
//			
//			k = k - removeIter ; 
//			if ( k == 0 )
//			{
//				break;
//			}
//        }
//    	String result = lastZeroIndex == - 1 ? remainingStr : remainingStr + num.substring(lastZeroIndex);
//    	return result.length() == 0 ? "0": result;
    	return null;
    }
	
	public static TreeMap<Integer, Integer> createMap(String num)
    {
        TreeMap<Integer,Integer> numMap = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0 ; i < num.length() ; i++)
        {
            Integer tempInt = Integer.parseInt(String.valueOf(num.charAt(i)));
            
            if (!numMap.containsKey(tempInt))
            {
            	numMap.put(tempInt, 1);
            }
            else 
            {
            	numMap.put(tempInt, numMap.get(tempInt) + 1);
            }
           
        }
        
        return numMap;
    }
}
