package done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Q 128
 * @author user
 *
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		Map<Integer, Integer> resultMap = new HashMap<>();

		for (int i : nums) {
			resultMap.put(i, i);
		}

		for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
			int key = entry.getKey();
			if (resultMap.containsKey(key + 1)) {
				resultMap.put(key, resultMap.get(key + 1));
			}
		}

		int result = 0;
		Set<Integer> visitedSet = new HashSet<>();

		for (int key : resultMap.keySet()) {
			if (!visitedSet.contains(key)) {
				int tempKey = key;
				int value = resultMap.get(tempKey);
				visitedSet.add(tempKey);
				while (tempKey != value) {
					tempKey = value;
					value = resultMap.get(tempKey);
					visitedSet.add(tempKey);
				}

				int size = tempKey - key + 1;
				if (size > result) {
					result = size;
				}
			}
		}
		return result;
	}

//	Nice idea, use set to keep track of which had visit
//	
//	public int longestConsecutive(int[] num) {
//	    int res = 0;
//	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//	    for (int n : num) {
//	        if (!map.containsKey(n)) {
//	            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
//	            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
//	            // sum: length of the sequence n is in
//	            int sum = left + right + 1;
//	            map.put(n, sum);
//	            
//	            // keep track of the max length 
//	            res = Math.max(res, sum);
//	            
//	            // extend the length to the boundary(s)
//	            // of the sequence
//	            // will do nothing if n has no neighbors
//	            map.put(n - left, sum);
//	            map.put(n + right, sum);
//	        }
//	        else {
//	            // duplicates
//	            continue;
//	        }
//	    }
//	    return res;
//	}

	public static void main(String... args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(new int[] { 100, 4, 101, 1,3, 2 }));
		System.out.println(lcs.longestConsecutive(new int[] { 7, 3, 5, 6, 4, 8 }));
		System.out.println(lcs.longestConsecutive(new int[] { 1}));
		System.out.println(lcs.longestConsecutive(new int[] {}));
	}
}
