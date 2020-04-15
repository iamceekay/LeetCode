package GoldmanSach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoldmanSach {
    public static void main(String[] args) {
        pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }


   /* Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.  */

    public void gameOfLife(int[][] board) {

        int m=board.length;
        int n=board[0].length;
        int[][] output=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               int neighbour= countNeighbour(i,j,board);
               if(board[i][j]==1)
               {
                   if(neighbour<2) output[i][j]=0;
                   if(neighbour==2 ||neighbour==3 ) output[i][j]=1;
                   if(neighbour>3) output[i][j]=0;

               }
               else if(board[i][j]==0 && neighbour==3)  output[i][j]=1;
            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=output[i][j];
            }
        }

    }

    private int countNeighbour(int i, int j, int[][] board) {
        int count=0;
        int[][] direction={{0,1},{0,-1},{1,1},{1,-1},{-1,0},{-1,-1},{-1,1},{1,0}};
        for(int[] dir:direction)
        {
            int x=i+dir[0];
            int y=j+dir[0];
            if(x>=0 && y>=0 && x<board.length && y<board[i].length)
            {
                count+=board[x][y];
            }
        }
        return count;
    }

    /*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

    Example:

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6*/

    public int trap(int[] height) {
        int sum=0;
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        int leftMaxVal=Integer.MIN_VALUE;
        int rightMaxVal=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++)
        {
            leftMaxVal= Math.max(height[i],leftMaxVal);
            leftmax[i]=leftMaxVal;
        }
        for(int i=height.length-1;i>=0;i--)
        {
            rightMaxVal= Math.max(height[i],rightMaxVal);
            rightmax[i]=rightMaxVal;
        }
        for(int i=0;i<height.length;i++)
        {
            sum+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return sum;
    }

   /* 209. Minimum Size Subarray Sum
    Medium

1668

        91

    Add to List

            Share
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example:

    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.*/

    public int minSubArrayLen(int s, int[] a) {
        if(a.length==0) return 0;
        int i=0,j=0,sum=0,min=Integer.MAX_VALUE;
        while(i<a.length)
        {
            sum+=a[i++];
            while(sum>=s)
            {
                min=Math.min(min,i-j);
                sum-=a[j++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }


    public int[] productExceptSelf(int[] nums) {
        int[] temp=new int[nums.length];
        temp[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            temp[i]=temp[i-1]*nums[i-1];
        }
        System.out.println(Arrays.toString(temp));
        int[] tempr=new int[nums.length];
        tempr[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            tempr[i]=tempr[i+1]*nums[i+1];

        }
        for(int i=0;i<nums.length;i++)
        {
            tempr[i]=temp[i]*tempr[i];
        }
        return tempr;
    }


   /* 78. Subsets
            Medium

2861

        68

    Add to List

            Share
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
            [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
            ]*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backTrack(list,new ArrayList<Integer>(),nums,0);
        return  list;
    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<Integer>(tempList));
        for(int i=start;i<nums.length;i++)
        {
            tempList.add(nums[i]);
            backTrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }

    }

    public static int pivotIndex(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int leftSum=0;
        int rightSum=0;
        while(i<j){
            if(leftSum >0 && rightSum >0 && leftSum==rightSum) break;
            if(nums[i]<nums[j])
            {
                leftSum+=nums[i++];
            }
            else
            {
                rightSum+=nums[j--];
            }
        }
        System.out.println(" pivot "+nums[i]);
        System.out.println(" left "+leftSum);
        System.out.println(" right "+rightSum);
        return i+1;
    }
}
