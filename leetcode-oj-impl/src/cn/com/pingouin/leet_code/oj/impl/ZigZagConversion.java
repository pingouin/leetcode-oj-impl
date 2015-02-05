package cn.com.pingouin.leet_code.oj.impl;

public class ZigZagConversion {

	public static String convert(String s, int nRows) {
		// 极端情况就是1行，字符串长度1或2，result也就是本身；或者行数大于字符串长度，后面if时规避
		if(1 == nRows || s.length() == 0 || s.length() == 1 || s.length() == 2) {
        	return s;
        }
		
		// 第一行
        StringBuilder startStringBuilder = new StringBuilder();
        // 最后一行
        StringBuilder endStringBuilder = new StringBuilder();
        // 中间行
        StringBuilder midStringBuilder = new StringBuilder();
		
        char[] charArray = s.toCharArray();
        int sLength = s.length();
        
        int stepZig = nRows; // 竖着几排
        int stepZag = nRows - 2; // 斜着几排
        int step = (nRows << 1) - 2; // 从左往右看第n竖排和第n+1竖排的和，总是n*step
        
        // 第一行
        int pos = 0;
        while(pos < sLength) {
        	//
        	startStringBuilder.append(charArray[pos]);
        	
        	pos += step;
        }
        
        // 最后一行
        pos = stepZig - 1;
        while(pos < sLength) {
        	//
        	endStringBuilder.append(charArray[pos]);
        	
        	pos += step;
        }
        
        // 中间行
        int currentRow = 0;
        while(currentRow < stepZag) {
        	pos = currentRow + 1;
        	int factor = step;
        	
        	while(pos < sLength) {
        		//
        		midStringBuilder.append(charArray[pos]);
        		
        		pos = factor - pos;
        		factor = factor + step;
        	}
        	
        	currentRow += 1;
        }
        
        return startStringBuilder.toString() + midStringBuilder.toString() + endStringBuilder.toString();
    }
	
	public static void main(String[] args) {
		
		String result = convert("PAYPALISHIRING", 3);
		
		System.out.println(result);
	}
	
}
