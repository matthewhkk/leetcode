package done.revisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Q 684
 */

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
    	
    	int[] array = new int[edges.length+1];
    	
    	for (int i =0; i<edges.length; i++)
    	{
    		array[i] = i; 
    	}
    	
    	for (int i =0 ;i < edges.length;i++)
    	{
    		int a = edges[i][0];
    		int b = edges[i][1];
    		int a_head = find(array, a);
    		int b_head = find(array, b);
    		
    		if (a_head == b_head)
    		{
    			return edges[i];
    		}
    		else 
    		{
    			if (a_head < b_head)
    			{
    				update(array, b_head, a_head);
    			}
    			else 
    			{
    				update(array, a_head, b_head);
    			}
    			
			}
    	}
    	return null;
    	
    }
    
    public int find(int[] array, int i)
    {
    	while (array[i] != i)
    	{
    		i = array[i];
    	}
    	return i;
    }
    
    public void update(int[] array, int from ,int to)
    {
    	for (int i =0 ; i < array.length; i++)
    	{
    		if (array[i] == from )
    		{
    			array[i] = to; 
    		}
    	}
    }
    
    public static void main(String... args)
    {
//    	int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
//    	int[][] edges = new int[][]{{1,4},{3,4},{1,3},{1,2},{4,5}};
//    	int[][] edges = new int[][]{{1,6},{3,6},{2,5},{4,5},{5,6},{3,5}};
    	int[][] edges = new int[][]{{1,6},{3,6},{2,5},{4,5},{5,6},{3,7},{2,7}};
    	
    	RedundantConnection rc = new RedundantConnection();
    	int[] result = rc.findRedundantConnection(edges);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    	
    }
}
