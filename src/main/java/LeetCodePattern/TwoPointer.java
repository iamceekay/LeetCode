package LeetCodePattern;

import java.util.*;

public class TwoPointer {
    public class ListNode {
    int val;
      ListNode next;
     ListNode(int x) { val = x; }}
    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{10, 5, 2, 6},100);

    }
   /* 1. Two Sum
    Easy

12898

        459

    Add to List

            Share
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

            Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].*/

    public int[] twoSum(int[] nums, int target) {
        int n=nums.length,i=0,j=0;
        int[] res=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for( i=0;i<n;i++)
        {
            int value=target-nums[i];
            if(hm.containsKey(value))
            {
                res[0]=i;
                res[1]=hm.get(value);
            }
            hm.put(nums[i],i);
        }

        return res;
    }

   /* 83. Remove Duplicates from Sorted List
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3*/
   public ListNode deleteDuplicates(ListNode head) {
       ListNode current=head;
       while(current!=null && current.next!=null )
       {
           if(current.val==current.next.val)
               current.next=current.next.next;
           else
               current=current.next;
       }

       return head;
   }

  /* 977. Squares of a Sorted Array
            Easy
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



    Example 1:

    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Example 2:

    Input: [-7,-3,2,3,11]
    Output: [4,9,9,49,121]*/
  public int[] sortedSquares(int[] A) {
      int n=A.length;
      int[] result=new int[A.length];
      int i=0,j=n-1;
      for (int p = n - 1; p >= 0; p--) {
          if (Math.abs(A[i]) > Math.abs(A[j])) {
              result[p] = A[i] * A[i];
              i++;
          } else {
              result[p] = A[j] * A[j];
              j--;
          }
      }
      return result;
  }

         /*   Medium


    Add to List

            Share
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

            Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]*/

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> Finallist= new ArrayList<List<Integer>>();
        for(int i=0; i< nums.length-1;i++){
            int k=nums.length-1;
            int j=i+1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!Finallist.contains(temp)){
                        Finallist.add(temp);
                    }
                    k--;
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k] >0){
                    k--;

                }
                else{
                    j++;
                }
            }
        }
        return Finallist;


    }
    /*16. 3Sum Closest
    Medium

1516

        112

    Add to List

            Share
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

            Example:

    Given array nums = [-1, 2, 1, -4], and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */
    public int threeSumClosest(int[] num, int target){
        int result=num[0]+num[1]+num[num.length-1];
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++)
        {
            int start=i+1,end=num.length-1;
            while(start<end){
                int sum=num[i]+num[start]+num[end];
                if(sum>target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)) result=sum;
            }
        }
        return result;
    }
/*
 Subarray Product Less Than K


    Your are given an array of positive integers nums.

    Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

    Example 1:
    Input: nums = [10, 5, 2, 6], k = 100
    Output: 8
    Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
*/

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
