package timeout;

import java.util.HashSet;
import java.util.Set;

public class CountPrime {
    public int countPrimes(int n) {
        if ( n <= 2)
        {
        	return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(2);
        int result = 1;
        for ( int i = 3; i < n ; i += 2)
        {
        	boolean isPrime = true;
        	for (int inSet : set)
        	{
        		if (i%inSet == 0)
        		{
        			isPrime = false;
        			break;
        		}
        	}
        	
        	if(isPrime)
    		{
    			result++;
    			set.add(i);
    		}
        }
        return result;
        
    }
    
    public static void main(String... args)
    {
    	CountPrime cPrime = new CountPrime();
    	System.out.println(cPrime.countPrimes(499979));
    }
}
