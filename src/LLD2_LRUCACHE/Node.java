package LLD2_LRUCACHE;

// Node can take any key value (datatype) so make it generic
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}