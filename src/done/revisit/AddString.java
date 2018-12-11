package done.revisit;


/*
 * Q415
 */

/*
 * Note
 * 1. Use String builder
 * 2. Can reverse using sb
 * 3. Can use two index in for loop
 * 4. From char to int , can use char - '0'
 */

/*
 * public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
 * 
 */
public class AddString {

	public String addStrings (String num1, String num2){
		int length1 = num1.length();
		int length2 = num2.length();
		
		int offset1 = 0;
		int offset2 = 0;
		boolean isLonger = false;
		
		if (length1 > length2)
		{
			offset1 = length1 - length2;
			isLonger = true;
		}
		else if (length2 > length1)
		{
			offset2 = length2 - length1;
			isLonger = true;
		}
		
		int offset = 0;
		String result = "";
		for (int i = Math.min(length1,length2) - 1; i >=0 ; i--)
		{
			int sum = Integer.parseInt(String.valueOf(num1.charAt(i+offset1))) + Integer.parseInt(String.valueOf(num2.charAt(i+offset2))) + offset;
			offset = sum > 9 ? 1: 0;
			result = sum%10 + result; 
		}
		
		if (isLonger)
		{
			String temp = offset1 > 0 ? num1.substring(0,offset1) : num2.substring(0,offset2);
			
			for (int i = temp.length() -1 ; i>= 0 ; i--)
			{
				int sum = Integer.parseInt(String.valueOf(temp.charAt(i))) + offset;
				offset = sum > 9 ? 1: 0;
				result = sum%10 + result; 
			}
		}
		
		return offset == 1 ? "1" + result : result;
	}
	
	public static void main(String ... args)
	{
		AddString as = new AddString();
		System.out.println(as.addStrings("50", "1961"));
	}
}
