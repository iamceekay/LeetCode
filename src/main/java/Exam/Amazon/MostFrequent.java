package Exam.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MostFrequent {
    public static void main(String[] args) {
        System.out.println();
    }
    List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                 List<String> wordsToExclude)
    {
        // WRITE YOUR CODE HERE
        HashMap<String,Integer> hm =new HashMap<String,Integer>();
        List<String> result  =new ArrayList<>();
        int max=0;
        String[] text = helpText.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        List<String> wordsToExcludeTemp = wordsToExclude.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        for(String t:text)
        {
            if(!wordsToExclude.contains(t))
            {
                hm.put(t,hm.getOrDefault(t,0)+1);
                max=Math.max(hm.get(t),max);
            }
        }
        for(String s:hm.keySet())
        {
            if(hm.get(s)==max)
                result.add(s);
        }
        return result;

    }

    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<inputList.size();i++){
            map.put(inputList.get(i), i);
        }
        int left =0;
        int right =0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++)
        {
            right = Math.max(right, map.get(inputList.get(i)));
            if (right == i)
            {
                result.add(1 + right - left);
                left = right + 1;
            }
        }
        return result;
    }
    // METHOD SIGNATURE ENDS
}

