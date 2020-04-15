package Exam.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Suggestion {
    class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // sort products.
        Trie root = new Trie();
        for (String p : products) { // build Trie.
            Trie t = root;
            for (char c : p.toCharArray()) { // insert current product into Trie.
                if (t.sub[c - 'a'] == null)
                    t.sub[c - 'a'] = new Trie();
                t = t.sub[c - 'a'];
                if (t.suggestion.size() < 3) // maintain 3 lexicographically minimum strings.
                    t.suggestion.offer(p); // put products with same prefix into suggestion list.
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (root != null) // if there exist products with current prefix.
                root = root.sub[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        List<List<String>> result=new ArrayList<>();
        Arrays.sort(products);
        for(int i=1;i<=searchWord.length();i++)
        {
            String newSearch=searchWord.substring(0,i);
            List<String> temp=new ArrayList<>();
            for(String pro:products)
            {

                if(pro.length()>=newSearch.length() && pro.substring(0,i).equals(newSearch) && temp.size()<3)
                {
                    temp.add(pro);
                }
            }
            result.add(temp);
        }
        return result;

    }
}
