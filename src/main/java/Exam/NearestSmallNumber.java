package Exam;

import java.util.TreeMap;

public class NearestSmallNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 8, 4, 9, 10, 8, 3, 6, 4};
        nearSmall(arr);
    }
        // 5,6,8,4,9,10,8,3,6,4
        // 5:-1
        // 6:1
        // 8: 2
        //4:-1
        //9:4
        //10:5
        //8:-1
        //3:-1
        //6:8
        //4:-1

    private static void nearSmall(int[] arr) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<arr.length;i++)
        {
            tm.put(arr[i],i+1);
        }
        System.out.println(tm);
        for(int i=0;i<arr.length;i++)
        {
            if (tm.lowerKey(arr[i])==null) System.out.println(arr[i]+"-1");
            else {
                int smaller=tm.lowerKey(arr[i]);

                System.out.println(i+"::"+(tm.get(smaller)+1));
            }
        }
    }
}
