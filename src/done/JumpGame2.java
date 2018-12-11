package done;

public class JumpGame2 {

	
//	First Approach , too slow
	
//	public int jump(int[] nums) {
//
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//
//		int[] shortestJump = new int[nums.length];
//		boolean[] isSkip = new boolean[nums.length];
//
//		for (int i = 0; i < nums.length; i++) {
//			
//			if(isSkip[i])
//			{
//				continue;
//			}
//			for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
//				int currentShortest = shortestJump[i + j];
//				int startingShortest = shortestJump[i];
//				
//				shortestJump[i + j] = currentShortest == 0 ? startingShortest + 1: Math.min(currentShortest, startingShortest + 1);
//			}
//		}
//
//		return shortestJump[nums.length - 1];
//	}
	
	/*
	 * For this solution, the idea is to keep track on the farest point the current point can reach
	 * And on the next point, we start from the farest point and continue
	 * 
	 * But actually suggested in the discussion, the solution is:
	 * for each jump, we store how far it could jump,
	 * as the point between current point and the max jump point will have the same amount of shortest jump (current shortest jump) + 1
	 * so we could see among this few point, what will be the next farest jump
	 */
	public int jump(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int farestIndex = 0;
		int[] shortestJump = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			
			for (int j = farestIndex - i + 1; j <= nums[i] && i + j < nums.length; j++) {
				int currentShortest = shortestJump[i + j];
				int startingShortest = shortestJump[i];
				
				shortestJump[i + j] = currentShortest == 0 ? startingShortest + 1: Math.min(currentShortest, startingShortest + 1);
			}
			farestIndex = Math.max(farestIndex, i + nums[i]);
		}

		return shortestJump[nums.length - 1];
	}

// Easy to understand solution in discussion
// The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:

	
//
//	public int jump(int[] A) {
//		int jumps = 0, curEnd = 0, curFarthest = 0;
//		for (int i = 0; i < A.length - 1; i++) {
//			curFarthest = Math.max(curFarthest, i + A[i]);
//			if (i == curEnd) {
//				jumps++;
//				curEnd = curFarthest;
//			}
//		}
//		return jumps;
//	}	

	public static void main(String... args) {
		JumpGame2 jg2 = new JumpGame2();
		System.out.println(jg2.jump(new int[] { 3, 3, 1, 1, 4 }));
	}
}
