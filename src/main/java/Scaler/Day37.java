package Scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class Day37 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, -4, -1, 4}));
    }

    public static int[] solve(int[] A) {
        for(int i=1;i<A.length;i++)
        {
            if(A[i]<0)
                swap(A,i,i-1);
        }
        System.out.println(Arrays.toString(A));
        return A;

    }

    private static void swap(int[] a, int i, int i1) {
        int temp=a[i];
        a[i]=a[i1];
        a[i1]=temp;



    }


}
