package Concurrency;

public class fer {
    public static void main(String[] args) {
        String word1="leetcode";
        for(int i=0;i<word1.length();i++)
        {
           // System.out.println(word1.substring(0,i)+"-------Value");
          //  System.out.println(word1.substring(i+1)+"-------Value");
           System.out.println((word1.substring(0,i)+word1.substring(i+1)));

        }
    }

}
