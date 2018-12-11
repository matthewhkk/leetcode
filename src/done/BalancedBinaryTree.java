package done;

public class BalancedBinaryTree {

	
	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
        
    }
	
	public int height(TreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			int lh = height(node.left);
			int rh = height(node.right);
			
			if(lh == -1 || rh == -1)
			{
				return -1;
			}
			if (Math.abs(lh -rh) > 1)
			{
				return -1;
			}
			else 
			{
				return Math.max(lh, rh) + 1; 
			}
		}
	}
	
	public static void main(String... args)
	{
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(4);
		
		a.left = b;
		b.left = d;
		d.left = f;
		
		a.right = c;
		c.right = e;
		e.right = g;
		
		BalancedBinaryTree sp = new BalancedBinaryTree();
		System.out.println(sp.height(a));
		System.out.println(sp.isBalanced(a));
	}
}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}