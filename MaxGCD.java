/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/remove-an-element-to-maximize-the-gcd-of-the-given-array/
//Approach :

// Create a prefix GCD array, and a postFix GCD array, for Example :
// A = [12, 15, 18]
// Prefix = [12, 3, 3] GCD of [12, 0] is 12, then [12, 15] is 3, then [3, 18] is 3
// Postfix = [12, 15, 18] => GCD of [18, 0] is 18, [18, 15] is 3, [3, 12] = 3
// prefix = [12, 3, 3]   Postfix = [3, 3, 18] , Question = [12, 15, 18]
// remove ith ekement from Question, then GCD would be => GCD(Prefix(i-1), postfix(i+1))


import java.io.*;
import java.util.*;

class MaxGCD {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases --> 0) {
		    int size = sc.nextInt();
		    int [] A = new int[size];
		    
		    for (int i = 0 ; i < size ; i++) {
		        A[i] = sc.nextInt();
		    }
		    
		    System.out.println(removedNum(A));
		}
	}
	
	public static int removedNum (int [] A) {
	    int len = A.length;
	    int [] B = new int[len];
	    int [] C = new int[len];

        int gcd = A[0];
        B[0] = gcd;
        for (int i = 1; i < len ; i++) {
            gcd = getGcd(gcd, A[i]);
            B[i] = gcd;
        }
        
        
        gcd = A[len-1];
        C[len-1] = gcd;
        for (int i = len-2; i >= 0 ; i--) {
            gcd = getGcd(gcd, A[i]);
            C[i] = gcd;
        }
        
    //     for (int i = 0 ; i < len ; i ++) {
//         	System.out.println(B[0] + " :: " + C[2]);
//         }
        
        //gcd = Integer.MIN_VALUE;
        for (int i = 0 ; i < len ; i ++) {
            int currGcd = Integer.MIN_VALUE;
            if (i == 0)
                currGcd = C[i +1 ];
            else if (i == len - 1)
                currGcd = B[i - 1];
            else
                currGcd = getGcd(B[i-1], C[i+1]);
                
            if (currGcd > gcd)
                gcd = currGcd;
        }
        
        return gcd;
	}
	
	public static int getGcd (int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }	   
        
        if (b == 0)
            return a;
        
        return getGcd(b, a%b);
	} 
}