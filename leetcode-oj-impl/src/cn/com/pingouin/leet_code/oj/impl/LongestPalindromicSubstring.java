package cn.com.pingouin.leet_code.oj.impl;


public class LongestPalindromicSubstring {

	static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int sLength = charArray.length;
        
        if(sLength <= 1) {
        	return s;
        }
        
        String result = "";
        int offset = 0;
        int iterLength = 0;
        
        // ����ͬʱoffset,������offset�͵�˫�����ȡsubstring
        for (int i = 0, mainLen=sLength-1; i < mainLen; i++) {
        	int left = i, right = i+1;
        	// ˫��
        	if(charArray[left] == charArray[right]) {
        		iterLength = Math.min(left, sLength - right - 1);
        		for(int j=1; j<=iterLength; j++) {
        			if(charArray[left - j] == charArray[right + j]) {
        				offset = j;
        			} else 
        				break;
        		}
        		if(result.length() < ( (offset + 1) << 1)) {
        			result = s.substring(left - offset, right + offset + 1);
        		}
        		offset = 0;
        	}
        	
        	// ����
        	if(left > 0) {
        		left--;
        		if (charArray[left] == charArray[right]) {
        			iterLength = Math.min(left, sLength - right - 1);
        			for(int j=1; j<=iterLength; j++) {
        				if(charArray[left - j] == charArray[right + j]) {
        					offset = j;
        				} else 
        					break;
        			}
        			// ��λ��������ȼ����ڼӼ�,��������
        			if(result.length() < ((offset + 1 << 1) + 1)) {
        				result = s.substring(left - offset, right + offset + 1);
        			}
        			offset=0;
        		}
        	}
		}
        
        return result;
    }
	
	public static void main(String[] args) {
	
		String result = longestPalindrome("ababababa");
		
		System.out.println(result);
		
	}
	
}
