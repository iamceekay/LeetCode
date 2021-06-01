package Exam.Amazon;

import java.util.ArrayList;
import java.util.HashSet;

public class AlwaysTest {
    public static void main(String[] args) {
        HashSet<Character> hs=new HashSet<>();
        lengthOfLongestSubstring("pwwkew");
    }
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list=new ArrayList<>();
        int max=0;
        for(char c:s.toCharArray())
        {
            if(list.contains(c)) {
                System.out.println(list);
                list.remove(0);

            }
            else  list.add(c);
            max=Math.max(max,list.size());
        }
        return max;
    }
}
