package done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Q456
 */



/*
 * Similar idea, but much simple by observing the stored class behavior
 * In side the stack, the range should be decresing i.e. a[i].min > a[j].max , for i < j 
 * so if the newest value is larger than all the previous max, that's means the newest range can cover all the previous
 *  
 * class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){ 
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
                
            }
        }
        return false;
    }
 * 
 */

public class OneThreeTwoPattern {

	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}

		List<MinMax> list = new ArrayList<>();
		MinMax smm = new MinMax(nums[0]);
		list.add(smm);

		for (int i = 1; i < nums.length; i++) {
			smm = list.get(list.size() - 1);

			if (nums[i] < smm.min) {
				list.add(new MinMax(nums[i]));
			} else if (nums[i] > smm.max) {
				smm.max = nums[i];
			}

			for (int j = list.size() - 1; j >= 0; j--) {
				smm = list.get(j);

				if (nums[i] < smm.max && nums[i] > smm.min) {
					return true;
				}
			}
		}

		return false;
	}

	class MinMax {
		int min;
		int max;

		MinMax(int i) {
			min = i;
			max = i;
		}
	}

	public static void main(String... args) {
		OneThreeTwoPattern ottp = new OneThreeTwoPattern();
		System.out.println(ottp.find132pattern(new int[] { 3, 1, 4, 2 }));
		System.out.println(ottp.find132pattern(new int[] { -1, 3, 2, 0 }));
		System.out.println(ottp.find132pattern(new int[] { 1, 2, 3, 4 }));
		System.out.println(ottp.find132pattern(new int[] { 3,5,0,3,4 }));
		System.out.println(ottp.find132pattern(new int[] { 9,10,11,13,1,2,3,4,5,6,8,12 }));
	}
}
