package LLD2_LRUCACHE;
import java.util.HashMap;

public class LRUCache<K,V> {
    private  final int capacity ;
    private final HashMap<K,Node<K,V>> cache ; // we require key , value mapping to check weather element is there
    private final DoublyLinkedList<K,V> list ; // dll for implementing cache
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity) ;
        list= new DoublyLinkedList<K,V>();
    }

    public V getValue(K key){
        Node<K,V> node = cache.get(key) ;
        if(node!=null){
            list.removeNode(node);
            list.addToHead(node);
            return node.value ;
        }
        return null ;

    }

    public void addValue(K key , V value){
        Node<K,V> node = cache.get(key) ;
        if(node!=null){
            node.value = value;
            list.removeNode(node);
            list.addToHead(node);
        }else{
            // element not present
            Node<K,V> newNode = new Node<>(key,value);
            cache.put(key, newNode);
            list.addToHead(newNode);
            if (cache.size() > capacity) {
                K lastElementKey = list.removeLastNode();
                cache.remove(lastElementKey);
            }
        }

    }



}
