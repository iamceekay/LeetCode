package LeetCodePattern;

import java.util.*;

class Parent
{
    public static void main(String[] args) {
        //nonRepeatingDigitProductCount(2,10,15);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        System.out.println(getCountOfPossibleTeams(list));
    }
    static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int counter=0;
        while(y<=z)
        {
            String val=String.valueOf(y);
            boolean flag=true;
            HashSet<Character> hs=new HashSet<>();
            for(char c:val.toCharArray())
                hs.add(c);
            int finalRes=x*y;
            String check=String.valueOf(finalRes);
            System.out.println(hs);
            for(char c:check.toCharArray()) {
                if (hs.contains(c)) {
                    flag = false;
                    System.out.println("invalid" + check);
                    break;
                }
            }
            y++;
            if(flag)counter++;

        }
        System.out.println(counter);
        return counter;

    }
   private static int getCountOfPossibleTeams(List<Integer> coders) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int count=1;
        int result=0;
        for(int a:coders) hm.put(count++, a);
        for(int i=1;i<=hm.size();i++)
            for(int j=i+1;j<=hm.size();j++)
                for(int k=j+1;k<=hm.size();k++)
                    if(i< j && j <k)
                        if((hm.get(i)<hm.get(j) && hm.get(j)<hm.get(k)) || (hm.get(i)>hm.get(j) && hm.get(j)>hm.get(k)))
                            result++;
        return result;

    }
}