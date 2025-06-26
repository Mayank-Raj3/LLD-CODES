package LLD3_LFUCACHE;

import java.util.HashMap;
import java.util.Map;

public class LFUCache <K,V>{
    private int capacity ;
    private int minFreq ;
    private final Map<K,Node<K,V>> cache ;
    private final Map<Integer, DoublyLinkedList<K, V>> frequencyMap;
    public LFUCache(int capacity){
        this.capacity = capacity;
        minFreq = 0 ;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public V get(K key){
        Node<K, V> node = cache.get(key);
        if(node==null) return null ;
        updateFreq(node); // we get it so will come at head in dll
                          // we can get its freq stored init and then find the dll using that and update
        return node.value ;
    }
    public void put(K key , V value){
        if(capacity==0) return ; // jgh he nhi ha

        Node<K, V> node = cache.get(key);
        if(node!=null){
            // if already present
            node.value = value;
            updateFreq(node);
        }else{
            // not present then add , and check if capacity is there

            if(cache.size()>=capacity){
                DoublyLinkedList<K, V> minFreqList = frequencyMap.get(minFreq);
                Node<K, V> nodeToRemove = minFreqList.removeLast();
                if (nodeToRemove != null) {
                    cache.remove(nodeToRemove.key);
                }
            }
            // create the node and push it into freqMap with freq 1
            node = new Node<>(key,value);
            cache.put(key, node);
            frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList<>()).addFirst(node);
            minFreq = 1;
        }
    }


    public void updateFreq(Node<K,V> node){
        int currFreq = node.freq ;
        DoublyLinkedList<K, V> oldList = frequencyMap.get(currFreq);
        oldList.removeNode(node);

        // if current is the only element with minfreq  , isempty will tell if its only element
        if (currFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        frequencyMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList<>()).addFirst(node);

    }

}
