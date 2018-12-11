package done;

/**
 * Q11
 * @author user
 *
 */
public class ConatinerWithMostWater {
    public int maxArea(int[] height) {
    	int maxArea = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high)
        {
        	int area = Math.min(height[low], height[high]) * (high - low);
        	if (area > maxArea)
        	{
        		maxArea = area;
        	}
        	if (height[low] <= height[high])
        	{
        		low++;
        	}
        	else
        	{
        		high--;
        	}
        }
    	
    	return maxArea;
    }
}
