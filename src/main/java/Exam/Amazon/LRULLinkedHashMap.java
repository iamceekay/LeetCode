package Exam.Amazon;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULLinkedHashMap extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRULLinkedHashMap(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get(int key)
    {
        return super.get(key);
    }
    public void put(int key,int value)
    {
         super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRULLinkedHashMap lru=new LRULLinkedHashMap(2);
        lru.put(3,1223);
        lru.put(4,1222);
        lru.get(3);
        lru.put(5,1243);
        lru.get(3);
        lru.put(6,1253);
        System.out.println(lru.get(3));



    }
}
