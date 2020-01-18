package HashTable;

import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public int getKey() {
            return key;
        }

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
    private LinkedList<Entry>[] entries=new LinkedList[5];
    public void put(int key,String value)
    {
        int index=hashCode(key);
        if(entries[index]==null)
        {
            entries[index]=new LinkedList<>();
        }
        LinkedList<Entry> bucket = entries[index];
        for(Entry ent:bucket)
        {
            if(ent.key==key)
            {
                ent.value=value;
                return;
            }
        }
        Entry entry=new Entry(key,value);
        bucket.addLast(new Entry(key,value));

    }
    public String get(int key)
    {
        int index=hashCode(key);
        LinkedList<Entry> bucket = entries[index];
        for(Entry ent:bucket)
        {
            if(ent.key==key)
            {

                return ent.value;
            }
        }
        return null;
    }
    private int hashCode(int key)
    {
        return key%entries.length;
    }

    public static void main(String[] args) {
        HashTable hm=new HashTable();
        hm.put(12,"CK");
        hm.put(13,"ZZZZ");
        hm.put(12,"COCON");
        System.out.println(hm.get(13));
    }
}
