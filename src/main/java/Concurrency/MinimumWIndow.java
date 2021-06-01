package Concurrency;

import java.util.HashMap;

public class MinimumWIndow {
    public static void main(String[] args) {
        minLengthSubstring("dcbefebce","fd");
    }
    static int minLengthSubstring(String s, String t) {
        // Write your code here
        HashMap<Character,Integer> hm= new HashMap<>();
        for(char c:t.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int count=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int minLeft=0;
        for(int right=0;right<s.length();right++)
        {
            char c=s.charAt(right);
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)>=0) count++;
            }
            while(count==t.length())
            {
                if(right-left+1<minLen)
                {
                    minLeft=left;
                    minLen=right-left+1;
                }
                char l=s.charAt(left);
                if(hm.containsKey(l))
                {
                    hm.put(l,hm.get(l)+1);
                    if(hm.get(l)>0) count--;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?-1:s.substring(minLeft,minLeft+minLen).length();

    }
}
