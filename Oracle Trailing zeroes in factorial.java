// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
			
            Solution ob = new Solution();
            int ans  = ob.trailingZeroes(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int trailingZeroes(int N){
        int i = 1;
        int fives = 0;
        
        int pow = (int) Math.pow(5, i);
        while (pow <= N) {
            fives += N/pow;
            i++;
            pow = (int) Math.pow(5, i);
        }
        return fives;
    }
}