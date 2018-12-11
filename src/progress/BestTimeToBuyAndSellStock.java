package progress;

/*
 * Q121
 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] list) {
		if (list == null || list.length <= 1) {
			return 0;
		}

		int first = 0;
		int last = 1;
		int max = 0;
		int minPrice = list[first];
		while (last <= list.length - 1) {
			int curPrice = list[last];

			if (curPrice < minPrice) {
				first = last;
				minPrice = list[first];
			} else {
				int diff = curPrice - minPrice;

				if (diff > max) {
					max = diff;
				}
			}
			last++;
		}

		return max;
	}
	
	public static void main (String... args)
	{
		BestTimeToBuyAndSellStock ms = new BestTimeToBuyAndSellStock();
		System.out.println(ms.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(ms.maxProfit(new int[] {7,6,5,4,3,2,1}));
		System.out.println(ms.maxProfit(new int[] {7,2,5,1,8,2,1}));
	}
}
