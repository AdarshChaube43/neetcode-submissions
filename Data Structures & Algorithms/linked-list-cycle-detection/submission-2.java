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
    public boolean hasCycle(ListNode head) {
        /*
        use 2 pointers slow and fast, slow moves by slow =slow.next and fast moves by fast.next.next;
        move it till either fast.next !=null && fast.next.next!=null
        inside loop check if either fast.next =slow or fast.next.next =slow 
        if true then return true
        outside the loop return false;
        */
        if(head == null) return false;
        ListNode slow = head;
        if(slow.next==null || slow.next.next == null) return false;
        ListNode fast = slow.next.next;
        while(fast.next!=null && fast.next.next!=null){
            if(fast.next == slow || fast.next.next==slow) return true;
            slow = slow.next;
            fast= fast.next.next;
        }
        return false;
    
    }
}
