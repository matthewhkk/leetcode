package done.revisit;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> resultList = new ArrayList<>(); 
        traverse(root, resultList);
        
        return resultList;
    } 
    
    public void traverse(TreeNode node, List<Integer> list )
    {
    	if (node == null)
    	{
    		return;
    	}
    	
    	traverse(node.left, list);
    	list.add(node.val);
    	traverse(node.right, list);
    }
    
    public static void main (String... args)
    {
    	TreeNode rootNode = new TreeNode(1);
    	rootNode.right = new TreeNode(2);
    	rootNode.right.left = new TreeNode(3);
    	
    	BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
    	System.out.println(bt.inorderTraversal(rootNode));
    }
}
