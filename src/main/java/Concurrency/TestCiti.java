package Concurrency;

import java.util.Arrays;

public class TestCiti {
    public static void main(String[] args) {
        int[] a=new int[]{2,2,2,2,2,3,4,4,4,4,6};
        System.out.println(solution(a));
        int[] b=new int[]{1,3,5,7,9};
      //  System.out.println(velocity(b));
    }

    private static int velocity(int[] A) {
        int total_periods = 0, particles_size = A.length;
        for (int i = 0; i < particles_size; i++) {
            for (int count = 0; i + 2 < particles_size && A[i + 1] - A[i] == A[i + 2] - A[i + 1]; i++) {
                count++;
                total_periods += count;
            }
        }
        return total_periods < 1000000000 ? total_periods : -1;
    }


    static int solution(int[] A) {
            int n = A.length;
            int[] L = new int[n + 1];
            L[0] = -1;
            for (int i = 0; i < n; i++) {
                L[i + 1] = A[i];
            }
            int count = 0;
        System.out.println(Arrays.toString(L));
        int pos = (n + 1) / 2;
            int candidate = L[pos];
            for (int i = 1; i <= n; i++) {
                if (L[i] == candidate)
                    count = count + 1;
            }
            if (count > pos)
                return candidate;
            return (-1);
        }

}
