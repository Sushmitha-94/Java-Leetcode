
/*
 * 2. Add Two Numbers
		You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

		You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

public class TwoNums {
	
	
	
	//MySolution
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode toRet = null;
	        ListNode currNode = null;
	        int carry =0;
	        while(true) {
	        	if(l1==null && l2==null) {
	        		if(carry==1)
	        			currNode.next = new ListNode(1);
	        		break;
	        	}
	        	
	        	else {
	        		if(l1==null) {
	        			currNode.next = new ListNode((l2.val+carry)%10);
        				carry = (l2.val+carry)/10;
        				currNode = currNode.next;
	        			l2=l2.next;
	        		}
	        		else if(l2==null) {
	        			currNode.next = new ListNode((l1.val+carry)%10);
        				carry = (l1.val+carry)/10;
        				currNode = currNode.next;
	        			l1=l1.next;
	        		}
	        		else {
	        			if(toRet==null) {
	        				toRet = new ListNode((l1.val+l2.val+carry)%10);
	        				carry = (l1.val+l2.val+carry)/10;
	        				currNode = toRet;	        				
	        			}
	        			else {
	        				currNode.next = new ListNode((l1.val+l2.val+carry)%10);
	        				carry = (l1.val+l2.val+carry)/10;
	        				currNode = currNode.next;
	        				
	        			}
	        			l1 = l1.next;
        				l2 = l2.next;
	        		}
	        	}
	        }
	        return toRet;
    }
	
	//BestSolution
	// Loop through the listnodes till both are null
	//    save the mod (l1+l2+carry) of 10 to the nect node
	//    calculate the carry
	//    move to next nodes if not null
	// end loop
	// if carry has value, save it in next listnode
	public ListNode addTwoNumbersB(ListNode l1, ListNode l2) {
		ListNode toRet = null;
        ListNode currNode = null;
        int carry =0;
        while(l1!=null || l2!=null) {
        	
        	int l1Val,l2Val;
            l1Val = l1==null? 0: l1.val;
            l2Val = l2==null? 0: l2.val;
            
            if(toRet == null) {
            	toRet = new ListNode((l1Val+l2Val+carry)%10);
            	currNode = toRet;
            }
            else {
            	currNode.next = new ListNode((l1Val+l2Val+carry)%10);
            	currNode = currNode.next;
            }
            carry = (l1Val+l2Val+carry)/10;
            
            if(l1!=null)
            	l1=l1.next;
            
            if(l2!=null)
            	l2=l2.next;
            
        }
        if(carry==1)
			currNode.next = new ListNode(1);
        
        return toRet;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(2);
		
		ListNode toPrint = addTwoNumbers(l1,l2);
		while(toPrint!=null) {
			System.out.println(toPrint.val);
			toPrint = toPrint.next;
		}
	}

}
