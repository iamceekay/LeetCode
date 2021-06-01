package JulyLeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day3PrisonCell {
    public static void main(String[] args) {
     int[] cell  = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
     prisonAfterNDays(cell,24);

    }
    public static int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            seen.put(Arrays.toString(cells), N--);
            cells = prisonAfterNDays(cells);
            System.out.println(seen);
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;

    }

    public int[] prisonAfterNDaysEasy(int[] cells, int N) {
        N = N%14 == 0 ? 14 : N%14;
        for(int i=0;i<N;i++)
            cells=prisonAfterNDays(cells);
        return cells;

    }
    public static int[] prisonAfterNDays(int[] cells)
    {
        int[] nextDay=new int[8];
        for(int i=1;i<cells.length-1;i++)
            nextDay[i]=cells[i-1]==cells[i+1]?1:0;
        return nextDay;
    }
}
