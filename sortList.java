/*Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []*/

class Solution {
public ListNode sortList(ListNode head) {

    if(head==null){
        return null;
    }
    ArrayList<Integer> list = new ArrayList<>();
    ListNode temp = head;
    
    while(temp!=null){
        list.add(temp.val);
        temp=temp.next;
    }
    Collections.sort(list);
    ListNode node;
    head=null;
    ListNode tail=null;
    for(int i : list){
        if(head==null){
            node = new ListNode(i);
            head=node;
            tail=head;
            
        }else{
            node = new ListNode(i);
            tail.next=node;
            tail=tail.next;
        }
        
    }
    return head;
}
} 
