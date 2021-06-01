package Concurrency;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array={5,7,7,7,7,7,7,8,8,8,9,10};
        System.out.println(binarySearch(array,7));
    }

    private static int  binarySearch(int[] array,int target) {
        int start=0;
        int end=array.length-1;
        int first=array.length;
        while(start<end)
        {
            int mid=start+(end-start)/2;
            System.out.println(mid + "mid");
            if(array[mid]>=target)
            {
                first=mid;
                end=mid-1;
            }
            else

                start=mid+1;

        }
        return first;
    }
}
