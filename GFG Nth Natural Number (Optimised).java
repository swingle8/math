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
        if (N <= 0)
            return 0;
        return convertToBase9 (N);
    }
    
    long convertToBase9 (long N) {
        String sb = "";
        while (N > 0) {
            long rem = N%9;
            N = N/9;
            sb = rem + sb;
        }
        
        if (sb == "")
            return N;
        return Long.parseLong(sb);
    }
}