package list;

/*
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序
 * 
 * 示例：
 * 		给定这个链表：1->2->3->4->5
 * 		当 k = 2 时，应当返回: 2->1->4->3->5
 * 		当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 * 		你的算法只能使用常数的额外空间。
 * 		你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		// head.next.next.next.next.next.next = new ListNode(7);

		ListNode result = reverseKGroup_2(head, 3);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	/**
	 * LeetCode  ：  双重递归的方法来进行转换
	 * 
	 */
	private static ListNode reverseKGroup_2(ListNode head, int k) {
		int i;
		ListNode step = head;
		for (i = 1; i <= k; i++) {
			if (step == null)
				break;
			else
				step = step.next;
		}
		if (i - 1 < k)
			return head;

		ListNode cTail = head;
		ListNode cHead = reverseK(head, k);		//将前 k 个进行翻转
		cTail.next = reverseKGroup_2(step, k);	//每次翻转 k 个，直到结束

		return cHead;
	}

	private static ListNode reverseK(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode gHead = reverseK(head.next, k - 1);	// 方法内递归调用，进行翻转
		head.next.next = head;
		head.next = null;
		return gHead;
	}

	/**
	 * LeetCode ： 利用三个指针，pre，cur，nex 来对遍历过程中的链表进行操作
	 * @param head
	 * @param k
	 * @return
	 */
	private static ListNode reverseKGroup_1(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode prehead = new ListNode(-1);
		prehead.next = head;

		ListNode pre = prehead;
		ListNode nex = prehead;
		head = prehead;

		int num = 0;
		while ((head = head.next) != null) {
			num++;
		}

		while (k <= num) {
			head = pre.next;
			nex = head.next;
			for (int i = 1; i < k; i++) {
				head.next = nex.next;
				nex.next = pre.next;
				pre.next = nex;
				nex = head.next;
			}
			pre = head;
			num -= k;
		}

		return prehead.next;
	}

}
