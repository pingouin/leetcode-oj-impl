package cn.com.pingouin.leet_code.oj.impl;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        
		char[] array = s.toCharArray();
		
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int currentLength = 0;
        
        for(int i=0, len=array.length; i<len; i++) {
        	currentLength++;
        	
        	if(map.containsKey(array[i])) {
        		if((i - map.get(array[i])) < currentLength) {
        			currentLength = i - map.get(array[i]);
        		}
        	}
        	
        	map.put(array[i], i);
        	
        	length = length>currentLength ? length : currentLength;
        }
        
		return length;
    }
	
	public static void main(String[] args) {
		String str = "pwwkew";
		
		int length = lengthOfLongestSubstring(str);
		
		System.out.println(length);
	}
	
}
