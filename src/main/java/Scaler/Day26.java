package Scaler;

import java.util.ArrayList;

public class Day26 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,8},2));
    }
    public static int solve(int[] A, int B) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(A[i]);
            for (int j = 0; j < A.length; j++) {
                list.add(A[j]);
                if (list.size() == B) {
                    System.out.println(list);
                    for (int li : list) sum += li;
                    if (sum <= 1000) count++;
                }
            }
        }
        return count;
    }

}
