package Exam.Amazon;

import java.util.LinkedHashMap;

public class Compress {
    public static void main(String[] args) {

    }
    public String compress(String input) {
        StringBuilder sb=new StringBuilder();
        LinkedHashMap<Character,Integer> hm= new LinkedHashMap<>();
        for(char a:input.toCharArray())
            hm.put(a,hm.getOrDefault(a,0)+1);

        for(char a:hm.keySet())
        {
            sb.append(a);
            sb.append(hm.get(a));
        }
        return sb.toString();
        // Add your code here
    }
}
