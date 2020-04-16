//https://leetcode.com/problems/number-of-digit-one/solution/



public class Solution {
    public int solve(int A) {
        int n = A;
        int i = 1;
        int j = 0;
        int k = 0;
        int sum = 0;
        while (n > 0) {
            n = n/10;
            sum = sum + ((A/(10*i))*i + Math.min(Math.max((A%(10*i) - j + k), 0), i));
            if (j == 0) {
                j = 10;
                k = 1;
            }
            else
                j = j*10;
            
            i = i * 10;
        }
        
        return sum;
    }
}