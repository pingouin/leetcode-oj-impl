package cn.com.pingouin.leet_code.oj.impl;


public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
        double median = 0;
		
        int m = A.length;
        int n = B.length;
        
        int C[] = new int[m + n];
        
        int a = 0, b = 0, c = 0;
        while (a < m && b < n) {
			if(A[a] <= B[b]) C[c++] = A[a++];
			else C[c++] = B[b++];
		}
        
        for(int i=a; i<m; i++) {
        	C[c++] = A[a++]; 
        }
        for(int i=b; i<n; i++) {
        	C[c++] = B[b++]; 
        }
        
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
