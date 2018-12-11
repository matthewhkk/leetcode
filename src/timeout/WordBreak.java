package timeout;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/*
 * Q139
 */

/*
 * Note
 * Rethink on what is dp
 * if we know the substring before index i can be combined by the words in dict, 
 * we do not need to we do again
 */
public class WordBreak {

//    public boolean wordBreak(String s, List<String> wordDict) {
//    	
//    	Set<String> dict = new HashSet<>();
//    	int maxSize = 0;
//    	for(String word: wordDict)
//    	{
//    		dict.add(word);
//    		if (word.length() > maxSize)
//    		{
//    			maxSize = word.length();
//    		}
//    	}
//    	
//    	for(String word: wordDict)
//    	{
//    		String temp = word + word;
//    		while(temp.length() <= maxSize){
//    			if(dict.contains(temp))
//    			{
//    				dict.remove(temp);
//    			}
//    			else
//    			{
//    				temp += word;
//    			}
//    		}
//    	}
//    	
//    	
//    	
//    	return wordBreak(s,dict);
//    }
//    
//    public boolean wordBreak(String s, Set<String> dict )
//    {
//    	if (s.length() == 0)
//    	{
//    		return true;
//    	}
//    	for(int i = 1 ; i<= s.length(); i++)
//    	{
//    		if (dict.contains(s.substring(0,i)))
//    		{
//    			if (wordBreak(s.substring(i), dict))
//    			{
//    				return true;
//    			}
//    		}
//    	}
//    	return false;
//    }
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Deque<String> queue = new LinkedList<>();
		
		queue.add(s);
		while(!queue.isEmpty())
		{
			String string = queue.pop();
			for (String dictWord : wordDict)
			{
				int length = dictWord.length();
				if (dictWord.equals(string.substring(0,length)))
				{
					String temp = string.substring(length);
					if (temp.length() == 0)
					{
						return true;
					}
					queue.offer(string.substring(length));
				}
			}
		}
		return false;
	}
    
    public static void main(String ... args)
    {
//    	List<String> list = Arrays.asList(new String[] {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"});
//    	String target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	
    	
    	List<String> list = Arrays.asList(new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});
    	String target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    	
    	
//    	List<String> list = Arrays.asList(new String[] {"apple","pen"});
//    	String target = "applepenapple";
    	WordBreak wb = new WordBreak();
    	System.out.println(wb.wordBreak(target, list));
    }
}
