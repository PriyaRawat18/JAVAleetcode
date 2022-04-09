/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]*/



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int fst=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                fst=mid;
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else r=mid-1;
        }
        l=0;
        r=nums.length-1;
        int lst=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                lst=mid;
                l=mid+1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else r=mid-1;
        }
        return new int[]{fst,lst};
        
    }
}
