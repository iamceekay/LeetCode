package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TestHacker {
    public static void main(String[] args) {
        int[] arr=new int[]{5, 7 ,-5 ,6, 3, 9, -8, 2 ,-1, 10};
        //System.out.println(largestValue(arr));
        ArrayList<Integer> list =new ArrayList<>(Arrays.asList(25107191, 123232501, 151290765, 183012194, 473251358, 579542802, 689345248, 709552565, 803612259, 862726097, 994391793));
        maxPairs(list,440987423);
    }
    static long largestValue(int[] A) {
        int sum=0;
        int[] large=new int[A.length];
        large[0]=A[0];
        int max=A[0];
        int start=0;
        for(int i=1;i<A.length;i++)
        {
            if(large[i-1]>0) large[i]=large[i-1]+A[i];
            else large[i]=A[i];
            if(large[i]>max)
            {
                max=large[i];
            }
            System.out.println(Arrays.toString(large));
        }
        // Return the largest value of any of A's nonempty subarrays.
        return sum;
    }
    public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        // Write your code here
        Collections.sort(skillLevel);
        System.out.println(skillLevel);
        System.out.println(minDiff);
        int i=0,j=skillLevel.size()-1,count=0;
        while(i<j)
        {
            if(skillLevel.get(j)-skillLevel.get(i)>=minDiff)
            {
                System.out.println(j+"j----"+skillLevel.get(j));
                System.out.println(i+"i----"+skillLevel.get(i));
                count++;
                i++;
                j--;
            }
            else i++;
        }
        return count;
    }




}
