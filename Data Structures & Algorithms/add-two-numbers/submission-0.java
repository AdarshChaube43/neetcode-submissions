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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        We can iterate thorugh both the lists and we can add values one by one and store them in one of the list
        to handle the carry we can store carry = sum/10 (carry was initilazied with 0);
        then store node.val = carry+sum%10;
        we also need to check every time if l1.next == null or l2.next ==null
        (we were saving the results in l1)
        if l1 ended before l2 then add the remaining carry in next node of l2, point l1.next to l2.next and keep the loop going till l1.next!=null and carry>0 
        check every time if l1.next ==null and carry>0 then create a new node for 
        else;
        */
        int c=0;
        ListNode head = l1;
        ListNode prev = null;
        while(l1!=null){
            int sum  = l1.val+c;

            if (l1.next==null && l2!=null && l2.next!=null){
                l1.next=l2.next;
                l2.next=null;
            }
            
            if(l2!=null) {
                sum =sum+l2.val;
                l2 = l2.next;
            }
            
            l1.val = sum%10;
            c=sum/10;
            prev = l1;
            l1=l1.next;
        }
        if(c>0){
            prev.next = new ListNode(c,null);
        }
        
        return head;

    }
}
