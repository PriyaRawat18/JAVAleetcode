/*Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0*/



class solution{
public int threeSumClosest(int[] nums, int target) {
        int rL = -10000;
        int rU = 10000;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int lowP = i + 1;
            int highP = nums.length - 1;
            while(lowP < highP){
                int sum = nums[i] + nums[lowP] + nums[highP];
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    rU = Math.min(rU, sum);
                    highP--;
                }else{
                    rL = Math.max(rL, sum);
                    lowP++;
                }
            }
        }

        if(Math.abs(target - rU) < Math.abs(target - rL)){
            return rU;
        }else{
            return rL;
        }
    }
}
