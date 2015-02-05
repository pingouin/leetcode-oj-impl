package cn.com.pingouin.leet_code.oj.impl;

public class ReverseInteger {

	public static int reverse(int x) {
		// 最后再考虑负数
		boolean flag = false;
		if(x < 0) {
			// is minus
			flag = true;
			x = 0 - x;
		}
		
		String xString = String.valueOf(x);
		CharSequence charSequence = xString.subSequence(0, xString.length());
		
		// 把尾数的0去掉
		int offset = 0;
		for(int i=charSequence.length() - 1; i>=0; i--) {
			if("0".equals(charSequence.charAt(i))) {
				offset += 1;
			} else 
				break;
		}
		StringBuilder stringBuilder = new StringBuilder(charSequence.subSequence(0, charSequence.length() - offset));
		
		String trimString = stringBuilder.reverse().toString();
		
		// 判断是否overflow
		if(trimString.length() > 10) {
			return 0;
			
		} else if(trimString.length() == 10) {
			String finiteIntString = String.valueOf(2147483647);
			for(int i=0; i<10; i++) {
				int currentFiniteInt = Integer.parseInt(finiteIntString.substring(i, i+1));
				int currentTrimStringInt = Integer.parseInt(trimString.substring(i, i+1));
				// 逐位对比，大于就是overflow，小于就break
				if(currentFiniteInt > currentTrimStringInt) {
					break;
				} else if(currentFiniteInt < currentTrimStringInt) {
					return 0;
				}
			}
		}
		
		if(flag) {
			return 0 - Integer.parseInt(trimString);
		}
		return Integer.parseInt(trimString);
    }
	
	public static void main(String[] args) {
		int result = reverse(-2147483412);
		
		System.out.println(result);
	}
	
}
