package Concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("10", "11"));
    }

    private static String addBinary(String a, String b) {
        BigInteger first=new BigInteger(a,2);
        BigInteger second=new BigInteger(b,2);
        BigInteger zero=new BigInteger("0",2);
        BigInteger carry,answer;
        while(second.compareTo(zero)!=0)
        {
            answer=first.xor(second);
            carry=first.and(second).shiftLeft(1);
            first=answer;
            second=carry;
        }
        return first.toString(2);

    }
    public void intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hs1= new HashMap<>();
        HashMap<Integer,Integer> hs2=new HashMap<>();
        for(int n:nums1)
            hs1.put(n,hs1.getOrDefault(n,0)+1);
        for(int n:nums2)
            hs2.put(n,hs2.getOrDefault(n,0)+1);
        List<Integer> result=new ArrayList<Integer>();
        for(int r:nums1)
        {
            if(hs1.get(r)==hs2.get(r)) result.add(r);
        }
        int[] res=new int[result.size()];

    }
}
