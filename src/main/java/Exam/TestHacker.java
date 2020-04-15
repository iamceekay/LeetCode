package Exam;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestHacker {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,2,3,4};
        int b[]=new int[arr.length];
        b=Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(b));
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i<arr.length-1 && b[i]>b[i+1])
            {
                while (b[i]>b[i+1])
                {
                    b[i]--;
                }

            }
            System.out.println(b[i]);
            sum+=b[i];
            b[i]=arr[i];

        }
        System.out.println(sum);
    }


}
