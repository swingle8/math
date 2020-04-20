//https://leetcode.com/problems/consecutive-numbers-sum/submissions/
// Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
// 
// Example 1:
// 
// Input: 5
// Output: 2
// Explanation: 5 = 5 = 2 + 3
// Example 2:
// 
// Input: 9
// Output: 3
// Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
// Example 3:
// 
// Input: 15
// Output: 4
// Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
// Note: 1 <= N <= 10 ^ 9.
// Approach

// n  = A									: n = A
// n + n - 1 = A							: 2n - 1 = A
// n + n - 1 + n - 2 = A					: 3n - 3 = A
// n + n - 1 + n - 2 + n - 3 = A			: 4n - 6 = A
// n + n - 1 + n - 2 + n - 3 + n -4 = A		: 5n - 10 = A
// Applied the above derived formulae.


class Solution {
    public int consecutiveNumbersSum(int A) {
        int ans = 1;
        int sum = 1;
        int multiple = 2;
       
        while (multiple < A) {
             int n = 0;
            if ((A + sum)%multiple == 0) {
                ans++;
            }
            
            n = ((A + sum)/multiple);
            if (n - multiple - 1 < 0)
                break;
            
            sum = sum + multiple;
            multiple++;
            
        }
        
        return ans;
        
    }
}