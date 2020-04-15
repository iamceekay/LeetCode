package GoldmanSach;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] b={3,5,2,4,1,1};
        solve("abbaba",b,"ab");
    }
    public static int solve(String A, int[] B, String C) {
        int res=0;
        HashMap<Character, List<Integer>> hm= new LinkedHashMap<>();
        int i=0;
        for(char c:A.toCharArray())
        {
            if(!hm.containsKey(c))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(B[i++]);
                hm.put(c,list);
            }
            else
            {
                hm.get(c).add(B[i++]);
            }
        }
        System.out.println(hm);
        for(char c:C.toCharArray())
        {
            List<Integer> list= hm.get(c);

            Collections.sort(list);
            System.out.println(list);
            res+=list.get(0);

        }
        System.out.println(res);
        return res;
    }
}
