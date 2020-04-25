// Problem Description
// 
// Groot has an array A of size N. Boring right? Groot thought so too, so he decided to construct another array B of the same size and defined elements of B as:
// 
// B[i] = factorial of A[i] for every i such that 1<= i <= N.
// 
// factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
// 
// Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non empty set of prime factors.
// 
// Since the number can be very large, return it modulo 109 + 7.
// 
// NOTE: A set is a data structure having only distinct elements. Eg : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}
// 
// 
// 
// Problem Constraints
// 
// 1 <= N <= 105
// 1 <= A[i] <= 106
// Your code will run against a maximum of 5 test cases.
// 
// 
// Input Format
// 
// Only argument is an integer array A of size N.
// 
// 
// Output Format
// 
// Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 109+7.
// 
// 
// Example Input
// 
// Input 1:
// 
//  A = [2, 3, 2, 3]
// 
// Input 2:
// 
//  A = [2, 3, 4]
// 
// 
// 
// Example Output
// 
// Output 1:
// 
//  6
// 
// Output 2:
// 
//  4
// 
// 
// 
// Example Explanation
// 
// Explanation 1:
// 
//  Array B will be : [2, 6, 2, 6]
//  The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
// 
// Input 2:
// 
//  Array B will be : [2, 6, 24]
//  The total possible subsequences are 4 : [2], [6], [24], [6, 24].
// 
// 
//Approach :
// 2! = 1 * 2
// 3! = 1 * 2 * 3
// we have to figure those number having same common prime factor. if there is no prime number between x and y
// then the factorial of x and y will have the same prime factors.
// Now after fetching out the group of numbers having same prime factors then we need to add (2^n -1)
// basically, from each group we need to figure all not repeated combinations that is
// nc1 + nc2 + nc3 + ... + ncn
// According to Binomila Theoram :
// (1 + x)^n  = (nc1)x^1 + (nc2)x^2 + ..
// (1 + 1)^n = nc1 + nc2 + nc3 + ..
//2^n -1      


public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int max = A[len-1];
        
        int [] prime = getPrime(max);
        
        int k = prime.length-1;
        int count = 0;
        int ans = 0;
        
        for (int i = len-1 ; i >= 0 ; i--) {
            if (k < 0) {
                break;
            }
            int num = prime[k];
            if (num <= A[i]) {
                count++;
            }
            else {
                k--;
                if (count > 0)
                    ans = ans + (int) (Math.pow(2, count) - 1);
                count = 0;
                i++;
            }
        }
        
        if (count > 0) {
            ans = ans + (int) (Math.pow(2, count) - 1);
        }
        return ans;
    }
    
    public int [] getPrime (int n) {
        boolean [] all = new boolean[n];
        all[0] = true;

        for (int i=1 ; i < n ; i++) {
            int num = i+1;
            if (!all[i]) {
                int next = num+num;
                while (next <= n) {
                    if (next%num == 0 && !all[next-1])
                        all[next-1] = true;
                    next = next + num;
                }
            }
                
        }

        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            if (! all[i]) {
                
                count++;
            }
        }

        int [] prime = new int[count];
        int k = 0;
        for (int i = 0; i < n ; i++) {
            if (! all[i]) {
                prime[k] = i+1;
                k++;
            }
        }
        
        return prime;
    }
}
