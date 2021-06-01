package GoldmanSach;

import java.util.*;

public class SecondAttempt {
    public static void main(String[] args) {

    }
    public int[][] highFive(int[][] items) {

            TreeMap<Integer, List<Integer>> hm = new TreeMap<>();
            for (int[] item : items) {
                if (!hm.containsKey(item[0]))
                    hm.put(item[0], new ArrayList<Integer>());
                hm.get(item[0]).add(item[1]);
            }
            int[][] result = new int[hm.size()][2];
            int resCounter = 0;
            for (int a : hm.keySet()) {
                List<Integer> val = hm.get(a);
                Collections.sort(val);
                Collections.reverse(val);
                int lengthList = val.size() > 5 ? 5 : val.size();
                int sum = 0;
                for (int i = 0; i < lengthList; i++) {
                    sum += val.get(i);
                }
                int res = sum / lengthList;
                result[resCounter][0] = a;
                result[resCounter++][1] = res;

            }
            return result;

        }
    }
