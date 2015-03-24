package cn.com.pingouin.leet_code.oj.impl;

/**
 * max_value 2147483647
 * min_value -2147483648
 * 
 *问题关键在于考虑边界
 *1. 去掉开头的空格
 *2. 第一个字符为正负号的情况
 *3. 遇到数字外的字符时的情况
 *4. 字符所代表的整数大于或小于边界
 *
 *对于第四个问题，如果result定义为int，传入2147483648这种大于边界的数时，所得结果会超过边界并改变符号，解决办法是将result类型改为double
 */

public class Atoi {

	public static int atoi(String str) {
		// result
		double result = 0;
		// 符号
		int result_sign = 1;
		
		// 为null
		if(str == null) {
			return (int) result;
		}
		// 字符串开始位置
		int strStartPos = 0;
		for(int i=0, len=str.length(); i<len; i++) {
			if(str.charAt(i) == ' ') {
				strStartPos ++;
			} 
			else break;
		}
		
		str = str.substring(strStartPos);
		
		// 长度为0
		if (str.length() == 0) {
			return (int) result;
		}
		
		strStartPos = 0;
		// 判断符号
		if (str.charAt(0) == '-') {
			result_sign = -1;
			strStartPos = 1;
		} else if (str.charAt(0) == '+') {
			strStartPos = 1;
		}
		
		str = str.substring(strStartPos);
		
		for(int i=0, len=str.length(); i<len; i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				result = result * 10 + (str.charAt(i) - '0');
			} 
			else break;
			
			// 整数大小边界情况
			if(i == 9) {
				// 比较大小需要用double类型，因为大小可能已越界
				// 数字长度超过10，直接return
				if(result_sign > 0) {
					if(result >= Integer.MAX_VALUE ) {
						return Integer.MAX_VALUE;
					}
					if(len > 10) {
						if(str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
							return Integer.MAX_VALUE;
						}
					}
				} else {
					if(result*result_sign <= Integer.MIN_VALUE ) {
						return Integer.MIN_VALUE;
					}
					if(len > 10) {
						if(str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
							return Integer.MIN_VALUE;
						}
					}
				}
			}
		}
		
		return (int) result * result_sign;
    }
	
	public static void main(String[] args) {
		String str = "2147483648";
		
		System.out.println(atoi(str));
	}
	
}
