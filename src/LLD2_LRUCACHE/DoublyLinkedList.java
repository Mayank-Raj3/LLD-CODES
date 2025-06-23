package LLD2_LRUCACHE;

public class DoublyLinkedList<K,V> {
    Node<K,V> head;
    Node<K,V> tail;
    public DoublyLinkedList(){
        head = new Node<>(null, null);
        tail = new Node<>(null, null);

        head.next = tail ;
        tail.prev = head ;
    }

    public void addToHead(Node<K,V> node){
        node.next = head.next ;
        node.prev = head ;
        head.next.prev = node ;
        head.next = node ;
    }

    public void removeNode(Node<K,V>node){
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }

    public K removeLastNode(){
        Node<K,V> t = tail.prev;
        removeNode(tail.prev);
        return t.key ;

    }

}
