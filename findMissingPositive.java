/*Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1*/



class Solution {
    public int firstMissingPositive(int[] nums) {
        sort(nums);
        int n = nums.length;
        if (nums[0] == nums.length) n++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }
    private void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i && arr[i] < arr.length && arr[i] >= 0 && arr[arr[i]] != arr[i]) swap(arr, arr[i], i);
            else i++;
        }
    }
    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
