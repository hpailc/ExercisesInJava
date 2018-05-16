package list;

/*
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * 		[
 * 			1->4->5,
 * 			1->3->4,
 * 			2->6
 * 		]
 * 
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(5);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);
		
		ListNode[] lists = {ln1,ln2,ln3};
		ListNode result = mergeKLists(lists);
		while(result != null){
			System.out.print(result.val);
			result = result.next;
		}
	}

	private static ListNode mergeKLists(ListNode[] lists) {

		if(lists.length<2)
			return lists.length==0 ? null : lists[0];
		
		ListNode result = lists[0];
		for(int i = 1; i < lists.length; i++){
			result = merge(result, lists[i]);
		}
		return result;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = merge(l1.next,l2);
			return l1;
		}else{
			l2.next = merge(l1,l2.next);
			return l2;
		}
	}
}

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}