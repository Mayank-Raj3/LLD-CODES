package LLD3_LFUCACHE;

public class Main {
    public static void main(String[] args) {
        int capacity = 3  ;
        LFUCache<Integer,String> cache = new LFUCache<Integer,String>(3);
        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");
        // 1-> {3,A} {2,A} {1,A}
        System.out.println((cache.get(1))); // A
        // 1-> {3,A} {2,A} {1,A}
        // 2-> {1,A}
        System.out.println((cache.get(1))); // A
        // 1-> {3,A} {2,A} {1,A}
        // 2-> {3,A}

        cache.put(4,"D"); // capacity Exceeds , Removes {2,A}
        System.out.println((cache.get(2))); // Should Give null



    }
}
