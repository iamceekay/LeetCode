package Exam.Amazon;

import java.util.Arrays;
import java.util.Scanner;

public class rightRotate {
    public static void main(String[] args) {
       // rightRotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        Scanner sc = new Scanner(System.in);
        System.out.print("choose the size of array:"+" ");
        int N = sc.nextInt();
        System.out.println("Choose the breakpoint");
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0;i < N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int[] arr2= revArray(arr,0,K-1);

        for(int i = 0;i < K;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        int [] arr3 = revArray(arr, K, N-1);    //problem here
        for(int i = 0; i<(N-K);i++){
            System.out.print(arr3[i]+" ");
        }
    }

    public static void rightRotate(int[] array, int k) {
        int n = array.length;
        //Last k Element
        reverse(array, n - k, n - 1);
        //first n-k element
        reverse(array, 0, n - k - 1);
        //Reverse whole array
        reverse(array, 0, n - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array, int low, int high) {
        while (low <= high) {
            swap(array, low, high);
            low++;
            high--;
        }
    }

    public static void swap(int[] array, int low, int high) {
        int data = array[low];
        array[low] = array[high];
        array[high] = data;
    }

    static int[] revArray(int[] a, int start, int end) {
        while (start < end) {      //reversing the array
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

}