/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Solution2 {
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-101);
		ListNode temp = new ListNode(-101);
		while (list1 != null && list2 != null) {

			if (list1 != null && list2 != null) {
				if (list1.val <= list2.val) {
					if (head.val == -101) {
						head = new ListNode(list1.val);
						temp = head;
					} else {
						temp.next = new ListNode(list1.val);
						temp = temp.next;
					}
					list1 = list1.next;
				} else if (list1.val > list2.val) {
					if (head.val == -101) {
						head = new ListNode(list2.val);
						temp = head;
					} else {
						temp.next = new ListNode(list2.val);
						temp = temp.next;
					}
					list2 = list2.next;
				}
			} else {
				if(list1!=null) {
					temp.next = new ListNode(list1.val);
					list1 = list1.next;
				}
				if(list2!=null) {
					temp.next = new ListNode(list2.val);
					list2 = list2.next;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	public static void main(String args[]) {
		ListNode list1 = new ListNode(1);
		ListNode temp;
		temp = list1;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		ListNode temp1;
		temp1 = list1;
		temp1.next = new ListNode(3);
		temp1 = temp.next;
		temp1.next = new ListNode(4);

		ListNode ret = mergeTwoLists(list1, list2);
		
		while(ret!=null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}