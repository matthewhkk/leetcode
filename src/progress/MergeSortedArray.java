package progress;

/*
 * Q88 
 */

/*
 * Note
 * Actually it should move from the end to the front
 * , in order to prevent move backward
 */
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int mi = 0;
		int ni = 0;
		int[] result = new int[m + n];
		int i = 0;
		while (mi < m && ni < n) {
			if (nums1[mi] <= nums2[ni]) {
				result[i] = nums1[mi];
				mi++;
			} else {
				result[i] = nums2[ni];
				ni++;
			}
			i++;
		}
		
		while(mi < m)
		{
			result[i] = nums1[mi];
			i++;
			mi++;
		}
		
		while(ni < n)
		{
			result[i] = nums2[ni];
			i++;
			ni++;
		}
		
		for (int j = 0 ; j < m+n ; j++){
			nums1[j] = result[j];
		}
	}
}
