package cn.com.pingouin.leet_code.oj.impl;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0, len=numbers.length; i<len; i++) {
            if (map.containsKey(numbers[i])) {
            	result[0] = i+1;
            	result[1] = map.get(numbers[i])+1;
                
                break;
            }
            else map.put(target-numbers[i], i);
        }

        Arrays.sort(result);
		
		return result;
    }
	
	public static void main(String[] args) {
		int[] numbers = {5, 25,75};
		int target = 100;
		
		int[] result = twoSum(numbers, target);
		
		System.out.println(result[0] + " @@@ " + result[1]);
	}
	
}
