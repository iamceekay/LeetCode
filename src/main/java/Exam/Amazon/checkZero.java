package Exam.Amazon;

public class checkZero {
    public static void main(String[] args) {
       // System.out.println(checkZeroOnes("11"));
        checkZero ch=new checkZero();
        System.out.println(ch.stoneGameVIII(new int[]{-39,-23,-43,-7,25,-36,-32,17,-42,-5,-11}));
    }

    public static boolean checkZeroOnes(String s) {
        int countone=1;
        int countzero=1;
        int maxOne=0,maxZero=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)=='1' && s.charAt(i)=='1'){
                countone++;
                maxOne=Math.max(maxOne,countone);
            }
            else countone=1;
            if(s.charAt(i-1)=='0' && s.charAt(i)=='0'){
                countzero++;
                maxZero=Math.max(maxZero,countzero);
            }
            else countzero=1;

        }
        System.out.println(maxOne);
        System.out.println(maxZero);
        return maxOne>maxZero;
    }

    public int stoneGameVIII(int[] stones) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<stones.length;i++)
        {
            sum+=stones[i];
            if(i>1)max= Math.max(optimalBob(sum,i+1,stones),max);
            else max= sum;

        }

        return max;
    }
    public int optimalBob(int alice,int start,int[] stones) {
        int bob=0;
        for(int i=start;i<stones.length;i++)
        {
            if(i==start) bob=alice;
                bob+=stones[i];
        }
        System.out.println(alice - bob);
        return alice-bob;
    }
}
