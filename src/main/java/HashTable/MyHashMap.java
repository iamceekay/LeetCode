package HashTable;

import java.util.LinkedList;

class MyHashMap {
    @Override
    public String toString() {
        return "MyHashMap{}"+entries.toString();
    }

    class Entry{
        int key;
        int value;
        Entry(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private static LinkedList<Entry>[] entries =null;
    /** Initialize your data structure here. */
    public MyHashMap() {
        entries =new LinkedList[5];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getHashCode(key);
        if(entries[index]==null)
        {
            entries[index]=new LinkedList<Entry>();
        }
        LinkedList<Entry> bucket=entries[index];
        for(Entry entry:bucket)
        {
            if(entry.key==key)
            {
                entry.value=value;
            }
        }
        bucket.addLast(new Entry(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getHashCode(key);
        LinkedList<Entry> bucket=entries[index];
        for(Entry entry:bucket)
        {
            if(entry.key==key)
            {
                return entry.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getHashCode(key);
        LinkedList<Entry> bucket=entries[index];
        for(Entry entry:bucket)
        {
            if(entry.key==key){
                bucket.remove(entry);
                return;
            }
        }
    }
    public int getHashCode(int key) {
        return key%entries.length;
    }


//Your MyHashMap object will be instantiated and called as such:
public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(1,3);
    obj.put(2,3);
    int param_2 = obj.get(1);
    System.out.println(param_2);
    obj.remove(1);
}
}

