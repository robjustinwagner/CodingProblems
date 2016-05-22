package algorithms;

import java.util.HashMap;

/*
Sherlock and Array
==================

PROBLEM:
Watson gives Sherlock an array A of length N. Then he asks him to determine if 
there exists an element in the array such that the sum of the elements on its 
left is equal to the sum of the elements on its right. If there are no elements 
to the left/right, then the sum is considered to be zero. 

Formally, find an i, such that, A1 + A2 + ... + Ai-1 = Ai+1 + Ai+2 + An.

Input Format 
The first line contains T, the number of test cases. For each test case, the first 
line contains N, the number of elements in the array A. The second line for each test 
case contains N space-separated integers, denoting the array A.

Output Format 
For each test case print YES if there exists an element in the array, such that 
the sum of the elements on its left is equal to the sum of the elements on its right; 
otherwise print NO.

Constraints 
1 <= T <= 10
1 <= N <= 10^5
1 <= Ai <= 2*(10^4)
1 <= i <= N  

Sample Input
2
3
1 2 3
4
1 2 3 3

Sample Output
NO
YES

Explanation 
For the first test case, no such index exists. 
For the second test case, A[1] + A[2] = A[4], therefore index 3 satisfies the given conditions. 

https://www.hackerrank.com/challenges/sherlock-and-array
@author	rob.wagner
*/

import java.util.Scanner;

public class Search_SherlockAndArray {

	private static Scanner stdIn;
	private static HashMap<Integer, Integer[]> testMap;
	
	private final static String BALANCED = "YES";
	private final static String NOT_BALANCED = "NO";
	
	public static void main(String[] args){
		
		stdIn = new Scanner(System.in);
		testMap = new HashMap<Integer, Integer[]>();
		
		//handle parsing
		int T = stdIn.nextInt();	//number of tests
		for(int testCaseNumber = 1; testCaseNumber <= T; testCaseNumber++){
			parseArray(testCaseNumber);
			Integer[] A = testMap.get(testCaseNumber);
			String message = NOT_BALANCED;
			// A cannot be null, and must be greater than 1 element in length
			if( A != null && A.length >= 1)
			{
				message = isArrayBalanced(A, 0, A.length-1, A[0], A[A.length-1]);		
			}
			System.out.println(message);
		}
	}
	
	//NOTE: keeping modular for future unit testing
	
	private static void parseArray(int testCaseNumber){
		//parse TC into int[] / HashMap
		Integer testCaseLen = stdIn.nextInt();
		Integer[] A = new Integer[testCaseLen];
		for (int i = 0; i < testCaseLen; i++){
			A[i] = stdIn.nextInt();
		}
		testMap.put(Integer.valueOf(testCaseNumber), A);
	}
	
	/* 
	 * Two pointers to end indices of array, recurse until difference is two; check if sums are equal.
	 */
	private static String isArrayBalanced(Integer[] A, int ptrL, int ptrR, int valL, int valR){

		//array is of length 1, and is considered to always be balanced.
		if(ptrL == ptrR){
			return BALANCED;
		}
		
		int difference = ptrR - ptrL;
		//converged on two parts of array
		if(difference == 2){
			return (valL == valR) ? BALANCED : NOT_BALANCED;
		}
		//array is of length 2, and can never be balanced
		else if(difference == 1){
			return NOT_BALANCED;
		}
		//else, we aren't done recursing yet
		else{
			return (valL >= valR) ? 
					isArrayBalanced(A, ptrL, --ptrR, valL, valR+A[--ptrR]) :
					isArrayBalanced(A, ++ptrL, ptrR, valL+A[++ptrL], valR);
		}
	}
	
}
