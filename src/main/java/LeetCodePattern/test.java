package LeetCodePattern;

import java.util.*;

public class test {



    public static void main(String[] args)
    {
        /*ArrayList<String> h = new ArrayList<>();
        System.out.println(h.size());
        h.add("h");
        h.add("a");
        h.add("c");
        h.add(1,"k");
        System.out.println(h.size());
        h.remove("a");
        h.remove(2);
        System.out.println(h.size());
        strStr(" "," ");*/
        String s="abA12";
        s.trim();
        String[] splitted=s.split(" ");
        System.out.println( s != null && s.matches("[a-zA-Z]*$"));
    }

    private static int sumMaxOccurring(int[][] mat) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxfreq=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[i].length;j++)
                hm.put(mat[i][j],hm.getOrDefault(mat[i][j],0)+1);// Traverse matrix and store frequency
            for(int freq:hm.keySet())
                maxfreq=Math.max(maxfreq,hm.get(freq));// Find maximum frequency value
        for(int freq:hm.keySet())
            if(hm.get(freq)==maxfreq)
                sum+=freq*hm.get(freq);// Add value as per the frequency
            return sum;

    }
    public static int strStr(String haystack, String needle) {
        int i=0;
        while(i<=haystack.length()-1)
        {
            if(haystack.charAt(i)==needle.charAt(0))
            {
                String temp=haystack.substring(i,i+needle.length());
                System.out.println(" temp  "+temp.length());
                System.out.println(" temp  "+needle.length());
                if(temp.equals(needle)) return i;

            }
            i++;

        }
        return -1;
    }


}
