package Exam.Amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRU(int initialCapacity) {
        super(initialCapacity, 0.75F, true);
        this.capacity = capacity;
    }
    public int get(int key)
    {
        return super.getOrDefault(key,-1);
    }
    public int put(int key,int value)
    {
        return super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

}

class Solution {
    static class LRUCache {
        class ListNode{
            int key;
            int value;
            ListNode prev;
            ListNode next;
        }
        HashMap<Integer,ListNode>hm;
        ListNode head;
        ListNode tail;
        int totalIteminCache;
        int maxCapacity;
        public LRUCache(int maxCapacity){
            totalIteminCache=0;
            this.maxCapacity=maxCapacity;
            hm =new HashMap<Integer,ListNode>();

            head=new ListNode();
            tail=new ListNode();

            head.next=tail;
            tail.prev=head;
        }
        public void addToFront(ListNode node){
            node.prev=head;
            node.next=head.next;

            head.next.prev=node;
            head.next=node;
        }
        public void removeFromList(ListNode node){
            ListNode savePrev= node.prev;
            ListNode saveNext=node.next;
            savePrev.next=saveNext;
            saveNext.prev=savePrev;
        }
        private void moveToHead(ListNode node)
        {
            removeFromList(node);
            addToFront(node);
        }
        public void put(int key,int value){
            ListNode node=hm.get(key);
            if(node==null) {
                ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.value = value;
                hm.put(key, newNode);
                addToFront(newNode);
                totalIteminCache++;
                if (totalIteminCache > maxCapacity) {
                    ListNode lastNode = tail.prev;
                    removeFromList(lastNode);
                    hm.remove(lastNode.key);
                    totalIteminCache--;
                }
            }
            else{
                node.value=value;
                moveToHead(node);
            }

        }
        public int get(int key){
            ListNode node=hm.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

    }

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(3);
        lru.put(2,5);
        lru.put(10,11);
        lru.put(32,11);
        lru.put(4,2);
        System.out.println(lru.get(4));


    }
}
