package Trie;

import java.util.HashMap;

class Trie {
     static class Node {
         private char value;
         //private Node[] children = new Node[26];
         private HashMap<Character,Node> children =new HashMap<>();
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
               if (current.children.get(ch)==null)
                   current.children.put(ch,new Node(ch));
               current=current.children.get(ch);
            }
            current.isEndOfword=true;
        }
        public boolean contains(String word)
        {
            Node current=root;
            for(char ch:word.toCharArray())
            {
                if(current.children.get(ch)==null) return false;
                current=current.children.get(ch);
            }
            return current.isEndOfword;
        }

        public static void main(String[] args) {
            Trie trie=new Trie();
            trie.insert("cat");
            trie.insert("can");
            trie.insert("done");
            System.out.println(trie.contains("don"));
        }

    }
