package Exam.Amazon;

import java.util.Arrays;

//Longest increasing subsequence
 public class LIS {
    public static void main(String[] args) {
        int[] array=new int[]{10,22,9,33,21,50,41,60,80,1};
        lis(array);
    }

    private static int lis(int[] nums) {
        if(nums.length<2) return nums.length;
        int[]res=new int[nums.length];
        res[0]=1;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int maxval=0;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    maxval=Math.max(maxval,res[j]);
                }

            }
            res[i]=maxval+1;
            max=Math.max(max,res[i]);

        }
        return max;
    }
}
