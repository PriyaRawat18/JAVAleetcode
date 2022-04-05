/*Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0*/



class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        int c = 0;
        Arrays.fill(sieve, true);
        int l = (int)Math.floor(Math.sqrt(Double.valueOf(n)));
        for(int i=2; i<=l; i++){
            if(sieve[i] == true){
                for(int j=i*i; j<n; j+=i){
                    sieve[j] = false;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(sieve[i] == true) c++;
        }   
        return c;
    }
}
