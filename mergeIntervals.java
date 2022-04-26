/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/



/*First we sort the intervals array.

Start the pointers at i=0 and j=0

Now we need to check the end of first interval and start of second interval and see if they overlap.

If they overlap we merge them i.e. take the start of first interval(since array is sorted so this is the lowest value)
and take the maximum of the end value of both intervals.
ex. [[0,4],[0,6],[6,9]] => [[0,6],[0,6],[6,9]]

Else if they so not overlap all we need to do is increment j and put the second interval in that position.
ex. [[0,6],[0,6],[6,9]] => [[0,6],[6,9],[6,9]]

At the end we are returning a subarray till (j+1)


*/

class Solution {
    public static int[][] merge(int[][] arr) {
        Arrays.sort(arr, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int j=0;
        for(int k=0; k<arr.length; k++){
            if(arr[j][1]>=arr[k][0])
                arr[j] = new int[]{arr[j][0], Math.max(arr[j][1], arr[k][1])};
            else
                arr[++j] = arr[k];
        }
        return Arrays.copyOfRange(arr, 0, j+1);
    }
}


