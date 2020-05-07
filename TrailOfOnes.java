//https://practice.geeksforgeeks.org/problems/trail-of-ones/0
// 
// Given a number N, find the number of binary strings of length N that contains consecutive 1's in them.
//  
// 
// Input
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
// The first line of each test case contains a positve integer N, denoting the length of the binary string.
// 
// 
// Output
// Print out the count of strings having consecutive 1's in them.
//  
// 
// Constraints
// 1 <= T <= 200
// 2 <= N <=30
// 
// 
// 
// Examples 
// 
// Input
// 3
// 2
// 5
// 15
// 
// Output
// 1
// 19
// 31171
// 
// 
// Expaination
// In the above first testcase there are 4 strings of length 2, the strings are 00, 01, 10 and 11. Only the string 11 has consecutive 1's.
//  
// 
// Expected Complexity
// Time: O(N)

// Approach
// Fibbonacchi series will give me all the permutations where we don't have all the ones together.
// We only need to subtract 2^x - fibbonacci series number. 

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases -- >  0) {
	        int n = sc.nextInt();
	        if (n == 1 )
	            System.out.println(0);
	        else if (n == 2)
	            System.out.println(1);
	        else{
	            int sum = 0;
	            int a = 2;
	            int b = 3;
	            int init = 3;
	            while (init <= n) {
	                int c = a+b;
	                a = b;
	                b = c;
	                if (init == n)
	                    sum = ((1 << n) - c);
	               
	               init++;     
	            }
	        
	            System.out.println (sum);
	        }
	    }
	 }
}