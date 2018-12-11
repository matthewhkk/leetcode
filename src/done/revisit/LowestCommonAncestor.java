package done.revisit;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.TreeNode;

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<List<TreeNode>> lists = new ArrayList<>();
    	List<TreeNode> list = new ArrayList<>();
    	Deque<TreeNode> stack = new LinkedList<>();
    	Set<TreeNode> visited = new HashSet<>();
    	
    	stack.push(root);
    	
    	while (!stack.isEmpty())
    	{
    		TreeNode node = stack.peek();
    		
    		if (visited.contains(node))
    		{
    			stack.pop();
    			list.remove(list.size()-1);
    			continue;
    		}
    		else
    		{
    			visited.add(node);
        		list.add(node);
        		
        		if (node.equals(p) || node.equals(q))
        		{
        			lists.add(new ArrayList(list));
        		}
    		}

    		
    		if (node.right != null)
    		{
    			stack.push(node.right);
    		}
    		if (node.left != null)
    		{
    			stack.push(node.left);
    		}
    	}
    	
    	List<TreeNode> a = lists.get(0);
    	List<TreeNode> b = lists.get(1);
    	
    	int index = 0;
    	
    	for (; index < Math.min(a.size(), b.size()) && a.get(index).equals(b.get(index)); index++)
    	{
    	}
    	
    	return a.get(index -1);
    }

	public void print(List<TreeNode> list) {
		for (TreeNode node : list) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}

	public static void main(String... args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		LowestCommonAncestor lca = new LowestCommonAncestor();
		System.out.println(lca.lowestCommonAncestor(root, root.left.left, root.left.right.right).val);

	}
}
