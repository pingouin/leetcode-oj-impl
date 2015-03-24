package cn.com.pingouin.leet_code.oj.impl;

/**
 * ��Ҫ���ǵ���reverse֮���Ƿ��overflow
 * ʹ��һλһλת�Ƶ�reverseNum�ķ���
 * ʣ���һλ��ת�ƣ������Ͳ�����Ϊ�����ɱ��������������Ҳ�����������᱾�����
 * ����жϵ�ʱ���ж�n-1λ����һλ�����ж�
 */

public class PalindromeNumber {

	private static boolean isPalindrome(int x) {
		
		// ��������false
		if(x < 0) return false;
		
		int num = x;
		int reverseNum = 0;
		
		// ��Ҫ���ڵ��ڣ�����1001���������޷�ͨ��
		while(num >= 10) {
			reverseNum *= 10;
			
			reverseNum += num % 10;
			
			num /= 10;
		}
		
		return reverseNum == x/10 && num == x%10 ;
	}
	
	public static void main(String[] args) {
		int x = 1001;
		
		System.out.println(isPalindrome(x));
	}
	
}
