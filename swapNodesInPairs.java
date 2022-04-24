/*Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 */


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr;

        if(head == null || head.next == null){
            return head;
        }
        else{
            // Start from 1st node
            ListNode ptr = head;
            curr = head.next;
            ListNode prev = head;
            while(ptr != null && ptr.next!=null){
                ListNode first = ptr;//first -> 1
                ListNode second = ptr.next;//second -> 2
                first.next = second.next;// 1 -> 3
                second.next = first;// 2 -> 1
                //Move to adjacent node
                ptr = ptr.next;// ptr -> 3 (curr ->2 ->1(ptr) -> 3 -> 4 -> null)
                if(first.next != null && first.next.next != null){
                    first.next = first.next.next;//1 -> 4
                }
            }
        }
               
        return curr;
    }
}

