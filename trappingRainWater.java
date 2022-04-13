/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

*/  






class Solution {
    public int trap(int[] a) {
//      Brute Force Approch = TC : O(n^2) , SC : O(1)
        int n = a.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int maxL = 0, maxR = 0;
            for(int j = 0; j <= i; j++) {
                maxL = Math.max(maxL,a[j]);
            }
            for(int j = i; j < n; j++) {
                maxR = Math.max(maxR,a[j]);
            }
            ans += Math.min(maxL,maxR) - a[i];
        } 
        return ans;
        
//---------------------------------------------------------------------------   
        
//      Better Approach = TC : O(n) , SC : O(n)
        int n = a.length;
        int ans = 0;
        int maxL[] = new int[n];
        int maxR[] = new int[n];
        maxL[0] = a[0];
        for(int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i-1],a[i]);
        }
        maxR[n-1] = a[n-1];
        for(int i = n-2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i+1],a[i]);
        }
        for(int i = 0; i < n; i++) {
            ans += Math.min(maxL[i],maxR[i]) - a[i];
        } 
        return ans;
        
//---------------------------------------------------------------------------       
        
//      Optimal Approach = TC : O(n) , SC : O(1)
        int n = a.length,  maxL = 0, maxR = 0, ans = 0;    
        int l = 0, h = n-1;
        
        while(l <= h) {
            if(a[l] <= a[h]) {
                maxL = Math.max(maxL,a[l]);
                ans += maxL - a[l];
                l++;
            } else {
                maxR = Math.max(maxR,a[h]);
                ans += maxR - a[h];
                h--;
            }
        }
        return ans;
                    
    }
}
