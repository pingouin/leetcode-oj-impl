package cn.com.pingouin.leet_code.oj.impl;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	// 比如pwwkew，p作为一个子字符串，向后逐字符查询，p中不包含w，p+w
	// pw向后查询，pw包含w，则从包含对方的位置开始算新字符串，包括对方
	public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        
		char[] array = s.toCharArray();
		
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int currentLength = 0;
        
        for(int i=0, len=array.length; i<len; i++) {
        	currentLength++;
        	
        	// 若遇到了重复字符，且在当前字符串长度内，则从重复的位置获得新字符串长度
        	if(map.containsKey(array[i])) {
        		if((i - map.get(array[i])) < currentLength) {
        			currentLength = i - map.get(array[i]);
        		}
        	}
        	
        	// map中key是当前字符，value是位置，利用map不能重复key的特点，凡是重复的字符，它的位置总是靠后的那一个
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
