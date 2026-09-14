class LRUCache {
    /*
    For making cache we need O(1) time retrieval and O(1) time insertions
    HashMap can give us that.
    Also we need to keep track of the least recently used key, so that it can be   removed if the cache is full.
    Doubly linked list can be used for this.
    we can move the node containing the key which is recently used to start of the list, and we can do this for evey get operation, in this way the least used node will naturally be found at the end of the lsit.
    To map keys with linked list node, we can keep them in HashMap with type 
    Map<int,Node>.
    when evicting the cache. we can check the size of the map before insertion, if it is equal to the limit then we can just get last node, get key from it, remove the key from map, replace the key and value of the last node with the inserted key, value and move this node to the start of the list.

    */
    class Node{ // Doubly linked list node
    Node previous;
    int key;
    int value;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        }
    }

    HashMap<Integer,Node> cacheMap;
    int capacity;
    Node head;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        // Initialize dummy head and tail to prevent NullPointerExceptions
        this.head = new Node(-1, -1);
        this.end = new Node(-1, -1);
        this.head.next = this.end;
        this.end.previous = this.head;
    }
    
    public Integer get(int key) {
        Node node = this.cacheMap.get(key);
        if (node==null){
            return -1;
        }
        removeNode(node);
        addNodeToStart(this.head,node);
        return node.value;
    }
     
    public void put(int key, int value) {
        
        Node node = this.cacheMap.get(key);
        if(node != null){
            removeNode(node);
        }
        node = new Node(key,value);
        this.cacheMap.put(key,node);
        addNodeToStart(this.head,node);
        if(this.cacheMap.size()>this.capacity){
            Node lruNode = this.end.previous;
            removeNode(lruNode);
            this.cacheMap.remove(lruNode.key);
        }
        
    }

    private void addNodeToStart(Node head, Node node){
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;

        
    }

}


