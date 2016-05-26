package algorithms;


/*
You are given an array of size N and another integer M. 
Your target is to find the maximum value of sum of subarray modulo M.

Subarray is a continuous subset of array elements.

Note that we need to find the maximum value of (Sum of Subarray)%M , 
where there are N x (N+1)/2 possible subarrays.

For a given array A[] of size N, subarray is a contiguous segment 
from i to j where o <= i <= j <= N

Input Format: 
First line contains T , number of test cases to follow. Each test 
case consists of exactly 2 lines. First line of each test case contain 
2 space separated integers N and M, size of the array and modulo value M. 
Second line contains N space separated integers representing the elements of the array.

Output Format:
For every test case output the maximum value asked above in a newline.

Constraints: 
2 <= N <= 10^5
1 <= M <= 10^14
1 <= elements of the array <= 10^18
2 <= Sum of N over all test cases <= 500000 

Sample Input:
1
5 7
3 3 9 9 5

Sample Output:
6

Explanation:
Possible subarrays are: 
{3},{3},{9},{9},{5}
{3,3},{3,9},{9,9},{9,5}
{3,3,9},{3,9,9},{9,9,5}
{3,3,9,9},{3,3,9,9,5},{3,9,9,5}
their sums modulo 7 are:
3,3,2,2,5,6,5,4,0,1,0,2,3,1,5
respectively. 
Hence maximum possible sum taking Modulo 7 is 6 , and we can get 6 by adding 
first and second element of the array.
 */
public class Search_MaximizeSum {

}
