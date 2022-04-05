/*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.*/



class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long minNUm = 1L;
        for(int i=1;i<=n;i++){
            minNUm = set.pollFirst();
            set.add(minNUm * 2);
            set.add(minNUm * 3);
            set.add(minNUm * 5);
        }
        return (int)minNUm;
    }
