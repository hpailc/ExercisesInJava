package list;

/*
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例：
 * 		给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明：
 * 		你的算法只能使用常数的额外空间。
 * 		你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairsInLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode result = swapPairs(head);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	/*
	 * 自己想出来的方法，通过递归解决，很容易理解
	 */
	private static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode result = head.next;
		head.next = swapPairs(head.next.next);
		result.next = head;

		return result;
	}
}
