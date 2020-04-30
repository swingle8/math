// Lucky Numbers
// A lucky number is a number which has exactly 2 distinct prime divisors. You are given a number N and you need to determine the count of lucky numbers between the range 1 to N (both inclusive). Input
// The first argument contains one integer number N (1 ≤  N  ≤ 5000).
// Output
// Return an integer i.e the count of lucky numbers between 1 and N, both inclusive.
// Examples Input
// 8
// Output
// 1 
// Explanation Testcase 1-
// Between [1,8] there is only 1 lucky number i.e 6


//Approach :
// In a array till N let's say count of all numbers having prime numbers as divisor is 0.
// Also, suppose all numbers have 0 prime number divisors as Prime mnumber itself.
// Since 1 is not a prime number, Let's iterate from 2 that is from index 1.
// increase the counter of all the numbers which are divisible by this prime number.
// After completing above with all prime numbers, let's iterate again in the array count only those whose count is 2.   

 
public class Solution {
    public int solve(int A) {
        int [] sieve = new int[A];
        for (int i = 1 ; i < A ; i ++) {
            int num = i+1;
            if (sieve[i] == 0) {
                for (int j = num+num-1 ; j < A ; j=j+num) {
                    sieve[j]++;
                }
            }
        }
        
        
        int ans = 0;
        for (int i = 0 ; i < A ; i++) {
            if (sieve[i] == 2)
                ans++;
        }
        
        return ans;
    }
}