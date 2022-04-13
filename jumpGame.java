/*Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

*/


class Solution {
    public int jump(int[] nums) {
        int ans=0;  // no. of jumps
        int idx = 0;  // current idx
        int l_idx=0;  // maximum idx it can reach in a jump 
        
        for(int i=0; i< nums.length-1 ;i++ ){
            l_idx = Math.max(l_idx, i+nums[i] );
            
            if(idx ==i ){
                ans++;
                idx=l_idx;
            }
        }
        return ans;
    }
}
