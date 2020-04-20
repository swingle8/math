// A, B and Modulo
// Problem Description
// Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
// 
// 
// Problem Constraints
// 1 <= A, B <= 109
// A != B
// 
// 
// Input Format
// The first argument given is the integer, A.
// The second argument given is the integer, B.
// 
// 
// Output Format
// Return an integer denoting greatest possible positive M.
// 
// 
// Example Input
// Input 1:
// A = 1
// B = 2
// Input 2:
// A = 5
// B = 10
//  
// 
// 
// Example Output
// Output 1:
// 1
// Output 2:
// 5
//  
// 
// 
// Example Explanation
// Explanation 1:
// 1 is the largest value of M such that A % M == B % M.
// Explanation 2:
// For M = 5, A % M = 0 and B % M = 0.
// 
// No value greater than M = 5, satisfies the condition.
//  
// Approach
//A%M = B%M
// 11%10 = 1 ; 21%10 = 1
// 12%10 = 2 ; 22%10 = 2
// B = A + nM 
// M = (A - B)/n ; for M to be maximum, n should be minimum = 1 and A - B should be max.
// Hence, we only need to calculate A - B where A > B or B - A where B > A


public class ABMudulo {
    public int solve(int A, int B) {
        if (A > B)
            return A-B;
        else
            return B-A;
    }
}
