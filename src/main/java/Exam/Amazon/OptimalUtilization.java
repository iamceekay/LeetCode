package Exam.Amazon;

/*Input:
        a = [[1, 2], [2, 4], [3, 6]]
        b = [[1, 2]]
        target = 7

        Output: [[2, 1]]

        Explanation:
        There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
        Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.*/

import java.util.*;

public class OptimalUtilization {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b = {{1, 2}};
        int target = 7;
        int[][] a1= {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] b1= {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int target1=10;
        int[][] a2= {{1, 8}, {2, 15}, {3, 9}};
        int[][] b2= {{1, 8}, {2, 11}, {3, 12}};
        int target2=20;
        List<int[]> res=optimized(a2, b2, target2);
        for (int[] s:res)
            System.out.println(Arrays.toString(s));

    }

    private static List<int[]> optimized(int[][] a, int[][] b, int target) {
        HashMap<Integer, List<int[]>> result = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int[] f : a) {
            for (int[] s : b) {
                int sum = f[1] + s[1];
                if (sum <= target) {
                    if (result.containsKey(sum)) {
                        result.get(sum).add(new int[]{f[0], s[0]});
                    } else {
                        List<int[]> temp = new ArrayList<>();
                        temp.add(new int[]{f[0], s[0]});
                        result.put(sum, temp);
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return result.get(max);
    }
}
