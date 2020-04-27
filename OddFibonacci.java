// Odd Fibonacci
// 
// Problem Description
// 
// Given two integers A and B representing an interval [A, B].
// 
// Fibonacci sequence is a sequence whose definition is as follows:
// 
// F[1] = 1 , F[2] = 1
// 
// F[i] = F[i-1] + F[i-2] for i > 2
// 
// Your task is to find the count of integers x in the range [A, B] such that F[x] is odd.
// 
// 
// 
// Problem Constraints
// 
//     1 <= A <= 109
//     1 <= B <= 109
//     A <= B
// 
// 
// 
// Input Format
// 
// The first argument given is an integer A.
// 
// The second argument given is an integer B.
// 
// 
// 
// Output Format
// 
// Return the count of integers x in the range [A, B] such that F[x] is odd.
// 
// 
// Example Input
// 
// Input 1:
// 
//  A = 2
//  B = 6
// 
// Input 2:
// 
//  A = 6
//  B = 20
// 
// 
// 
// Example Output
// 
// Output 1:
// 
//  3
// 
// Output 2:
// 
//  10
// 
// 
// 
// Example Explanation
// 
// Explanation 1:
// 
//  All x and their F[x] values:
//     x = 2, F[x] = 1
//     x = 3, F[x] = 2
//     x = 4, F[x] = 3
//     x = 5, F[x] = 5
//     x = 6, F[x] = 8
//  From the above values only three values are odd.

// Approach:
// 1, 1, 2, 3, 5, 8
// in every 3 number we are having 2 odds and 1 even, just used this observation.

public class Solution {
    public int solve(int A, int B) {
        int pairs = (A-1)/3;
        int remainder = (A-1) - (3*pairs);
        int odd_tillA = (2*pairs) + remainder;
        
        int pairsB = B/3;
        int remainderB = B - (3*pairsB);
        int odd_tillB = (2*pairsB) + remainderB;
        return (odd_tillB - odd_tillA);
    }
}