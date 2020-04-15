package Exam.Amazon;

import java.util.*;

public class Topk {
    public static void main(String[] args) {
       String[] keywords = {"anacell", "cetracular", "betacellular"};
        String[] reviews = {"Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell"};

        String[]  keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        System.out.println( topElement(keywords2,reviews2,2));
    }
    /*
    Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
    * */
    public static List<String> topElement(String[] keyword,String[] review,int k)
    {
        HashMap<String,Integer> hm =new HashMap<>();
        ArrayList<String> result  =new ArrayList<>();
        for (String key:keyword)
        {
            key=key.toLowerCase();
            hm.put(key,0);
        }
        for(String rev:review)
        {
            rev=rev.toLowerCase();
            String[] splitted=rev.split(" ");
            for(String split:splitted)
            {
                if(hm.containsKey(split.toLowerCase()))
                    hm.put(split,hm.get(split)+1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a, b)->a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        while(result.size()<k)
           result.add (pq.poll().getKey());
        return result;
    }
}
