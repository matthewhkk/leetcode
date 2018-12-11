package done;

import java.util.ArrayList;
import java.util.List;


/*
 * Q17
 */

/*
 * Note
 * Iterative solution:
 * Use a queue to store 
 * pickfirst, add with all possible char of next
 * eg.
 * queue {a, b, c}
 * next 3 = {d,e,f}
 * 
 * pick a
 * add with 3's character -> {ad,ae,af}
 * add back this three to queue
 */
public class LetterCombination {

	
	String[][] nums = new String[][]{{""},
									{""},
									{"a","b","c"},
									{"d","e","f"},
									{"g","h","i"},
									{"j","k","l"},
									{"m","n","o"},
									{"p","q","r","s"},
									{"t","u","v"},
									{"w","x","y","z"},};
	
	 public List<String> letterCombinations(String digits) {
		 
		 
	        List<String> list = new ArrayList<>();
	        if(digits.length() == 0)
	        {
	        	return list;
	        }
	        loop(list,  "", digits, 0 );
		 return list;
	 }
	 
	 public void loop(List<String> resultList, String tempString, String digits, int cur )
	 {
		 if (cur == digits.length())
		 {
			 resultList.add(tempString);
			 return;
		 }
		 
		 String[] strArray = nums[digits.charAt(cur)-'0'];
		 for (int i = 0 ; i < strArray.length; i++)
		 {
			 loop(resultList, tempString + strArray[i], digits, cur+1);
		 }
	 }
	 
	 public static void main(String... args)
	 {
		 LetterCombination lc = new LetterCombination();
		 System.out.println(lc.letterCombinations("2569"));
	 }
	 
}
