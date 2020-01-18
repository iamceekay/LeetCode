package LeetCodeTop;

import java.util.HashMap;

public class TopCode {
    public static void main(String[] args) {
        getHint("1807","7810");

    }
    public static String getHint(String secret, String guess) {
        HashMap<Integer,Character> hm =new HashMap<>();
        int bull=0,cows=0;
        for(int i=0;i<guess.length();i++)
        {
            hm.putIfAbsent(i,guess.charAt(i));

        }
        for(int i=0;i<secret.length();i++)
        {
            if(secret.charAt(i)==(hm.get(i)))
            {
                bull++;
                hm.remove(i);
            }
            else if(!(secret.charAt(i)==hm.get(i)) && hm.values().contains(secret.charAt(i)))
            {
                cows++;
            }

        }
        System.out.println(bull+"A"+cows+"B");
        return bull+"A"+cows+"B";
    }

}
