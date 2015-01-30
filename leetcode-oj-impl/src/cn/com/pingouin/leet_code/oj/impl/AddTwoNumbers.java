package cn.com.pingouin.leet_code.oj.impl;

public class AddTwoNumbers {

	 public static void main(String[] args) {
		 
		 // 一个单向链表
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
		 
		 //------------------------------
		 // addTwoNumbers
		 // 单向链表，反向存储两个数再相加，实际上等于从个位开始加
		 
		 ListNode listNode = new ListNode(0);
		 int carry = 0; // 进位
		 
		 // 初始化，和while中相似，大于10当前位就取余，进位1
		 int firstSum = l1.val + l2.val;
		 listNode.val  = firstSum/10 > 0 ? firstSum%10 : firstSum;
		 carry = firstSum/10;
		 l1 = l1.next;
		 l2 = l2.next;
		 
		 // 指针，result一直指向这个地址，listNode负责一级级往前走，等于result一级级的增加next
		 ListNode result = listNode;
		 
		 // 因为next默认是null，两个单向链都到头的话就不再循环
		 while (l1 != null || l2 != null || carry != 0) {
			 ListNode tempListNode = new ListNode(0);
			 
			 // 单向链到头的对象就把当前值置0
			 if(l1 == null) l1 = tempListNode;
			 if(l2 == null) l2 = tempListNode;
			 
			 int sum = l1.val + l2.val + carry;
			 tempListNode = sum/10 > 0 ? new ListNode(sum%10) : new ListNode(sum);
			 // result多了一级next
			 listNode.next = tempListNode;
			 // 实际上是listNode向前进一位
			 listNode = tempListNode;
			 carry = sum/10;

			 l1 = l1.next;
			 l2 = l2.next;
		 }
		 
		 System.out.println(result.val);
	 }
	 
}
