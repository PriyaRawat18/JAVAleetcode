/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //store frequency as value and element as key
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //minHeap of size k. arrange data according to freq in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->map.get(o1)-map.get(o2));
        //for each entry in map add it to minHeap
        for(Integer key:map.keySet()) {
            minHeap.add(key);
            //if size reaches k delete top entry.
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        //prepare output array
        int[] op = new int[k];
        while(!minHeap.isEmpty()) {
            op[--k]=minHeap.poll();
        }
        return op;
    }
}
