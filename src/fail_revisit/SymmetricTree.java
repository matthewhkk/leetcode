package fail_revisit;

import java.util.Deque;
import java.util.LinkedList;

import util.TreeNode;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<>();
		TreeNode endNode = new TreeNode(-1);
		String tempStr = "";
		queue.offer(root);
		queue.offer(endNode);

		while (!queue.isEmpty()) {
			TreeNode node = queue.pop();

			if (node == endNode && !queue.isEmpty()) {
				tempStr = tempStr.substring(0,tempStr.length()-1);
				if (!tempStr.equals(reverse(tempStr))) {
					return false;
				} else {
					queue.offer(endNode);
					tempStr = "";
				}
			} else {
				if (node != null) {
					queue.offer(node.left);
					queue.offer(node.right);
					tempStr += node.val + ",";
				} else {
					tempStr += " " + ",";
				}

			}
		}

		return true;
	}

	private String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		return result;
	}

	public static void main(String... args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(42);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(24);

		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(root));

	}
}
