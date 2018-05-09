package list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(7);
		ListNode l = mergeTwoLists_1(l1, l2);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

	public static ListNode mergeTwoLists_1(ListNode l1,ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
	}

	/****************************************
	 * 方法一：自己想出来的
	 ****************************************
	 * 问题： 1,考虑了三种情况，l1>l2, l1<l2,l1=l2。这里其实只用考虑两种情况，把后两种情况合二为一是比较好的选择。
	 * 2,其实不需要再单独新建一个ListNode，直接在原来的ListNode上操作就可以； 3,回调函数写的稍微麻烦了点，可以更加精简
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			result = new ListNode(l1.val);
			l1 = l1.next;
			result.next = mergeTwoLists(l1, l2);
		} else if (l1.val > l2.val) {
			result = new ListNode(l2.val);
			l2 = l2.next;
			result.next = mergeTwoLists(l1, l2);
		} else {
			result = new ListNode(l1.val);
			result.next = new ListNode(l2.val);
			l1 = l1.next;
			l2 = l2.next;
			result.next.next = mergeTwoLists(l1, l2);
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
