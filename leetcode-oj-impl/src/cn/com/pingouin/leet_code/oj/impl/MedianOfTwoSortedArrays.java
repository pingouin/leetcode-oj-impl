package cn.com.pingouin.leet_code.oj.impl;


public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
        double median = 0;
		
        int m = A.length;
        int n = B.length;
        
        int C[] = new int[m + n];
        
        int a = 0, b = 0, c = 0;
        // 无所谓m和n的大小，假设A包含z个大于B中所有数的元素，那么B中所有数都复制到C中，A剩下z个数，C中最后z个值为0
        while (a < m && b < n) {
			if(A[a] <= B[b]) C[c++] = A[a++];
			else C[c++] = B[b++];
		}
        
        // 按之前的假设，第二个for不开始，第一个循环z次
        for(int i=a; i<m; i++) {
        	C[c++] = A[a++]; 
        }
        for(int i=b; i<n; i++) {
        	C[c++] = B[b++]; 
        }
        
        // c为单数取中间，c为双数取中间两个的平均值
        if(c%2 != 0) median = C[c/2];
        else {
        	double medianSum = C[c/2] + C[c/2 - 1];
        	median = medianSum / 2; 
        }
        
		return median;
    }
	
	public static void main(String[] args) {
		int A[] = {};
		int B[] = {2, 3};
		
		double result = 
		findMedianSortedArrays(A, B);
		
		System.out.println(result);
	}
	
}
