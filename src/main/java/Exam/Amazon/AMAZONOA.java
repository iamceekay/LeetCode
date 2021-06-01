package Exam.Amazon;

import java.util.*;

public class AMAZONOA {
    public static void main(String[] args) {
        System.out.println(numberOfItems("*|*|*|", new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(6))));
    }
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        List<Integer>  result=new ArrayList<>();
        HashMap<Integer,Integer> hm= new HashMap<>();
        int sumTemp=0,end=0,first=0;
        int[] right=new int[s.length()];
        int[] left=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='|')
            {
                hm.put(i,sumTemp);
            }
            else sumTemp++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='|')
                first=i;
            left[i]=first;
        }
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='|')
                end=i;
            right[i]=end;
        }
        for(int i=0;i<startIndices.size();i++)
        {
            int tempS=right[startIndices.get(i)-1];
            int tempE=left[endIndices.get(i)-1];
            if(tempS<tempE) result.add(hm.get(tempE)-hm.get(tempS));
            else result.add(0);
        }
        return result;
    }


    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        System.out.println(arr);
        List<Integer> result=new ArrayList<>();
        double target =0.0;
        for(int a:arr) target+=a;
        target=target/2;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.addAll(arr);
        int tempValue=0;
        while(tempValue<=target)
        {
            int val=pq.poll();
            tempValue+=val;
            result.add(val);

        }
        Collections.reverse(result);
        return result;
    }
}
