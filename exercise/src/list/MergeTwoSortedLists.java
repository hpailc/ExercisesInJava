package list;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l = mergeTwoLists(l1, l2);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			ListNode n = new ListNode(l1.val);
			n.next = result;
			result = n;
			l1 = l1.next;
		} else if (l1.val > l2.val) {
			ListNode n = new ListNode(l2.val);
			n.next = result;
			result = n;
			l2 = l2.next;
		} else {
			ListNode n = new ListNode(l1.val);
			n.next = result;
			result = n;
			l1 = l1.next;
			ListNode m = new ListNode(l2.val);
			m.next = result;
			result = m;
			l2 = l2.next;
		}
		
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
