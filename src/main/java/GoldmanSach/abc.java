package GoldmanSach;


import java.util.ArrayList;
import java.util.List;

 class Main {
     public static void main(String[] args) {
         cntBits(new int[]{1,3,5});
     }
     public static int cntBits(int[] A) {
         int sum=0;
         for(int i=0;i<A.length;i++)
         {
             for(int j=i+1;j<A.length;j++)

             {
                 System.out.println(A[i]+" "+A[j]);
                 System.out.println("A[i]&A[j]");
                 System.out.println(A[i]&A[j]);
                 sum+=A[i]&A[j];
             }
         }
         System.out.println("Final"+sum);
         return sum;
     }
}
