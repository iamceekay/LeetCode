package Concurrency;

import java.util.*;

public class CodeSignal {
    public static void main(String[] args) {
      //  beautifulSubarrays(new int[]{2,5,4,9},1);
        rearrangeTheSentence1("It is in sun the beach. hottest");
    }

    private static void rearrangeTheSentence1(String s) {
        StringBuffer sb=new StringBuffer();
        TreeMap<Integer,LinkedHashSet<String>> hm=new TreeMap<>();
        String[] splitted=s.split(" ");
        for(String w:splitted)
        {
            if(!hm.containsKey(w.length()))
            {
                hm.put(w.length(),new LinkedHashSet<>());
            }
            hm.get(w.length()).add(w);
        }
        for(int w:hm.keySet())
        {
            HashSet<String> value=hm.get(w);
            for(String va:value)
            {
                va=va.replaceAll("[^A-Za-z]","");
                sb.append(va+ " ");
            }
        }
        char c=sb.charAt(0);
        sb.setCharAt(0,Character.toUpperCase(c));
        sb.setCharAt(sb.length()-1,'.');
        System.out.println(sb.toString().trim());

    }

    static long  beautifulSubarrays(int[] a, int m) {
        int gCount=0;

        for(int i=0;i<a.length;i++)
        {

            int count=0;
            for(int j=i;j<a.length;j++)
            {
                if(a[j]%2!=0)
                {
                    count++;
                }
                if(count==m) gCount++;
            }
        }
       System.out.println(gCount);
       return gCount;

    }
    static void rearrangeTheSentence(String sentence) {

        StringBuffer sb=new StringBuffer();
       // sentence
        System.out.println(sentence);
        sentence.trim();
        ;
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a, b)->a.getValue()-b.getValue()!=0?a.getValue().compareTo(b.getValue()):0);
       // PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        LinkedHashMap<String,Integer> hm=new LinkedHashMap<String,Integer>();
        String[] word=sentence.split(" ");
        for(String w:word)
        {
            hm.put(w, w.length());
        }
        System.out.println(hm);
        pq.addAll(hm.entrySet());
        int size=pq.size();
        int count=0;
        Character first = null;
        while(!pq.isEmpty())
        {
            String value=pq.poll().getKey().toLowerCase();
            value=value.replaceAll("[^A-Za-z]","");
            //value=value.replaceAll()

            if(count==0)
            {
                first=value.charAt(0);
                sb.append(value+" ");
            }
           else if(count==size-1)
            {
                sb.append(value);
            }
            else {
                sb.append(value+" ");
            }
            count++;

        }
        System.out.println(Character.toUpperCase(first));
        first=Character.toUpperCase(first);
        sb.setCharAt(0, first);
        System.out.println(sb.toString());
    }
}
