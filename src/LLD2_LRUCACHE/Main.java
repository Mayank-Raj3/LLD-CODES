package LLD2_LRUCACHE;

public class Main {
    public static void main(String[] args) {
        int capacity = 3 ;
        LRUCache<Integer,String> cache = new LRUCache<>(capacity);
        cache.addValue(1,"A");
        cache.addValue(2,"B");
        cache.addValue(3,"C");
        cache.addValue(4,"D");
        System.out.println(cache.getValue(1)); // removed so returns null

    }
}
