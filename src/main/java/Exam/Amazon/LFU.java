package Exam.Amazon;

import java.util.HashMap;
import java.util.Map;

class LFU {
    int capacity;
    int cursize;
    int minFreq;
    Map<Integer,Node> valueDetail;
    Map<Integer,DoubleLinkedList> frequency;
    public LFU(int capacity) {
        this.capacity=capacity;
        this.cursize=0;
        this.minFreq=0;
        this.valueDetail=new HashMap<>();
        this.frequency=new HashMap<>();

    }

    public int get(int key) {
        Node current= valueDetail.get(key);
        if(current==null) return -1;
        updateNode(current);
        return current.value;

    }
    public void updateNode(Node node)
    {
        int currentFreq=node.freq;
        DoubleLinkedList currentList= frequency.get(currentFreq);
        currentList.remove(node);
        if(currentFreq==minFreq && currentList.listSize == 0)
            minFreq++;

        node.freq++;
        DoubleLinkedList newList = frequency.getOrDefault(node.freq,new DoubleLinkedList());
        newList.addNode(node);
        frequency.put(node.freq,newList) ;

    }

    public void put(int key, int value) {
        if(valueDetail.containsKey(key))
        {
            Node current=valueDetail.get(key);
            current.value=value;
            updateNode(current);
        }
        else
        {
            cursize++;
            if(cursize>capacity)
            {
                DoubleLinkedList minFreqlist=frequency.get(minFreq);
                Node last=minFreqlist.removeTail();
                valueDetail.remove(last.key);
                cursize--;
            }
        }
        minFreq=1;
        Node newNode =new Node(key,value);
        DoubleLinkedList newList = frequency.getOrDefault(1,new DoubleLinkedList());
        newList.addNode(newNode);
        frequency.put(1,newList);
        valueDetail.put(key,newNode);


    }
    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class DoubleLinkedList{
        int listSize;
        Node head;
        Node tail;
        DoubleLinkedList()
        {
            this.listSize=0;
            this.head=new Node(0,0);
            this.tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(Node node)
        {
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            listSize++;
        }
        public void remove(Node node)
        {
            Node saveNext=node.next;
            Node savePrev=node.prev;
            savePrev.next=saveNext;
            saveNext.prev=savePrev;
            listSize--;
        }

        public Node removeTail()
        {
            if(listSize>0)
            {
                Node last=tail.prev;
                remove(last);
                return last;
            }
            return null;
        }

    }

    public static void main(String[] args) {
      LFU lfu=  new LFU(2);
      lfu.put(1,1);
      lfu.put(2,2);
        System.out.println(lfu.get(1));
      lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));


    }
}
