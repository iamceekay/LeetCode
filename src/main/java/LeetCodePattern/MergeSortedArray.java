package LeetCodePattern;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MergeSortedArray {
    public static void main(String[] args) {
        HashMap<Object, Object> hm = new HashMap<>();
        BigInteger x = new BigInteger("10101", 2);
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        for(int l:list)
        {
            list.remove(l);
        }
        System.out.println(x);
        int[] first={1,2,3,4,5};
        int[] second={2,5,7,9};
        int[] result=new int[first.length+second.length];
        int p1=0;
        int p2=0;
        int k=0;
        while(p1<first.length && p2<second.length)
        {
            result[k++]=first[p1]<=second[p2] ?first[p1++]:second[p2++];
        }
        System.out.println(Arrays.toString(result));
        while(p1<first.length)
        {
            result[k++]=first[p1++];
        }
        while(p2<second.length)
        {
            result[k++]=second[p2++];
        }
        System.out.println(Arrays.toString(result));
    }

}
