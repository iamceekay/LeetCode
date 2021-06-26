package Concurrency;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] array={1,3,5,4,7,9,10,11};
        longestIncreasingSub(array);
    }

    private static void longestIncreasingSub(int[] array) {
         int[] result=new int[array.length];
         result[0]=1;
         int max=0;
         int start=0;
         int end=0;
         int j=0;
         for(int i=1;i<array.length;i++)
         {
             result[i]=1;
             if(array[i]>array[i-1])
             {

                 result[i]=result[i-1]+1;


                /* if(result[i]>max)
                 {
                     start=j;
                     end=i;
                     max=result[i];
                 }*/
                max= max=Math.max(result[i],max);

             }
         }
        System.out.println(max);
        System.out.println(start+" "+ end);
    }
}
