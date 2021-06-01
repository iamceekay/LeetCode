package Exam.Google;

import java.util.HashMap;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="abcabcbb";
        lengthOfLongestSubstringSolution(s);
    }

    private static void lengthOfLongestSubstringSolution(String s) {
        int i=0,max=0,start=0,end=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int j=0;j<s.length();j++)
        {
            if(hm.containsKey(s.charAt(j)))
                i=Math.max(i,hm.get(s.charAt(j)));
                if(j-i+1>max)
                {
                    max=j-i+1;
                    start=i;
                    end=j+1;
                }
                hm.put(s.charAt(j),j+1);
        }
        System.out.println(s.substring(start,end));
    }
}
