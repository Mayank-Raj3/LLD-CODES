package LLD3_LFUCACHE;

public class DoublyLinkedList<K,V>{
    private final Node<K,V> head ;
    private final Node<K,V> tail ;
    private int size ;
    public DoublyLinkedList(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail ;
        tail.prev = head ;
        this.size = 0 ;
    }

    public void  addFirst(Node<K,V> node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node ;
        head.next = node ;
        size++;
    }

    public void  removeNode(Node<K,V> node){
        node.prev.next=  node.next;
        node.next.prev = node.prev ;
        node.prev = null;
        node.next = null;
        size-- ;
    }

    public Node<K, V> removeLast(){
        if(size ==0) return null;
        Node<K,V> last = tail.prev ;
        removeNode(last);
        return last ;
    }


    public boolean isEmpty(){
        return this.size ==0 ;
    }
}
