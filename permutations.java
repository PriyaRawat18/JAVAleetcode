/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]*/





class Solution {
    private void permutations(int index, int arr[], List<List<Integer>> ans)
{
    if(index==arr.length)
    {
        List<Integer> ds=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            ds.add(arr[i]);
        }
        ans.add(new ArrayList<>(ds));
        return;
    }
    
    for(int i=index;i<arr.length;i++)
    {
        swap(i,index,arr);
        permutations(index+1,arr,ans);
        swap(i,index,arr);
    }
    
}

 private void swap(int i, int j, int arr[])
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>();
    permutations(0,nums,ans);
    return ans;
}
}
