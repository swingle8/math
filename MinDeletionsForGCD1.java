//If the GCD of initial array is 1, then we can respond with 0 because we don't need to delete any element from the array.
// However, if the initial GCD of array is 'x' then if you delete number of elements it won't reach 1.

//Example: [2, 3, 6] , GCD = 1
// [2, 3]  = 1
//[2, 4, 8, 10], GCD = 2

https://www.geeksforgeeks.org/minimum-deletions-required-to-make-gcd-of-the-array-equal-to-1/


import java.io.*;
import java.util.*;

public class MinDeletionsForGCD1 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		while (cases --> 0) {
		    int arrSize = sc.nextInt();
		    int [] arr = new int[arrSize];
		    
		    for (int i = 0 ; i < arrSize ; i++) {
		        arr[i] = sc.nextInt();
		    }
		    
		    System.out.println(getMin(arr));
		}
	}
	
	public static int getMin (int [] A) {
	    int len = A.length;
	    
	    int gcd = A[0];
	    for (int i = 1 ; i < len ; i ++) {
	        gcd = getGcd(gcd, A[i]);
	        
	        if (gcd == 1)
	        	return 0;
	    }
	    
	    if (gcd > 1)
	        return -1
	        
	    return 0;
	  
	}
	
	public static int getGcd (int A, int B) {
	    if (A < B) {
	        int temp = B;
	        B = A;
	        A = temp;
	    }
	    
	    if (B == 0)
	        return A;
	       
	   return getGcd(B, A%B);
	}
}