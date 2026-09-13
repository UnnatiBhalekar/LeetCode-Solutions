class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> dic;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!dic.containsKey(key)){
            return -1;
        }
        Node node = dic.get(key);
        remove(node);
        addAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(dic.containsKey(key)){
            Node oldNode = dic.get(key);
            remove(oldNode);
        }
        Node node = new Node(key, value);
        dic.put(key, node);
        addAfterHead(node);

        if(dic.size() > capacity){
            Node nodeToDelete = tail.prev;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addAfterHead(Node node){
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */