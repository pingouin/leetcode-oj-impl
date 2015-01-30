package leet_code_oj_impl.cn.com.pingouin.leet_code.oj.impl;

public class AddTwoNumbers {

	 public static void main(String[] args) {
		 
		 class ListNode {
			 int val;
		     ListNode next;
		     
		     ListNode(int x) {
		    	 val = x;
		         next = null;
		     }
		 }
		 
		 ListNode l1 = new ListNode(2);
		 l1.next = new ListNode(4);
		 l1.next.next = new ListNode(3);
		 
		 ListNode l2 = new ListNode(5);
		 l2.next = new ListNode(6);
		 l2.next.next = new ListNode(4);
		 
		 // addTwoNumbers
		 ListNode listNode = new ListNode(0);
		 int carry = 0;
		 
		 int firstSum = l1.val + l2.val;
		 listNode.val  = firstSum/10 > 0 ? firstSum%10 : firstSum;
		 carry = firstSum/10;
		 l1 = l1.next;
		 l2 = l2.next;
		 
		 ListNode result = listNode;
		 
		 while (l1 != null || l2 != null || carry != 0) {
			 ListNode tempListNode = new ListNode(0);
			 
			 if(l1 == null) l1 = tempListNode;
			 if(l2 == null) l2 = tempListNode;
			 
			 int sum = l1.val + l2.val + carry;
			 tempListNode = sum/10 > 0 ? new ListNode(sum%10) : new ListNode(sum);
			 listNode.next = tempListNode;
			 listNode = tempListNode;
			 carry = sum/10;

			 l1 = l1.next;
			 l2 = l2.next;
		 }
		 
		 System.out.println(result.val);
	 }
	 
}
