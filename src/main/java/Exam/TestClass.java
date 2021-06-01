package Exam;/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {

    public static void main(String args[] ) throws Exception {
        //2 3 4 1
       Object c=null;
       String s=(String) c;
        System.out.println(s);

        // BufferedReader
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a=1;
        while(a-->0)
        {
            String[] nums=br.readLine().trim().split(" ");
            int n=Integer.parseInt(nums[0]);
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=Long.parseLong(br.readLine().trim());
            }
            solution(arr,n);
        }*/

    }

    private static void method(Object o) {
        System.out.println("obj");
    }
   private static void method(Integer o) {
        System.out.println("in");
    }
    private static void method(String o) {
        System.out.println("st");
    }

    static void solution(long[] arr,int n)
    {
        int size=(1<<n)-1;
        long[][] dp=new long[size+1][2];
        for(int i=0;i<size+1;i++)
        {
            dp[i][0]=-1;
            dp[i][1]=-1;

        }
        dp[0][0]=0;
        dp[0][1]=0;
        long minimum=Long.MAX_VALUE;
        long maximum=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if((size & ((1<<i))) !=0)
            {
                for(int j=i+1;j<n;j++)
                {
                    if((size & ((1<<j)))!=0)
                    {
                        int sizeVal=(size & (~(1<<i))) & (~(1<<j));
                        getSolution(dp,sizeVal,arr,n);
                        minimum=Math.min(minimum,(arr[i]^arr[j])+dp[sizeVal][0]);
                        maximum=Math.max(maximum,(arr[i]^arr[j])+dp[sizeVal][1]);
                    }
                }
            }
        }
        System.out.println(minimum+" "+maximum);
    }

    static void getSolution(long[][] dp,int size,long[] arr,int n)
    {
        if(size==0) return;
        if(dp[size][0]!=-1) return;
        long vmin=Long.MAX_VALUE;
        long vmax=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if((size & ((1<<i)))!=0)
            {
                for(int j=i+1;j<n;j++)
                {
                    if((size & ((1<<j)))!=0)
                    {
                        int sizeVal=(size & (~(1<<i))) & (~(1<<j));
                        getSolution(dp,sizeVal,arr,n);
                        vmin=Math.min(vmin,+dp[sizeVal][0]+(arr[i]^arr[j]));
                        vmax=Math.max(vmax,+dp[sizeVal][1]+(arr[i]^arr[j]));
                    }
                }
            }
        }
        dp[size][0]=vmin;
        dp[size][1]=vmax;
        return;

    }
}
