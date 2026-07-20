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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Need to get to last n position 
        // we can use slow and fast pointer, fast pointer will move n steps ahead of slow
        // once fast pinter reaches end, remove node pinted by slow pointer
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i=0;i<=n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
    
        slow.next=slow.next.next;
        return dummy.next;
    }
}
