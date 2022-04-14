/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21*/




class Solution {
    public int reverse(int x) {
        if(x<=(-1*Math.pow(2,31)) || x>=(Math.pow(2,31)-1) || x==0){
            return 0;
        }
        boolean negative = false;
        int value;
        if(x<0){
            negative = true;
            value = -1*x;
        }else{
            value = x;
        }
        int sol = 0;
        while(value!=0){
            if(sol>Integer.MAX_VALUE/10) return 0;
            sol=(sol*10)+(value%10);
            value = value/10;
            
        }
        return negative?sol*-1:sol;
    }
}
