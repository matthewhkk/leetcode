package done;

public class BullsAndCows {

	public String getHint(String secret, String guess)
	{
		int[] secretDigitArray = new int[10];
		int[] guessDigitArray = new int[10];
		int bull = 0 ;
		
		for (int i = 0; i < secret.length(); i++)
		{
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			
			if (s == g)
			{
				bull++;
			}
			secretDigitArray[s - '0']++;
			guessDigitArray[g - '0']++;
		}
		
		int cow = 0;
		for (int i = 0; i < secretDigitArray.length; i++)
		{
			cow += Math.min(secretDigitArray[i], guessDigitArray[i]);
		}
		cow = cow - bull;
		
		return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
	}
	
	public static void main (String... args)
	{
		BullsAndCows bc = new BullsAndCows();
		
		System.out.println(bc.getHint("1123", "0111"));
		
	}
	
	
}
