/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]*/


//==================Method 1===============

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2_(candidates,target,0,new ArrayList<>());
        return ans;
    }
    
    public void combinationSum2_(int []candidates,int target, int idx, List<Integer> subList){
        
        
        if(target<=0){
            if(target==0){
                List<Integer> subAns=new ArrayList<>(subList);
            
                    ans.add(subAns);
                
            }
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target-candidates[i]>=0){
             subList.add(candidates[i]);
             combinationSum2_(candidates,target-candidates[i],i+1,subList);
             subList.remove(subList.size()-1);
            }
            
        }
        
    }
}

//================Method 2=================


// class Solution {
    
//     List<List<Integer>> ans=new ArrayList<>();
    
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         HashMap<Integer,Integer> fmap=new HashMap<>();
//         for(int num:candidates){
//             fmap.put(num,fmap.getOrDefault(num,0)+1);
//         }
       
//         combinationSum2_(candidates,target,fmap,new ArrayList<>());
//         return ans;
//     }
    
//     public void combinationSum2_(int[] candidates, int target,HashMap<Integer,Integer> fmap, List<Integer> subList){
//         if(target<=0){
//             if(target==0){
//                 List<Integer> subAns=new ArrayList<>(subList);
//                 Collections.sort(subAns);
//                 if(!ans.contains(subAns)){
//                     ans.add(subAns);
//                 }
                
//             }
            
//             return;
//         }
        
//         for(int key: fmap.keySet()){
//             int freq=fmap.get(key);
//             if(freq>0){
//                 fmap.put(key,freq-1);
//                 subList.add(key);
              
//                 combinationSum2_(candidates,target-key,fmap,subList);
//                 fmap.put(key,freq);
//                 subList.remove(subList.size()-1);
//             }
//         }
//     }
// }
