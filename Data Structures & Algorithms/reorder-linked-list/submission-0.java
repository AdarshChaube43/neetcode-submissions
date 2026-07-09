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
    public void reorderList(ListNode head) {
        /*
        We can split this list in half,
        list1 and list2,
        reverse the list 2 
        then merge the two list alternatively
        */
        if (head.next==null) return;
        ListNode list1 = head;
        ListNode slow = list1;
        ListNode fast = list1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        System.out.println(slow.val);
        slow.next=null;
        System.out.println(list2.val);
        //reverse list2
        ListNode current=list2;
        ListNode next;
        ListNode previous=null;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        list2=previous;
        System.out.println(list2.val);
        ListNode l1=list1;
        ListNode l2=list2;
        while(l2!=null){
            System.out.println("l1="+l1.val);
            System.out.println("l2="+l2.val);
            ListNode temp1=l1.next;
            ListNode temp2=l2.next;
            l1.next=l2;
            l1.next.next=temp1;
            l2=temp2;
            l1=l1.next.next;
        }
        head=list1;
    }
}
