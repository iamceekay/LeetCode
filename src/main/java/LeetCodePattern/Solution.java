package LeetCodePattern;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int min=Integer.MAX_VALUE;
        int res=0;
        int[] nums=new int[N];
        for (int i = 0; i < N; i++) {
            int t = in.nextInt();
            nums[i]=t;
            if(Math.abs(t-0)<min)
            {
                min=Math.abs(t-0);
                System.out.println("min"+min);
                if(res*-1==t)
                    res=Math.abs(t);
                else res=t;;
            }
        }
        System.out.println(res);
    }
}
