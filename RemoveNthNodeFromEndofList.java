/*Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:
1 --> 2 --> 3 --> 4 --> 5      ==>   1 --> 2 --> 3 --------> 5

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;
        ListNode curr = head;
        int i = 0;
        while(i<n && curr != null)
        {
            curr = curr.next;
            i++;
        }
        ListNode slow = head, prev = head;
        if(curr == null )
            return head.next;
        while(curr != null)
        {
            curr = curr.next;
            
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
        
    }
}
