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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++){
            result = mergeList(result,lists[i]);
        }
        return result;
    }
    public ListNode mergeList(ListNode list1, ListNode list2){ 
        if(list1==null && list2!=null) return list2;
        else if(list2==null && list1!=null) return list1;
        else if(list2==null && list1==null) return null;
        ListNode p;
        ListNode primary;
        ListNode s;
        if(list1.val<list2.val) {
            p=list1;
            s=list2;
        }else{
            s=list1;
            p=list2;
        }
        primary=p;
        while(p.next!=null){
            if(p.next.val>s.val){
                ListNode temp = p.next;
                p.next=s;
                s=temp;
            }
            p=p.next;
        }
        p.next=s;
        return primary;
    }
}
