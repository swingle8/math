// Maximum Intersection Points
// Problem Description
// You are given A lines and B circles. Find the maximum number of intersection points that these A lines and B circles can have with each other.
// 
// 
// Problem Constraints
// 0 <= A,B <= 10000
// 
// 
// Input Format
// First argument is an integer A denoting the number of lines.
// Second argument is an integer B denoting the number of circles.
// 
// 
// Output Format
// Return an integer denoting the maximum number of intersection points.
// 
// 
// Example Input
// Input 1:
// A = 2
// B = 2
// 
// 
// Example Output
// output 1:
// 11
// 
// 
// Example Explanation
// Explanaton 1:
// Two circles can intersect at 2 points.
// Two lines can intersect at only 1 point.
// Two lines and two circles can intersect at 8 points.
// So, total maximum number of intersection points are 11.

// Approach : // 
// circle intersection : 0, 2, 4, 6, 8
// sum_circle_intersection : 0, 2 , 6, 10, 18
// 
// Line intersection : 0, 1, 2, 3, 4
// sum_circle_intersection : 0, 1 , 3, 6, 10
// 
// one_line_to_circle_intersection : 2, 4, 6, 8, 10



public class Solution {
    public int getIntersection(int A, int B) {
        int lines_interrsect = 0;
        int circles_intersect = 0;
        int oneLineToCircle = B*2;
        int totalLineToCircle = A * oneLineToCircle;
        
        for (int i = 1 ; i <= A ; i ++) {
            lines_interrsect = lines_interrsect + i-1;
        }
        
        for (int i = 1 ; i <= B ; i ++) {
            circles_intersect = circles_intersect + (i-1)*2;
        }
        
        return (lines_interrsect + circles_intersect + totalLineToCircle);
    }
}