/*Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp=new ListNode(-10000, head);
        return ins(temp).next;
    }
    
    private ListNode ins(ListNode head) {
        if(head.next==null) return head;
        head.next=ins(head.next);
        if(head.val<=head.next.val) {
            return head;
        }
        ListNode tempHead=head;
        while(tempHead!=null && tempHead.next!=null) {
            if(head.val>tempHead.next.val) {
                tempHead=tempHead.next;
            } else {
                ListNode t=head.next;
                head.next=tempHead.next;
                tempHead.next=head;
                return t;
            }
        }
        ListNode t=head.next;
        tempHead.next=head;
        head.next=null;
        return t;
    }
}
