package progress;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
	
	public String frequencySort(String s)
	{
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0 ; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else 
			{
				map.put(c, 1);
			}
		}
		
		List<Map.Entry> list = map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry: list)
		{
			for (int i =0 ; i < entry.getValue(); i++)
			{
				sb.append(entry.getKey());
			}
		}
		
		return sb.toString();
	}
	
	
	public static void main (String ... args)
	{
		SortCharactersByFrequency scf = new SortCharactersByFrequency();
	}

}
