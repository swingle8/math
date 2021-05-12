// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        int rem = numerator%denominator;
        StringBuilder ans = new StringBuilder();
        ans.append (String.valueOf(numerator/denominator));
        if (rem == 0)
            return ans.toString();
        
        //String decimal = "";
        int index = 0;
        //int dotIndex= 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (rem > 0 && ! map.containsKey(rem)) {
            ans.append(".");
            index = ans.length()-1;
        }
        while (rem > 0 && ! map.containsKey(rem)) {
            map.put(rem, ++index);
            numerator = rem*10;
            rem = numerator%denominator;
            int val = numerator/denominator;
            ans.append (String.valueOf(val));
        }
        
        if (rem == 0)
            return ans.toString();
        
        if (map.containsKey(rem)) {
            int Currindex = map.get(rem);
            ans.insert(Currindex, '(');
            ans.append(')');
        }
        
        return ans.toString();
    }
}