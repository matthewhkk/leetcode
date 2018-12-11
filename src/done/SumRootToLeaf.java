package done;

import util.TreeNode;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
    	if (root == null)
    	{
    		return 0;
    	}
    	
    	return sumAll(root, 0) ;
    }
    
    public int sumAll(TreeNode node, int currentPathNum)
    {
    	if (node.left == null && node.right == null)
    	{
    		return currentPathNum*10 + node.val;
    	}
    	
    	int left = node.left != null? sumAll(node.left, currentPathNum*10 + node.val):0;
    	int right = node.right != null? sumAll(node.right, currentPathNum*10 + node.val):0;
    	
    	return left + right;
    }
    
    public static void main(String... args)
    {
    	TreeNode root = new TreeNode(4);
    	root.left = new TreeNode(9);
    	root.left.left= new TreeNode(5);
    	root.left.right = new TreeNode(1);
    	root.right = new TreeNode(0);
    	
    	SumRootToLeaf srl = new SumRootToLeaf();
    	System.out.println(srl.sumNumbers(root));
    }
}
