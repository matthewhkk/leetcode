package done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.TreeNode;

/*
 * Q113
 */

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> resultList = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		Set<TreeNode> set = new HashSet<>();

		if (root == null) {
			return resultList;
		}

		stack.push(root);
		int total = 0;
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (set.contains(node)) {
				stack.pop();
				list.remove(list.size() - 1);
				total -= node.val;
				continue;
			} else {
				set.add(node);
				total += node.val;
				list.add(node.val);
			}

			if (node.left == null & node.right == null) {
				if (total == sum) {
					resultList.add(new ArrayList<>(list));
				}
			} else {
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}

		return resultList;
	}

	public static void main(String... args) {
		PathSum2 ps = new PathSum2();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		System.out.println(ps.pathSum(null, 7));
	}
}
