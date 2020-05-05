//https://practice.geeksforgeeks.org/problems/finding-position/0
Finding Position
// Some people are standing in a queue. A selection process follows a rule where people standing on even positions are selected. Of the selected people a queue is formed and again out of these only people on even position are selected. This continues until we are left with one person. Find out the position of that person in the original queue.
// 
// Input:
// The first line of input contains an integer T denoting the number of test cases.The first line of each test case is N,number of people standing in a queue.
// 
// Output:
// Print the position(original queue) of that person who is left.
// 
// Constraints:
// 1 <= T <= 103
// 1 <= N <= 108
// 
// Example:
// Input:
// 2
// 5
// 9
// Output:
// 4
// 8
// 
// Approach :
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40  41
// 
// 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40
// 
// 4 8 12 16 20 24 28 32 36 40
// 
// 8 16 24 32 40
// 
// 16 32
// 
// 32
// 
// There is a pattern for every new iteration, the pattern starts from 2^(new iteration) and answer is the greatest
// power of 2 that exist in the Array.


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
            System.out.println(queueN(n));
            T--;
        }
	 }
	 
	 public static int queueN (int N) {
	    int newNum = 2;
	    while (newNum * 2 < N) {
	        newNum = newNum * 2;
	    }
	    
	    return newNum;
	 }
}