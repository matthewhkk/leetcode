package done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeRight {
	public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (root == null) return result;
    	
    	Deque<TreeNode> queue = new LinkedList<>();
    	int temp = 0;
    	queue.offer(root);
    	queue.offer(null);
    	
    	while (!queue.isEmpty())
    	{
    		TreeNode node = queue.pop();
    		if (node == null )
    		{
    			result.add(temp);
    			if(!queue.isEmpty()) queue.offer(null);
    			temp = 0;
    		}
    		else {
    			if (node.left != null) queue.offer(node.left);
    			if (node.right != null) queue.offer(node.right);
    			
    			temp = node.val;
			}
    	}
    	return result;
    }

	public static void main(String... args) {
		TreeNode rootNode = new TreeNode(1);
		rootNode.left =  new TreeNode(2);
		rootNode.left.right = new TreeNode(5);
		rootNode.right = new TreeNode(3);
		rootNode.right.left = new TreeNode(4);

		BinaryTreeRight btr = new BinaryTreeRight();
		System.out.println(btr.rightSideView(rootNode));
	}

}
