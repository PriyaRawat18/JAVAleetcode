/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       Set<List<Integer>> set = new HashSet<>();
        if(nums.length < 4){
            return new ArrayList<>(set);
        }
        
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-3;i++){
           for(int j = i+1 ; j < nums.length-2;j++){
               for(int k = j+1 ; k < nums.length - 1; k++){
                   for(int l = k+1; l < nums.length ; l++){
                       if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                           set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                           break;
                       }
                   }
               }
           }
            
        }
        return new ArrayList<>(set);
    }
}
