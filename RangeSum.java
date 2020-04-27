// Range Sum
// 
// Problem Description
// 
// Given two integers A and B such that A <= B.
// 
// A Function F is defined as follows:
// 
// F[0] = 0
// F[1] = 1
// F[n] = F[n-1] + F[n-2]; n > 1
// 
// Function S(A, B) = F[A] + F[A+1] + F[A+2] + ... + F[B].
// 
// Find and return S(A, B) modulo (109+7).
// 
// 
// 
// Problem Constraints
// 
// 0 <= A <= B <= 109
// 
// 
// Input Format
// 
// The arguments given are two integers A and B.
// 
// 
// Output Format
// 
// Return an integer denoting the value of S(A, B) modulo (109+7).
// 
// 
// Example Input
// 
// Input 1:
// 
//  A = 0
//  B = 3
// 
// Input 2:
// 
//  A = 3
//  B = 4
// 
// 
// 
// Example Output
// 
// Output 1:
// 
//  4
// 
// Output 2:
// 
//  5
// 
// 
// 
// Example Explanation
// 
// Explanation 1:
// 
//  F(0) = 0, F(1) = 1, F(2) = 1, F(3) = 2.
//  S(0, 3) = F(0) + F(1) + F(2) + F(3) = 0 + 1 + 1 + 2 = 4.
// 
// Explanation 2:
// 
//  F(3) = 2, F(4) = 3.
//  S(3, 4) = F(3) + F(4) = 2 + 3 = 5.
// 

// Approach
// Find the Fibbonacci number at Nth index in O(log n) using Matrix.
// then S(N) = A(N+2) - A(1); 



public class Solution {
    //long [][] Mat = new long[][]{{1,1},{1,0}};
    long mod = 1000000007;
    public int solve(int A, int B) {
        
        long sum = 0;
        long [][] Mat = new long[][]{{1,1},{1,0}};
        getNum(Mat, B+1);
        long sumB = Mat[0][0] - 1;
        //System.out.println("sumB = " + sumB);
        Mat = new long[][]{{1,1},{1,0}};
        if (A > 1)
            getNum(Mat, A);
        else
            return (int)sumB;
       
        long sumA = Mat[0][0] - 1; 
        //System.out.println("sumA = " + sumA);
        sum = (sumB - sumA)%mod;
        sum = (sum + mod)%mod;
        return (int)sum;
    }
    
    public void getNum(long [][] Mat, int x) {
        if (x == 0 || x == 1)
            return;
         
        getNum(Mat, x/2);
        getMultiple(Mat, Mat);
        
        if (x%2 != 0) {
            long [][] original = new long[][]{{1,1},{1,0}};
            getMultiple(Mat, original);
        }
        
    }
    
    public void getMultiple (long [][] Mat, long [][] Mat2) {
        long x =  (Mat[0][0]*Mat2[0][0] + Mat[0][1]*Mat2[1][0])%mod; 
        long y =  (Mat[0][0]*Mat2[0][1] + Mat[0][1]*Mat2[1][1])%mod; 
        long z =  (Mat[1][0]*Mat2[0][0] + Mat[1][1]*Mat2[1][0])%mod; 
        long w =  (Mat[1][0]*Mat2[0][1] + Mat[1][1]*Mat2[1][1])%mod; 
      
        Mat[0][0] = x; 
        Mat[0][1] = y; 
        Mat[1][0] = z; 
        Mat[1][1] = w;
    } 
}
