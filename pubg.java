//Pubg

//Problem Description

//There are N players each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game and the game continues in the same manner among other players until only 1 survivor remains.

//Can you tell the minimum health last surviving person can have?

//Input 1:

// A = [6, 4]

//Input 2:

 //A = [2, 3, 4]



//Example Output

//Output 1:

// 2

//Output 2:

// 1

// 
// 
// # Example Explanation
// # 
// # Explanation 1:
// # 
// #  Given strength array A = [6, 4]
// #  Second player attack first player, A =  [2, 4]
// #  First player attack second player twice. [2, 0]
// # 
// # Explanation 2:
// # 
// #  Given strength array A = [2, 3, 4]
// #  First player attack third player twice. [2, 3, 0]
// #  First player attack second player. [2, 1, 0]
// #  Second player attack first player twice. [0, 1, 0]

// 
// let’s consider if there were only 2 people with strength A and B with (A<=B). then A would attack B, leading to A, B-A.
// it would continue until it get smaller than A or A, B%A. then process would repeat as A%(B%A), B%A and so on…
// 
// You can see this is exactly what is done in euclid GCD algorithm. So, answer is always gcd of numbers. 

public class Pubg {
    public int pubg(int[] A) {
        int len = A.length;
        int gcd = A[0];
        for (int i = 1 ; i < len ; i++) {
            gcd = findGcd(gcd, A[i]);
        }
        
        return gcd;
    }
    
    public int findGcd(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }
        
        if (b == 0)
            return a;
            
        return findGcd(b, a%b);
    }
}
