//https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
// Now to figure out the trailing number of zeros in the factorial of a number. We need to understand that trailing zeros can 
// be formed by the multiple of 5 and 2. Since we know that the multiple of 2 are far more than the multiple of 5. Hence,
// we only need to figure out how many number of times 5 come till N.
// Let's say N is 20, then 20/5 = 4 how?
// 1 2 3 4 "5" 6 7 8 9 (10 = 2 * 5) 11 12 13 14 (15 = 3 * 5) 16 17 18 19 (20 = 5 * 4) => % comes 4 times
// Lets say n is 26
// 1 2 3 4 "5" 6 7 8 9 (10 = 2*5) 11 12 13 14 (15 = 3*5) 16 17 18 19 (20 = 4*5) 21 22 23 24 (25 = 5*5) 26 = 6   


class Solution {
    public int trailingZeroes(int n) {
        long num = 5;
        int ans = 0;
        while (num <= n) {
            System.out.println(num);
            long times = n/num;
            ans = ans + (int) times;
            num = num * 5;
        }
        return ans;
    }
}