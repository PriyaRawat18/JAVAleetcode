/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []*/


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        combinationalSum_(candidates,target,new ArrayList<>(),0,res);
        return res;
    }
    
    //====================Method 1======================
    
    public void combinationalSum_(int[] candidates, int target, List<Integer> subList,int idx, List<List<Integer>> res){
        if(target<=0){
            if(target==0){
                List<Integer> ans=new ArrayList<>();
                ans.addAll(subList);
                res.add(ans);
            }
            
            return;
        }
        
        for(int i=idx;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                subList.add(candidates[i]);
                combinationalSum_(candidates,target-candidates[i],subList,i,res);
                subList.remove(subList.size()-1);
            }
        }
    }
    
    //========================Method 2===========================
    
//     public void combinationalSum_(int []candidates, int target, List<Integer> subList, int idx, List<List<Integer>> res){
//         if(idx>=candidates.length){
//             return;
//         }
//         if(target<=0){
//             if(target==0){
//                 List<Integer> ans=new ArrayList<>();
//                 ans.addAll(subList);
//                 res.add(ans);
//             }
            
//             return;
//         }
        
//         if(target-candidates[idx]>=0){
//             subList.add(candidates[idx]);
//             combinationalSum_(candidates,target-candidates[idx],subList,idx,res);
//             subList.remove(subList.size()-1);
//         }
        
//         combinationalSum_(candidates,target,subList,idx+1,res);
//     }
}
