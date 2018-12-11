package done;

import util.ListNode;

/* 
 * Q19
 */

/*
 * Note
 * Can see a pointer n+1 ahead, and then move both pointer, 
 * at last, remove the first pointer next
 */
public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n){
		if (head == null)
		{
			return null;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode node = dummy;
		int i = 1;
		
		int count =0 ;
		while(head != null)
		{
			count++;
			head = head.next;
		}
		
		n = count - n + 1;
		while (i < n && node.next != null)
		{
			node = node.next;
			i++;
		}
		
		node.next = node.next.next;
		return dummy.next;
	}
	
	public static void main (String... args )
	{
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		
		RemoveNthNode rnn = new RemoveNthNode();
		ListNode n = rnn.removeNthFromEnd(ln, 5);
		while (n != null)
		{
			System.out.println(n.val+ ",");
			n = n.next;
		}
		
	}
}
