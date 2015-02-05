package cn.com.pingouin.leet_code.oj.impl;

public class ZigZagConversion {

	public static String convert(String s, int nRows) {
		// �����������1�У��ַ�������1��2��resultҲ���Ǳ����������������ַ������ȣ�����ifʱ���
		if(1 == nRows || s.length() == 0 || s.length() == 1 || s.length() == 2) {
        	return s;
        }
		
		// ��һ��
        StringBuilder startStringBuilder = new StringBuilder();
        // ���һ��
        StringBuilder endStringBuilder = new StringBuilder();
        // �м���
        StringBuilder midStringBuilder = new StringBuilder();
		
        char[] charArray = s.toCharArray();
        int sLength = s.length();
        
        int stepZig = nRows; // ���ż���
        int stepZag = nRows - 2; // б�ż���
        int step = (nRows << 1) - 2; // �������ҿ���n���ź͵�n+1���ŵĺͣ�����n*step
        
        // ��һ��
        int pos = 0;
        while(pos < sLength) {
        	//
        	startStringBuilder.append(charArray[pos]);
        	
        	pos += step;
        }
        
        // ���һ��
        pos = stepZig - 1;
        while(pos < sLength) {
        	//
        	endStringBuilder.append(charArray[pos]);
        	
        	pos += step;
        }
        
        // �м���
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
