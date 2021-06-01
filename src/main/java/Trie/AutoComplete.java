package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoComplete {
    static class Node {
        private char value;
        //private Node[] children = new Node[26];
        private HashMap<Character, Node> children =new HashMap<>();
        private boolean isEndOfword;

        public Node(char value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "value=" + value;
        }
    }
    private Node root=new Node(' ');
    public void insert(String word)
    {
        Node current=root;
        for(char ch:word.toCharArray())
        {
               /* int index=ch-'a';
                if(current.children[index]==null)
                {
                    current.children[index]=new Node(ch);
                }
                current=current.children[index];*/
            if (current.children.get(ch)==null)
                current.children.put(ch,new Node(ch));
            current=current.children.get(ch);
        }
        current.isEndOfword=true;
    }
    public List<String> findWords(String prefix)
    {
        List<String> words=new ArrayList<>();
        Node lastNode=findLastNode(prefix);
        findWord(lastNode,prefix,words);
        return words;
    }
    private void findWord(Node root, String prefix, List<String> words)
    {
        if(root==null)
            return;
            if(root.isEndOfword)
            {
                words.add(prefix);
            }
            for(Node child:root.children.values())
            {
                findWord(child,prefix+child.value,words);
            }
    }
    private Node findLastNode(String prefix)
    {
        Node current=root;
        for(char ch:prefix.toCharArray() )
        {
            //Get Child
            Node child = current.children.get(ch);
            if(child==null)
            {
                return null;
            }
            current=child;

        }
        return current;
    }


    public static void main(String[] args) {
        AutoComplete trie=new AutoComplete();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("capability");
        trie.insert("Dog");
        trie.insert("Doggg");
        System.out.println(trie.findWords("D"));
    }
}
