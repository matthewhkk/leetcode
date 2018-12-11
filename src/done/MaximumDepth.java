package done;

import javax.xml.soap.Node;

/*
 * Q104
 */
public class MaximumDepth {
	
	public int maxDepth(TreeNode root)
	{
		return maxDepth(root, 1);
	}
	
	public int maxDepth(TreeNode root, int height)
	{
		if (root == null)
		{
			return height - 1;
		}
		else
		{
			return Math.max(maxDepth(root.left, height+1), maxDepth(root.right, height + 1));
		}
	}
	
	public static void main (String... args)
	{
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.right = new TreeNode(2);
		
		MaximumDepth md = new MaximumDepth();
		System.out.println(md.maxDepth(tn));
		System.out.println(md.maxDepth(tn.left));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
