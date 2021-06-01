package LeetCodePattern;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class test {

    static int a,b=2,c;

    public static void main(String[] args)
    {

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(round(22.9));

        List<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5,6,8,9));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Integer ele=iterator.next();
            if(ele%2==0)
                iterator.remove();
        }
        System.out.println(list);

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
