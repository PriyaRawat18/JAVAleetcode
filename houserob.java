/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.*/



class Solution {
    public int rob(int[] n) {
        int [] ans=new int[n.length+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        return help(n,0,ans);
    }
    public int help(int[] n,int i,int[] ans){
        if(i>=n.length){
            return 0;
        }
        if(ans[i+1]!=-1){
            return ans[i+1];
        }
        int op1= n[i]+help(n,i+2,ans);
        int op2= help(n,i+1,ans);
        ans[i+1]= Math.max(op1,op2);
        return ans[i+1];
    }
}
