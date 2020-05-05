// Number of Groups
// Given an array Arr[] of N distinct integers. Write a program to find the count of groups of 2 or 3 integers that can be formed by choosing integers from the given array such that sum of integers in each of the group is divisible by three.
// 
// Input:
// First line of input contains a single integer T which denotes the number of test case. Then T test case follows. First line of each test case contains a single integer N which denotes number of elements in the array. Second line of each test case contains N space separated integers.
// 
// Output:
// For each test case, print the count of all the groups of 2 or 3 integers formed from the given array such that sum of elements in the group is divisible by 3.
// 
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 105
// 1 <= Arr[i] <= 105
// 
// Example:
// Input:
// 2
// 6
// 1 5 7 2 9 14
// 4
// 3 6 9 12
// Output:
// 13
// 10

// Approach - 
// the remainder of any number with 3 would either 0, 1, 2
// Now the number with 0 as a reminder is sufficient enough to make pairs with another number having 0 reminder
// the number with 1 as a reminder will need number having 2 as a reminder to make pairs.
// hence, If we can count the number of numbers having reminder as 0, 1, 2 then we can easily count the combinations.

// Here First we have stored the count of 0, 1, 2 reminders in count Array.
// then we used permutations to count the pairs.  

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	  Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(NumberOfGroups(arr, n));
            T--;
        }
	 }
	 
	 public static int NumberOfGroups (int [] A, int N) {
	     int [] count = new int[3];
	     for (int i = 0 ; i < N ; i ++)
	        count[A[i]%3]++;
	   
	     int sum = ((count[0]) * (count[0] - 1) * (count[0] - 2))/6;
	     sum = sum + (count[0] * count[1] * count[2]);
	     sum = sum + (((count[1]) * (count[1] - 1) * (count[1] - 2))/6);
	     sum = sum + (((count[2]) * (count[2] - 1) * (count[2] - 2))/6);
	     sum = sum + ((count[0] * (count[0] - 1)) / 2);
	     sum = sum + (count[1] * count[2]);
	     
	     return sum;
	     
	     
	 }
}