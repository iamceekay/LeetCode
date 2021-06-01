package JulyLeetCode;
//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
//Arranging Coins
public class Day1ArrangingCoins {
    public static void main(String[] args) {
        arrangeCoins(5);
    }
    public static int arrangeCoins(int n) {
        int counter=0;
        while(n>=0)
        {
            counter++;
            n=n-counter;
        }
        return counter-1;
    }
}
