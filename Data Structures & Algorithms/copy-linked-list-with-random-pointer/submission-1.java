/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();
        if (head==null) return null;
        Node newHead = new Node(head.val);
        Node ptr = head.next;
        Node newPtr = newHead;
        nodeMap.put(head,newHead);
        while(ptr!=null){
            Node newNode = new Node(ptr.val);
            nodeMap.put(ptr,newNode);
            newPtr.next = newNode;
            newPtr = newPtr.next;
            ptr=ptr.next;
        }
        newPtr.next=null;
        ptr = head;
        newPtr = newHead;
        while(ptr!=null){
            Node random = nodeMap.get(ptr.random);
            newPtr.random = random;
            ptr = ptr.next;
            newPtr = newPtr.next;
        }
        return newHead; 
    }
}
