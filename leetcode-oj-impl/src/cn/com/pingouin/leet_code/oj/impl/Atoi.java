package cn.com.pingouin.leet_code.oj.impl;

/**
 * max_value 2147483647
 * min_value -2147483648
 * 
 *����ؼ����ڿ��Ǳ߽�
 *1. ȥ����ͷ�Ŀո�
 *2. ��һ���ַ�Ϊ�����ŵ����
 *3. ������������ַ�ʱ�����
 *4. �ַ���������������ڻ�С�ڱ߽�
 *
 *���ڵ��ĸ����⣬���result����Ϊint������2147483648���ִ��ڱ߽����ʱ�����ý���ᳬ���߽粢�ı���ţ�����취�ǽ�result���͸�Ϊdouble
 */

public class Atoi {

	public static int atoi(String str) {
		// result
		double result = 0;
		// ����
		int result_sign = 1;
		
		// Ϊnull
		if(str == null) {
			return (int) result;
		}
		// �ַ�����ʼλ��
		int strStartPos = 0;
		for(int i=0, len=str.length(); i<len; i++) {
			if(str.charAt(i) == ' ') {
				strStartPos ++;
			} 
			else break;
		}
		
		str = str.substring(strStartPos);
		
		// ����Ϊ0
		if (str.length() == 0) {
			return (int) result;
		}
		
		strStartPos = 0;
		// �жϷ���
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
			
			// ������С�߽����
			if(i == 9) {
				// �Ƚϴ�С��Ҫ��double���ͣ���Ϊ��С������Խ��
				// ���ֳ��ȳ���10��ֱ��return
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
