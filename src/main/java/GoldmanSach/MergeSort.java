package GoldmanSach;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] num={17,3,1,5,2};
        /*mergeSort(num);
        System.out.println(Arrays.toString(num));*/
        System.out.println("------------------");
        mergeSortWrite(num);
        System.out.println(Arrays.toString(num));
    }

    private static void mergeSort(int[] num) {
        if(num.length<2) return;
        int middle=num.length/2;
        int[] left=new int[middle];
        for(int i=0;i<middle;i++)
            left[i]=num[i];
        int[] right=new int[num.length-middle];
        for(int i=middle;i<num.length;i++)
            right[i-middle]=num[i];
        mergeSort(left);
        mergeSort(right);
        merge(left,right,num);

    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length)
        {
            if(left[i]<=right[j])
                result[k++]=left[i++];
            else
                result[k++]=right[j++];
        }
        while(i<left.length)
            result[k++]=left[i++];
        while(j<right.length)
            result[k++]=right[j++];


    }
    public static void mergeSortWrite(int[] nums)
    {
        if(nums.length<2) return;
        int middle=nums.length/2;
        int[] left=new int[middle];
        int[] right=new int[nums.length-middle];
        for(int i=0;i<middle;i++)
        left[i]=nums[i];
        for(int i=middle;i<nums.length;i++)
            right[i-middle]=nums[i];
        mergeSortWrite(left);
        mergeSortWrite(right);
        mergeSelf(left,right,nums);
    }

    private static void mergeSelf(int[] left, int[] right, int[] nums) {
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length) {
            if (left[i] <= right[j])
                nums[k++] = left[i++];
            else nums[k++] = right[j++];

        }

            while (i<left.length)
                nums[k++]=left[i++];
            while (j<right.length)
                nums[k++]=right[j++];

    }

}
