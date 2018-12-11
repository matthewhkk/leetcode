package done;

public class HammingDistance {

	public int hammingDistance(int x, int y)
	{
		return Integer.bitCount(x ^ y);
	}
	
	public static void main (String ... args)
	{
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(1, 4));
		System.out.println(hd.hammingDistance(0, 0));
		System.out.println(hd.hammingDistance(0, 15));
		System.out.println(hd.hammingDistance(1, 15));
	}
}
