public class LRUCache {
    private DList list;
    private HashMap<Integer, ListNode> map;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        list = new DList();
        map = new HashMap<Integer, ListNode>();
        size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node;
        if ((node = map.get(key)) == null)
            return -1;
        list.promote(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        ListNode node;
        if ((node = map.get(key)) != null) {
            node.value = value;
            list.promote(node);
        } else {
            node = new ListNode(key, value);
            map.put(key, node);
            list.addFirst(node);
            size++;
            
            if (size > capacity) {
                map.remove(list.getLast().key);
                list.removeLast();
                size--;
            }
        }
    }
}

class DList {
    private ListNode head;
    
    public DList() {
        head = null;
    }
    
    public void promote(ListNode node) {
        if (node == head)
            return;
        unlink(node);
        addFirst(node);
    }
    
    public void unlink(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addFirst(ListNode node) {
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        head = node;
    }
    
    public void removeLast() {
        if (head.prev == head)
            head = null;
        else
            unlink(head.prev);
    }
    
    public ListNode getLast() {
        return head.prev;
    }
}

class ListNode {
    public int key;
    public int value;
    public ListNode prev;
    public ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this;
        this.next = this;
    }
}