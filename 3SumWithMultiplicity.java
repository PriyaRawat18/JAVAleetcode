/*Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
Example 3:

Input: arr = [2,1,3], target = 6
Output: 1
Explanation: (1, 2, 3) occured one time in the array so we return 1.
 */



class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n= arr.length;
        int modl = (int) Math.pow(10, 9) + 7;
        long[] count = new long[101];
        long result = 0;
        
        for (int i = 0; i < n; i++) {
            count[arr[i]]+=1;
        }
        
        for (int i = 0; i <= 100; i++) {
            int l=i;
            int h=100;
            while(h>=l && h>=i && h<=100 && l>=i && l<=100) {
                int sum = i+l+h;
                if (sum>target) h--;
                
                else if (sum<target) l++;
                
                else if(sum == target){
                    
                    if(i!=l && l!=h && i!=h){
                        result += count[i] * count[l] * count[h];
                        result %= modl;
                    }
                    else if(i==l && l==h){
                        result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                        result %= modl;
                    }
                    else if(i==l && i!=h){
                        result += count[i] * (count[i] - 1) / 2 * count[h];
                        result %= modl;
                    }
                    else if(l==h && l!=i){
                        result += count[l] * (count[l] - 1) / 2 * count[i];
                        result %= modl;
                    }
                    else if(i==h && i!=l){
                        result += count[l] * (count[l] - 1) / 2 * count[l];
                        result %= modl;
                    }
                    l++;
                }     
        }
                
    }  

        return (int) result;
    }
}
