package Concurrency;

public class Codility {
    public static void main(String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(-1));
        System.out.println(solution(-999));
    }

    private static int solution(int N) {
        String number=String.valueOf(N);
        boolean negative=false;
        if(number.charAt(0)=='-'){
            negative=true;
            number=number.substring(1);
        }
        int max=Integer.valueOf(5+number);
        for(int i=0;i<number.length();i++)
        {
            String temp=number.substring(0,i+1)+"5"+number.substring(i+1);
            if(negative)
                max=Math.min(max,Integer.valueOf(temp));
            else
                max=Math.max(max,Integer.valueOf(temp));
        }
        return negative?-1*max:max;
    }
    }

