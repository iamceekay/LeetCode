package GoldmanSach;

import java.util.Arrays;


public class QuickSortAlgo {
    public static void main(String[] args) {
            int[] num={17,3,1,5,2};
            QuickSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void  QuickSort(int[] array)
    {
        QuickSort(array,0,array.length-1);

    }
    private static void QuickSort(int[] array,int start,int end)
    {
        if(start>=end) return;
        int partition=partition(array,start,end);
        QuickSort(array,start,partition-1);
        QuickSort(array,partition+1,end);
    }
    private static int partition(int[] array,int start,int end)
    {
        int pivot=array[end];
        int boundary=start-1;
        while(start<=end)
        {
            if(array[start]<=pivot)
            {
                boundary++;
                swapvalue(array,start,boundary);
            }
            start++;
        }
        return boundary;
    }

    private static void swapvalue(int[] array, int start, int boundary) {
        int temp=array[start];
        array[start]=array[boundary];
        array[boundary]=temp;
    }
}
