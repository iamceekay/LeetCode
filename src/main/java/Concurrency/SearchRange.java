package Concurrency;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};int target = 8;
        //searchRange(nums,target);
        System.out.println(Math.random());
        System.out.println(Math.random());

    }

    public static void searchRange(int[] nums, int target){
            // Binary Search get the index;
            // increment decrement the index;
            int index = binarySearch(nums, target);
        System.out.println(index);

    }


    public static int binarySearch(int[] nums, int target)
    {
        int start=0;
        int end=nums.length-1;
        while(start<end)
        {
            int mid=(end-start+1)/2;
            if(nums[mid] >target)
                end=mid;
            else if(nums[mid]<target)
                start=mid+1;
            else return mid;
            //System.out.println(mid);
        }
        return -1;

    }

}
