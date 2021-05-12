// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    
// } Driver Code Ends


//User function Template for Java

class Solution {
    long findNth(long N) {
        long num = 1;
        long index = 1;
        while( index <= N) {
            if (contains(num, 9)) {
                num++;
                continue;
            }
            
            num++;
            index++;
            
        }
        return num-1;
    }
    
    boolean contains (long num, int n) {
        while (num > 0) {
            long last = num%10;
            num = num/10;
            if (last == n)
                return true;
        }
        return false;
    }
}