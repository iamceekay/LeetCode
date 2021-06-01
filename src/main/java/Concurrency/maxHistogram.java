package Concurrency;

import java.util.Arrays;
import java.util.Stack;

public class maxHistogram {
    public static void main(String[] args) {
        int[] array=new int[]{2,1,5,6,2,3};
        histogram(array);
    }

        private static void histogram(int[] height) {
        int[] rb=new int[height.length];
        rb[height.length-1]=height.length;
        Stack<Integer> st=new Stack<>();
        st.push(height.length-1);
        for(int i=height.length-2;i>=0;i--)
        {
            while(st.size()>0 && height[st.peek()] >= height[i])
                st.pop();
            if(st.size()==0)
                rb[i]=height.length;
            else
                rb[i]=st.peek();
            st.push(i);
        }
         st=new Stack<>();
        int[] lb=new int[height.length];
        lb[0]=-1;
        st.push(0);
        for(int i=1;i<height.length;i++)
        {
            while(st.size()>0 && height[st.peek()] >= height[i])
                st.pop();
            if(st.size()==0)
                lb[i]=-1;
            else
                lb[i]=st.peek();
            st.push(i);
        }
        System.out.println(Arrays.toString(lb));
        System.out.println(Arrays.toString(rb));

        int maxArea=0;
        for(int i=0;i<height.length;i++) {
            int width = rb[i] - lb[i] - 1;
            int area = height[i]*width;
            maxArea=Math.max(area,maxArea);
        }
        System.out.println(maxArea);

    }
}
