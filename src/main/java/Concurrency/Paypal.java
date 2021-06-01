package Concurrency;



import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static Concurrency.Paypal.SpeedMeter.*;


public class Paypal {
    static HashSet<Integer> hs=new HashSet<>();
    public static void main(String[] args) throws java.io.IOException {
       /* StringBuilder sb = new StringBuilder("DoSelectlab");
        //String s1="DoSelectlab";
        sb.delete(2,5);
        System.out.println(sb);*/
        /*ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("E");
        list.add("D");
        list.add(1,"B");
        list.add(4,"F");
        System.out.println(list);*/
        System.out.println(1%2);

    }

    private static void paypalSolve(int N, int[] A) {
        Stack<Integer> st=new Stack<>();
        int MOD=1000000007;
        st.push(0);
        for(int i=1;i<N;i++)
        {
            if(st.isEmpty() || A[st.peek()]>=A[i])
            {
                st.push(i);
            }
            while(!st.isEmpty() && A[i] > A[st.peek()] )
            {
                st.pop();
            }
            st.push(i);

        }
        System.out.println(st);


    }

    static long solve(int l, int r){
        // Your code goes here
        long sum=0;
        for(int a=l;a<=r;a++)
        {
            if(hs.contains(a))
            {
                sum=sum+a;
            }
            else if(beautiful(a)){
                sum=sum+a;
            }
        }
        return sum;



    }
    static boolean beautiful(int n)
    {
        if(n<=0) return false;
        int slow=n, fast=n;
        do{
            slow=nextSquareValue(slow);
            fast=nextSquareValue(fast);
            fast=nextSquareValue(fast);
            if(fast==1){
                hs.add(n);
                return true;
            }
        }while(slow!=fast);
        return false;
    }
    static int nextSquareValue(int n)
    {
        int totalSum=0;
        while(n>0)
        {
            int a=n%10;
            n=n/10;
            totalSum+=a*a;
        }
        return totalSum;
    }
    class SpeedMeter
    {
        public final static  int MAX_VALUE=180;
    }
}