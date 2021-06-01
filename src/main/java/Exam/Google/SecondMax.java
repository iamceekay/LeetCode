package Exam.Google;

public class SecondMax {
    public static void main(String[] args) {
        System.out.println(secondMax(new int[]{1,2,3}));
    }

    private static int secondMax(int[] ints) {
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for(int a:ints)
        {
            if(a>max)
            {
                secondMax=max;
                max=a;
            }
            if(a<max && a>secondMax)
                secondMax=a;
        }
        System.out.println(secondMax);
        return max;
    }
}
