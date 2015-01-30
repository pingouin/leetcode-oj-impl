package cn.com.pingouin.leet_code.oj.impl;

public class AddTwoNumbers {

	 public static void main(String[] args) {
		 
		 // һ����������
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
		 // ������������洢����������ӣ�ʵ���ϵ��ڴӸ�λ��ʼ��
		 
		 ListNode listNode = new ListNode(0);
		 int carry = 0; // ��λ
		 
		 // ��ʼ������while�����ƣ�����10��ǰλ��ȡ�࣬��λ1
		 int firstSum = l1.val + l2.val;
		 listNode.val  = firstSum/10 > 0 ? firstSum%10 : firstSum;
		 carry = firstSum/10;
		 l1 = l1.next;
		 l2 = l2.next;
		 
		 // ָ�룬resultһֱָ�������ַ��listNode����һ������ǰ�ߣ�����resultһ����������next
		 ListNode result = listNode;
		 
		 // ��ΪnextĬ����null����������������ͷ�Ļ��Ͳ���ѭ��
		 while (l1 != null || l2 != null || carry != 0) {
			 ListNode tempListNode = new ListNode(0);
			 
			 // ��������ͷ�Ķ���Ͱѵ�ǰֵ��0
			 if(l1 == null) l1 = tempListNode;
			 if(l2 == null) l2 = tempListNode;
			 
			 int sum = l1.val + l2.val + carry;
			 tempListNode = sum/10 > 0 ? new ListNode(sum%10) : new ListNode(sum);
			 // result����һ��next
			 listNode.next = tempListNode;
			 // ʵ������listNode��ǰ��һλ
			 listNode = tempListNode;
			 carry = sum/10;

			 l1 = l1.next;
			 l2 = l2.next;
		 }
		 
		 System.out.println(result.val);
	 }
	 
}
