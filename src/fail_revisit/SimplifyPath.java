package fail_revisit;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

	public String simplifyPathString(String path) {
		Deque<String> stack = new ArrayDeque<>();
		boolean isSameDir = true;
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (stack.isEmpty()) {
				stack.addFirst(String.valueOf(c));
			} else {
				if( c == '/')
				{
					isSameDir = false;
					continue;
				}
				else if (c == '.')
				{
					isSameDir = false;
					char next = path.charAt(i+1);
					if (next == '.')
					{
						stack.removeFirst();
						i++;
					}
					else if (next == '/')
					{
						i++;
						continue;
					}
				}
				else
				{
					if (isSameDir)
					{
						String s = stack.removeFirst();
						s = String.valueOf(c) + s;
						stack.addFirst(s);
					}
					else
					{
						stack.addFirst(String.valueOf(c));
						isSameDir = true;
					}
				}
			}
		}
		
		String result = "";
		
		while(!stack.isEmpty())
		{
			result = result + String.valueOf(stack.removeFirst()) + '/';
		}
		
		String reverse = "";
				
		for (int i = result.length()-1; i >= 0 ; i--)
		{
			reverse = reverse + result.charAt(i);
		}

		
		return reverse.replaceAll("/+", "/");
	}
	
	/*
	 * For handling file like question, can use split
	 */
	
	
	/*
	 *  
  		public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
	 */

	public static void main(String... args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPathString("/a/./b/../../c/"));
		System.out.println(sp.simplifyPathString("/a//bdd////c/d//././/.."));
		System.out.println(sp.simplifyPathString("/a/../../b/../c//.//"));
	}

}
