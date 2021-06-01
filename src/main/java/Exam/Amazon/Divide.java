package Exam.Amazon;

public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(8, 3));
        System.out.println(1<<31);
    }

    /*public static int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }*/
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1 ) return Integer.MAX_VALUE;

        //++
        //--
        //+-
        //-+
        // 10 10  10
        // 3   6  12
        //Count =2
        //10-6=4
        //4  4
        //3  6
        //count=1+2
        //1
        //3
        //return count
        boolean flag=(dividend>=0)==(divisor>=0)?true:false;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int result=0;
        while(dividend-divisor>=0)
        {
            int q=0;
            while(dividend-(divisor<<1<<q)>=0)
                q++;

            result+=1<<q;
            dividend-=divisor<<q;
        }
        return flag==true?result:-result;
    }
}
