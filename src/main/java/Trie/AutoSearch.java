package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class TrieNode
{
    Character value;
    HashMap<Character, TrieNode> children=new HashMap<>();
    boolean isword;
    String word;

    TrieNode(Character value)
    {
        this.value=value;
    }
}

public class AutoSearch {
    TrieNode root;
    AutoSearch()
    {
        root=new TrieNode(' ');
    }
    public void insert(String word)
    {
        TrieNode current =root;
        for(char ch:word.toCharArray())
        {
            if(current.children.get(ch)==null)
                current.children.put(ch,new TrieNode(ch));

            current=current.children.get(ch);
        }
        current.isword=true;
        current.word=word;
    }

    public List<String> find(String prefix)
    {
        List<String> result=new ArrayList<>();
        TrieNode lastNode=findLastNode(prefix);
        findAllWord(lastNode,result);
        return  result;
    }


    public TrieNode findLastNode(String prefix)
    {
        TrieNode current=root;
        for(char ch:prefix.toCharArray())
        {
            if(current.children.get(ch)==null) return null;
            current=current.children.get(ch);
        }
        return current;
    }
    private void findAllWord(TrieNode lastNode, List<String> result) {

        if(lastNode==null) return;
        if(lastNode.isword) result.add(lastNode.word);
        for(TrieNode child:lastNode.children.values())
        {
            findAllWord(child,result);
        }
    }
    private  boolean contains(String word)
    {
        TrieNode current=root;
        for(char ch:word.toCharArray())
        {
            if(current.children.get(ch)==null) return false;
            current=current.children.get(ch);
        }
        return current.isword && current.word==word;
    }


    public static void main(String[] args) {
        AutoSearch autoSearch=new AutoSearch();
        autoSearch.insert("Hello");
        autoSearch.insert("Hell");
        autoSearch.insert("H");
        autoSearch.insert("Hellobc");
        System.out.println(autoSearch.contains("Hell"));
        System.out.println(autoSearch.find("H"));

    }



}
