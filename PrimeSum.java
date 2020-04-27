// Prime Sum
// 
// Problem Description
// 
// Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
// 
// If there are more than one solutions possible, return the lexicographically smaller solution.
// 
// If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
// [a, b] < [c, d], If a < c OR a==c AND b < d. 
// 
// NOTE: A solution will always exist. Read Goldbach's conjecture.
// 
// 
// 
// Problem Constraints
// 
// 4 <= A <= 2*107
// 
// 
// Input Format
// 
// First and only argument of input is an even number A.
// 
// 
// Output Format
// 
// Return a integer array of size 2 containing primes whose sum will be equal to given number.
// 
// 
// Example Input
// 
//  4
// 
// 
// 
// Example Output
// 
//  [2, 2]
// 
// 
// 
// Example Explanation
// 
//  There is only 1 solution for A = 4.
//  
//  Approach :
// check all the numbers till N. Lets say we are at x number so, X and N-X both must be prime.




public class Solution {
    public int[] primesum(int A) {
        int [] arr = new int [2];
        for (int i = 2 ; i < A ; i ++) {
            if (isPrime(i) && isPrime(A-i)) {
                arr[0] = i;
                arr[1] = (A-i);
                return arr;
            }
        }
        
        return arr;
    }
    
    public boolean isPrime (int num) {
        int sqrt =  (int)Math.sqrt(num);
        for (int i = 2 ; i <= sqrt ; i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }
}