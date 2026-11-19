class LFUCache {
    Map<Integer, Node> keyMap = new HashMap<>();
    Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }
        if (keyMap.size() == capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            keyMap.remove(removed.key);
        }

        Node node = new Node(key, value);
        keyMap.put(key, node);
        minFreq = 1;

        freqMap.putIfAbsent(1, new DoublyLinkedList());
        freqMap.get(1).add(node);
    }

    private void update(Node node) {
        int freq = node.frequency;
        DoublyLinkedList list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.frequency++;

        freqMap.putIfAbsent(node.frequency, new DoublyLinkedList());
        freqMap.get(node.frequency).add(node);
    }
}

class Node {
    int key;
    int value;
    int frequency;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

class DoublyLinkedList {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int size = 0;

    DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    void add(Node node) {
        node.next = head.next; // 1. new node points to the old first node
        node.prev = head; // 2. and back to head
        head.next.prev = node; // 3. old first node points back to the new node
        head.next = node; // 4. head points to the new node (last, on purpose)
        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size > 0) {
            Node node = tail.prev;
            remove(node);
            return node;
        }
        return null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */