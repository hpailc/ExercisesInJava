package list.analyze;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {

		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		// ln.next.next = new ListNode(3);
		// ln.next.next.next = new ListNode(4);
		// ln.next.next.next.next = new ListNode(5);
		ListNode result = removeNthFromEnd_1(ln, 2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	private static ListNode removeNthFromEnd_1(ListNode head, int n) {

		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast == null)
			return slow.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode currentNode = head;
		ListNode removeNode = head;
		int x = 0;
		while (currentNode.next != null) {
			if (x != n) {
				x++;
			} else {
				removeNode = removeNode.next;
			}
			currentNode = currentNode.next;
		}
		removeNode.next = removeNode.next == null ? removeNode : removeNode.next.next;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}