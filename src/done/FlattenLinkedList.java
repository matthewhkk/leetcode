package done;

import java.util.Deque;
import java.util.LinkedList;


/*
 * Q430
 */

/*
 * Note : 
 * There's a better version :
 * if there's a child, loop through it's tail
 * and then point the tail.next to current next 
 */
public class FlattenLinkedList {

	public Node flatten(Node root) {
		if (root == null) {
			return root;
		}

		Deque<Node> stack = new LinkedList<Node>();
		Node head = root;
		while (head.next != null || head.child != null || !stack.isEmpty()) {

			if (head.next == null && !stack.isEmpty()) {
				Node node = stack.pop();
				link(head,node);
			}

			if (head.child != null) {
				if (head.next != null) {
					stack.push(head.next);
				}
				link(head, head.child);
				head.child = null;
			}
			head = head.next;
		}

		return root;
	}

	public void link(Node a, Node b) {
		a.next = b;
		b.prev = a;
	}


	public static void main(String... args) {
		FlattenLinkedList fll = new FlattenLinkedList();
		Node head = fll.createNode();
		
	}

	public Node createNode() {
		return new Node();
	}

	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {
		}

		public Node(int _val, Node _prev, Node _next, Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	}
}
