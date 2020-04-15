//https://leetcode.com/problems/next-permutation/



public class Solution {
    public int[] nextPermutation(int[] A) {
        int len = A.length;
        //int prev = A[len-1];
        int index = -1;
        //int num = -1;
        for (int i = len-1 ; i > 0 ; i--) {
            int prev = A[i];
            int elem = A[i-1];
            if (prev > elem) {
                index = i-1;
                break;
            }
        }
        // System.out.println(len);
        
        // System.out.println(index);
        if (index != -1) {
            for (int i = len-1 ; i > index ; i --) {
                if (A[index] < A[i]) {
                    int temp = A[i];
                    A[i] = A[index];
                    A[index] = temp;
                    break;
                } 
            }
            int i = index+1;
            int j = len-1;
            while (i < j) {
            A[i] = A[i] + A[j];
            A[j] = A[i] - A[j];
            A[i] = A[i] - A[j];
            i++;
            j--;
            }
            return A;
            
        }
        
        int i = 0;
        int j = len-1;
        while (i < j) {
            A[i] = A[i] + A[j];
            A[j] = A[i] - A[j];
            A[i] = A[i] - A[j];
            i++;
            j--;
        }
        return A;
    }
}
