package progress;


public class PlusOne {

	public int[] plusOne(int[] digits) {
		
		if (digits == null || digits.length == 0)
		{
			return digits;
		}
		int carries = 0;
		digits[digits.length-1]= digits[digits.length - 1] + 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + carries; 
			if (digits[i] > 9) {
				carries = 1;
			} else {
				carries = 0;
				break;
			}
			digits[i] = digits[i] % 10;
		}

		if (carries == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		} else {
			return digits;
		}

	}

	public static void main(String... args) {
		PlusOne po = new PlusOne();
		print(po.plusOne(new int[] { 1, 2, 3, 4, 5 }));
		print(po.plusOne(new int[] { 1, 2, 9, 4, 5 }));
		print(po.plusOne(new int[] { 9, 9, 9 }));
		print(po.plusOne(new int[] { 8, 9, 9, 9 }));
		print(po.plusOne(new int[] { 9 }));
	}

	public static void print(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
