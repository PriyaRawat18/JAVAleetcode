/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 */


class Solution {
    public int[][] generateMatrix(int n) {
       int[][] ans = new int[n][n];
        int c=1;
        int top = 0, bottom =n-1,left =0,right =n-1;
        while(top <= bottom && left <= right)
        {
            for(int i=left;i<= right;i++)
            {
                ans[top][i]=c++;
            }
            top++;
            for(int i= top;i<= bottom;i++)
            {
                ans[i][right]=c++;
            }
            right--;
            for(int i= right;i>= left;i--)
            {
                ans[bottom][i]=c++;
            }
            bottom--;
            for(int i= bottom;i>= top;i--)
            {
                ans[i][ left]=c++;
            }
            left++;
        }
        return ans;
    }
}
