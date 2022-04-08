/*Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8*/


class KthLargest {
    PriorityQueue<Integer> pq= new PriorityQueue<>();  //we need to declare public pq and kth element
    int k;
    public KthLargest(int k, int[] nums) {
    for( int a: nums){
				pq.add(a);           //add all the elements in pq 
    }
        this.k=k;   //pointing k to global k
    }
    
    public int add(int val) {
        pq.add(val);         //adding value in pq  no need to take care of nums array
        
        while(pq.size()>k){      //remove all the elements which we dont need  
				pq.remove();       // making the window of k size
        }
        return pq.peek();   //returning the peek element of queue
        
    }
}
