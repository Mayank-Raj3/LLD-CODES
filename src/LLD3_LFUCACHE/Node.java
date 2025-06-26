package LLD3_LFUCACHE;

public class Node<K,V> {
    K key ;
    V value ;
    Node<K,V> next ;
    Node<K,V> prev;
    int freq ;
    public Node(K key , V value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
