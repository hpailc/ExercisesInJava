package list;

/*
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * ʾ����
 * 		���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
 * ˵����
 * 		����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * 		�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
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
	 * �Լ�������ķ�����ͨ���ݹ��������������
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
