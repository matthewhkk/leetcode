package done;

public class MinCostClimbChair {
    public int minCostClimbingStairs(int[] cost) {
        int[] totalCost = new int[cost.length];
        totalCost[0] = cost[0];
        totalCost[1] = cost[1];
        
        for (int i = 2; i < cost.length; i++)
        {
        	totalCost[i]= Math.min(totalCost[i-1], totalCost[i-2]) + cost[i]; 
        }
        
        return Math.min(totalCost[cost.length-1], totalCost[cost.length-2]);
    }
    
/*
 * This is reference, updating inplace    
 * public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
*/
    
    public static void main (String... args)
    {
    	MinCostClimbChair mcc = new MinCostClimbChair();
    	int[] cost = {1,100,1,1,1,100,1,1,100,1};
    	System.out.println(mcc.minCostClimbingStairs(cost));
    }
}
