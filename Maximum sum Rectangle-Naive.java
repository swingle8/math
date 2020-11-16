//https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0#
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases -- > 0) {
	    
	        int rows = sc.nextInt();
	        int cols = sc.nextInt();
	        int [][] mat = new int [rows][cols];
	        for (int i = 0 ; i < rows ; i++)
	            for (int j = 0 ; j < cols ; j++)
	                mat[i][j] = sc.nextInt();
	        
	        int max = 0;
	        for (int i = 0 ; i < rows ; i++) {
	            for (int j = 0 ; j < cols ; j++) {
	                
	                int [][] sum = new int [rows][cols];

	                for (int k = i ; k < rows ; k++) {
	                    int prev = 0;
	                    for (int l = j ; l < cols ; l++) {
	                        if (k == 0) {
	                           sum[k][l] = mat[k][l];
	                        }
	                       else {
	                           sum[k][l] = mat[k][l] + sum[k-1][l];
	                       }
	                       prev = prev + sum[k][l];
	                       max = Math.max (max, prev); 
	                        
	                    }
	                }
	            }
	        }
	        System.out.println(max);
	        
	    }
	 }
}