/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []*/




public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int lowP = i + 1;
            int highP = nums.length - 1;
            while(lowP < highP){
                int sum = nums[i] + nums[lowP] + nums[highP];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[lowP], nums[highP]));
                    while(lowP < highP && nums[lowP] == nums[lowP+1]){
                        lowP++;
                    }
                    lowP++;
                }else if(sum > 0){
                    highP--;
                }else{
                    lowP++;
                }
            }
        }
        return res;
    }
