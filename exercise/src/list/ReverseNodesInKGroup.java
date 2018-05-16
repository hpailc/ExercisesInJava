package list;

/*
 * ����һ������ÿ k ���ڵ�һ����з�ת�������ط�ת�������
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�����ʣ��ڵ㱣��ԭ��˳��
 * 
 * ʾ����
 * 		�����������1->2->3->4->5
 * 		�� k = 2 ʱ��Ӧ������: 2->1->4->3->5
 * 		�� k = 3 ʱ��Ӧ������: 3->2->1->4->5
 * ˵����
 * 		����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * 		�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻��
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
	 * LeetCode  ��  ˫�صݹ�ķ���������ת��
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
		ListNode cHead = reverseK(head, k);		//��ǰ k �����з�ת
		cTail.next = reverseKGroup_2(step, k);	//ÿ�η�ת k ����ֱ������

		return cHead;
	}

	private static ListNode reverseK(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode gHead = reverseK(head.next, k - 1);	// �����ڵݹ���ã����з�ת
		head.next.next = head;
		head.next = null;
		return gHead;
	}

	/**
	 * LeetCode �� ��������ָ�룬pre��cur��nex ���Ա��������е�������в���
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
