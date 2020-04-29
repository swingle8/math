// Sorted Permutation Rank
// 
// Problem Description
// 
// Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
// Assume that no characters are repeated.
// 
// Note: The answer might not fit in an integer, so return your answer % 1000003
// 
// 
// 
// Problem Constraints
// 
// 1 <= len(A) <= 1000
// 
// 
// Input Format
// 
// First argument is a string A.
// 
// 
// Output Format
// 
// Return an integer denoting the rank of the given string.
// 
// 
// Example Input
// 
// Input 1:
// 
// A = "acb"
// 
// 
// 
// Example Output
// 
// Output 1:
// 
// 2
// 
// 
// 
// Example Explanation
// 
// Explanation 1:
// 
// Given A = "acd".
// The order permutations with letters 'a', 'c', and 'b' : 
// abc
// acb
// bac
// bca
// cab
// cba
// So, the rank of A is 2.

//Approach : 

// Find the characters smaller than xth character in the string and multiply it with the factorial of N-x+1!
// VIEW : sorted string : EIVW
// the characters smaller then V are 2 (E,I) for E we can have 3! number of strings like 
// EIVW
// EIWV
// EVIW
// EVWI
// EWIV
// EWVI

//similarly, when I comes first we will have 3! number of strings = 2*3!
// Let's remove V from the given string  = IEW and similarly to above find all the permutations of I and add them up.









public class Solution {
    public int findRank(String A) {
        int ans = 0;
        int len = A.length();
        for (int i = 0 ; i < len ; i++)
            ans = ans + rank(A.substring(i, len));
        
        ans++;
        ans = ans%1000003;
        return (int)ans;
    }
    
    public int rank (String A) {
        long len = A.length();
        String B = A;
        char tempArray[] = B.toCharArray();
        Arrays.sort(tempArray);
        
        long fact = 1;
        for (int i = 1 ; i < len ; i ++) {
            fact = (fact*i)%1000003;
        }
        
        int curr = A.charAt(0);
        int greater = 0;
        for (int  i = 0 ; i < len ; i++) {
            if (tempArray[i] < curr)
                greater++;
            else
                break;
        }
        
        long ans = (greater * fact)%1000003;
        return (int)ans;
    }
}
