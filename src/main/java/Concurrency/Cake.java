package Concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cake {


    public static void main(String[] args) {
        int[] horizontalCuts ={1,2,4};
        int[] verticalCuts ={1,3};
     //   maxArea(5,4,horizontalCuts,verticalCuts);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(12);
        queue.add(23);
        queue.add(123333);
        for(int q:queue)
        {
            System.out.println(q);
        }

    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = 0;
        int maxV = 0;
        double MOD=1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
        return (int)(maxH % (MOD) * maxV % (MOD));
    }
}
