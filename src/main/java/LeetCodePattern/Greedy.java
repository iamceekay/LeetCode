package LeetCodePattern;

import java.util.Arrays;

public class Greedy {
/*
252. Meeting Rooms
    Easy

452

        32

    Add to List

            Share
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

    Example 1:

    Input: [[0,30],[5,10],[15,20]]
    Output: false
    Example 2:

    Input: [[7,10],[2,4]]
    Output: true
*/

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<1) return true;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int[] start=intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<start[1])
                return false;
            start[1]= intervals[i][1];
        }
        return true;
    }


    /*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    Example 1:

    Input: [[0, 30],[5, 10],[15, 20]]
    Output: 2
    Example 2:

    Input: [[7,10],[2,4]]
    Output: 1
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length<1) return 0;
        Arrays.sort(intervals,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        System.out.println(Arrays.deepToString(intervals));
        int[] start=intervals[0];
        int count=1;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<start[1]){
                count++;
            }
            start[1]=intervals[i][1];

        }
        return count;

    }
    public int minMeetingRooms2(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }
        return rooms;
    }


    public int coinChange(int[] coins, int N) {
        Arrays.sort(coins);
        int count=0;
        int index = coins.length-1;
        while(N!=0 && index >=0){
            int coinValue = coins[index];
            index--;
            int maxAmount = (N/coinValue)*coinValue;
            if(maxAmount>0) {
                System.out.println("Coin value: "+coinValue+ " taken count: "+(N/coinValue));
                count=count+N/coinValue;
                N = N - maxAmount;

            }

        }
        return N!=0?-1:count;
    }
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}
