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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        use two pointers to point to head of each list, ex l1,l2.
        compare data for l1 and l2, to know from which list whould we start ex, l1.data< l2.data the begin iteration with l1
        compare l1 and l2 data if l2>=l1, break connection between l1 and l1.next by first storing l1.next in a temp variable then set l1.next =l2
        and set l2 = temp;
        then continue iterations 
        if l1.next.data>l2.data then
        temp=l1.next;
        l1.next=l2;
        l2=temp;
        */

        ListNode l1;
        ListNode l2;
        ListNode head;
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){
            l1=list1;
            l2=list2;
            head=list1;
        }else{
            l2=list1;
            l1=list2;
            head = list2;
        }

        while(l1.next!=null){
            if(l1.next.val>l2.val){
                ListNode temp = l1.next;
                l1.next = l2;
                l2=temp;
            }
            l1=l1.next;
            
        }
        if(l2!=null) l1.next=l2;
        return head;
    }
}