package Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> value= new ArrayList<>();
        HashSet<Integer> result= new HashSet<>();
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1>n2?1:2;
        if(n==1)
        {
            for(int a:nums1) value.add(a);
            for(int a:nums2)
                if(value.contains(n)) result.add(n);
        }
        else
        {
            for(int a:nums2) value.add(a);
            for(int a:nums1)
                if(value.contains(n)) result.add(n);
        }
        int[] resultA=new int[result.size()];
        int i=0;
        for(int a:result)
            resultA[i++]=a;
        return resultA ;
    }
}
