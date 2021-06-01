package Exam.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class k1DistinctChar {
    public static List<String> Kdistinct(String s, int k) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int size = s.length();
        int[] count = new int[128];
        int distinctCount = 0;

        for (int i = 0; i < size; i++) {
            Arrays.fill(count, 0);
            distinctCount = 0;
            for (int j = i; j < size; j++) {
                if (count[s.charAt(j)] == 0) {
                    distinctCount++;
                }
                if (distinctCount == k - 1 && j - i + 1== k) {
                    res.add(s.substring(i, j + 1));
                }
                count[s.charAt(j)]++;
            }
        }
        System.out.println("  RESULT "+res);
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        String input = "abacab";
      // List<String> res = Kdistinct(input, n);
        List<String> res = Count(input, n);
        for (String s : res) {
            System.out.println(s);
        }
    }
    public static List<String> Count(String S,int k){
        int[] arr = new int[26];
        TreeSet<String> res = new TreeSet<>();
        for(int i = 0, j = 0; j < S.length(); j++){
            i = Math.max(arr[S.charAt(j) - 'a'], i);
            if(j - i + 1 == k && !res.contains(S.substring(i, j + 1))){
                res.add(S.substring(i, j + 1));
                i++;
            }
            arr[S.charAt(j) - 'a'] = j + 1;
        }
        return new ArrayList<>(res);
    }
}
