package cn.com.pingouin.leet_code.oj.impl;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	// 思路是将数组内数字和目标值的差值存到map中，然后循环时寻找当前值是否在map内，在的话就说明相加可得目标值，只需找到一对符合要求的值
	// 利用了map寻找任意位置的内容时间消耗相同的特点
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
