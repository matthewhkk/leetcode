package fail_revisit;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {
	
	public ListNode partition(ListNode head, int x)
	{
		ListNode tempHead = head;
		ListNode larger = null;
		ListNode largerHead = null;
		ListNode start = null;

		if (head == null)
		{
			return null;
		}
		
		ListNode currentNode = head;
		ListNode nextNode = head.next;
		
		while (start == null)
		{
			if(currentNode.val < x)
			{
				start = currentNode;
				break;
			}
			else 
			{
				if(largerHead == null)
				{
					larger = currentNode;
					largerHead = larger;
				}
				else 
				{
					larger.next = currentNode;
					larger = larger.next;
				}
			}
			if(nextNode != null)
			{
				currentNode = nextNode;
				nextNode = nextNode.next;
			}
			else
			{
				break;
			}
		}
		
		while(nextNode != null)
		{
			if (nextNode.val < x)
			{
				currentNode = nextNode;
				nextNode = nextNode.next;
			}
			else
			{
				if(largerHead == null)
				{
					larger = nextNode;
					largerHead = larger;
				}
				else 
				{
					larger.next = nextNode;
					larger = larger.next;
				}
				nextNode = nextNode.next;
				currentNode.next = nextNode;
			}
		}
		
		larger.next = null;
		currentNode.next = largerHead;
		return start == null? largerHead: start;
	}
	
	public void print(ListNode head)
	{
		while (head != null)
		{
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	
// Ideal solution
// Idea is to use a dummy to store each head
//	public ListNode partition(ListNode head, int x) {
//	    ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
//	    ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
//	    while (head!=null){
//	        if (head.val<x) {
//	            curr1.next = head;
//	            curr1 = head;
//	        }else {
//	            curr2.next = head;
//	            curr2 = head;
//	        }
//	        head = head.next;
//	    }
//	    curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
//	    curr1.next = dummy2.next;
//	    return dummy1.next;
//	}

	public static void main (String... args)
	{
		PartitionList pl = new PartitionList();
		List<ListNode> l = new ArrayList<>();
//		l.add(new ListNode(4));
//		l.add(new ListNode(1));
//		l.add(new ListNode(3));
//		l.add(new ListNode(2));
//		l.add(new ListNode(5));
//		l.add(new ListNode(2));
//		int target = 3
		
		l.add(new ListNode(2));
		l.add(new ListNode(1));
		int target = 0;
		
		ListNode head = l.get(0);
		for (int i = 1; i< l.size();i++)
		{
			ListNode temp = l.get(i);
			head.next = temp;
			head = temp;
		}
		
		pl.print(l.get(0));
		System.out.println();
		pl.print(pl.partition(l.get(0), target));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
