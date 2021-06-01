package Trie;

import java.util.HashMap;

class WordFilter {
    class Node
    {
        private HashMap<Character,Node> children;
        private int index;
        Node()
        {
            children=new HashMap<>();
            this.index=0;
        }
        public void insert(String word,int index)
        {
            Node current=root;
            for(char c:word.toCharArray())
            {
                if(current.children.get(c)==null)
                    current.children.put(c,new Node());
                current=current.children.get(c);

            }
            current.index=index;
        }
        public int startWith(String word)
        {
            Node current=root;
            for(char c:word.toCharArray())
            {
                if(current.children.get(c)==null) return -1;
                current=current.children.get(c);

            }
            return current.index;
        }
    }
    Node root=new Node();
    public WordFilter(String[] words) {
        Node node=new Node();
        for(int i=0;i<words.length;i++)
        {
            String s=words[i];
            for(int j=0;j<s.length();j++)
                node.insert(s.substring(j,s.length())+"#"+s,i);
        }

    }
    public int f(String prefix, String suffix) {
       return root.startWith(suffix+"#"+prefix);
    }

    public static void main(String[] args) {
        WordFilter w=new WordFilter(new String[]{"apple"});
        w.f("a","e");


    }




}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
