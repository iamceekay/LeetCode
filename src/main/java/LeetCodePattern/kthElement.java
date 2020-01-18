package LeetCodePattern;

import java.util.*;

public class kthElement {
/*
347. Top K Frequent Elements
        Medium

        2166

        142

        Add to List

        Share
        Given a non-empty array of integers, return the k most frequent elements.

        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]*/


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm =new HashMap<Integer,Integer>();
        TreeMap<Integer,List<Integer>> thm =new TreeMap<>();
        ArrayList<Integer> result =new ArrayList<>();
        int i=0;
        for(int n:nums)
        {
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet())
        {
            if(thm.containsKey(entry.getValue())){
                thm.get(entry.getValue()).add(entry.getKey());
            }
            else{
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(entry.getKey());
                thm.put(entry.getValue(),temp);
            }

        }
        while(result.size()<k)
        {
            Map.Entry<Integer,List<Integer>> last=thm.pollLastEntry();
            System.out.println(last.getValue());
            result.addAll(last.getValue());
        }

        return result;
    }
    public List<Integer> topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> heap= new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        heap.addAll(map.entrySet());
        while(result.size()<k)
            result.add(heap.poll().getKey());
        return result;
    }
   /* 92. Top K Frequent Words
    Medium

1137

        105

    Add to List

            Share
    Given a non-empty list of words, return the k most frequent elements.

    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

    Example 1:
    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:
    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    Output: ["the", "is", "sunny", "day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.*/
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<String> result=new ArrayList<>();
        for(String word:words)
            hm.put(word,hm.getOrDefault(word,0)+1);
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        for(Map.Entry<String, Integer> entry:hm.entrySet())
        {
            heap.add(entry);
            if(heap.size()>k) heap.poll();
        }

        System.out.println(heap);
        while(!heap.isEmpty())
            result.add(0,heap.poll().getKey());
        return result;


    }

    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String word:words)
            hm.put(word,hm.getOrDefault(word,0)+1);
        ArrayList<String> result=new ArrayList<>(hm.keySet());
        Collections.sort(result,(a,b)->hm.get(a).equals(hm.get(b))?a.compareTo(b):hm.get(b)-hm.get(a));
        return result.subList(0,k);

    }


    /*215. Kth Largest Element in an Array
    Medium

2729

        206

    Add to List

            Share
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap= new PriorityQueue<Integer>((a,b)->a-b);
        for(int num:nums)
        {
            heap.add(num);
            if(heap.size()>k) heap.poll();
        }

        System.out.println(heap);
        return heap.poll();
    }
}
