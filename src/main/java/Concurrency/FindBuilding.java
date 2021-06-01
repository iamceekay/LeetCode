package Concurrency;

import java.util.Stack;

public class FindBuilding {
    public static void main(String[] args) {

    }
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st=new Stack<Integer>();
        //   while(i<heights.length)
        for(int i=0;i<heights.length;i++)
        {
            if(st.isEmpty()) st.push(i);
            else if(heights[i]>heights[st.peek()])
            {
                while(heights[i]>heights[st.peek()])
                {
                    st.pop();
                }
            }
            else
            {
                st.push(i);
            }
        }
        System.out.println(st);
        return new int[0];
    }
}
