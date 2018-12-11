package done;

import util.TreeNode;


/*
 * Q112
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		return hasPathSum(root, 0, sum);
	}

	public boolean hasPathSum(TreeNode node, int current, int sum)
    {
		int totalSum = current + node.val;
    	if (node.left == null && node.right == null)
    	{
    		return totalSum == sum;
    	}
    	
    	else 
    	{
    		boolean left = node.left == null ? false : hasPathSum(node.left, totalSum, sum);
    		boolean right = node.right == null ? false : hasPathSum(node.right, totalSum, sum);
    		return left || right;
    	}
    }
	
	public static void main (String... args)
	{
		PathSum ps = new PathSum();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(4);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
		
		System.out.println(ps.hasPathSum(root, 3));
		System.out.println(ps.hasPathSum(root, 5));
		System.out.println(ps.hasPathSum(root, 6));
		System.out.println(ps.hasPathSum(root, 9));
		System.out.println(ps.hasPathSum(root, 8));
		System.out.println(ps.hasPathSum(root, 7));
	}
}
