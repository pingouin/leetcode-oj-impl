package cn.com.pingouin.leet_code.oj.impl;

/**
 * 需要考虑的是reverse之后是否会overflow
 * 使用一位一位转移到reverseNum的方法
 * 剩最后一位不转移，这样就不会因为溢出变成别的数，传进来的也是整数，不会本身溢出
 * 最后判断的时候，判断n-1位，留一位单独判断
 */

public class PalindromeNumber {

	private static boolean isPalindrome(int x) {
		
		// 负数返回false
		if(x < 0) return false;
		
		int num = x;
		int reverseNum = 0;
		
		// 需要大于等于，否则1001这种数字无法通过
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
