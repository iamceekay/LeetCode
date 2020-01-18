package LeetCodePattern;

import java.util.*;

public class Interval {
    private Integer start;
    private Integer end;

    public Interval(int start, Integer key) {
    }

    public static void main(String[] args) {

    }
    /*56. Merge Intervals
    Medium

2977

        231

    Add to List

            Share
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result =new ArrayList<>();
        if(intervals.length == 0 || intervals == null) return result.toArray(new int[0][]);
        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));

        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] i:intervals)
        {
            if(i[0]<=end){
                end=Math.max(end,i[1]);

            }
            else
            {
                result.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[0][]);
    }

   /* 253. Meeting Rooms II
            Medium

1972

        32

    Add to List

            Share
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    Example 1:

    Input: [[0, 30],[5, 10],[15, 20]]
    Output: 2
    Example 2:

    Input: [[7,10],[2,4]]
    Output: 1*/

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0 || intervals==null)
            return 0;
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];
        int room=0;
        for(int i=0;i<intervals.length;i++)
        {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endTime=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(start[i]<end[endTime])
            {
                room++;
            }
            else
            {
                endTime++;
            }
        }
        return room;

    }
/*
    Examples:
            252. Meeting Rooms*/

    public boolean canAttendMeetings(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        int room = 0;
        for (int v : map.values()) {
            room += v;
            if (room > 1) return false;
        }
        return true;
    }
/*253. Meeting Rooms II*/

    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        int room = 0, k = 0;
        for (int v : map.values())
            k = Math.max(k, room += v);

        return k;
    }
/*731. My Calendar II*/

    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean book(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
            if (k > 2) {
                map.put(s, map.get(s) - 1);
                map.put(e, map.get(e) + 1);
                return false;
            }
        }
        return true;
    }

/*732. My Calendar III*/
    public int book2(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            cnt += v;
            k = Math.max(k, cnt);
        }
        return k;
    }

    /*A bit more complicated:
            56. Merge Interval*/

    public List<Interval> merge2(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        List<Interval> list = new LinkedList<>();
        int start = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (cnt == 0) start = e.getKey();
            // if cnt is 0, that means a full interval has been completed.
            if ((cnt += e.getValue()) == 0)
                list.add(new Interval(start, e.getKey()));
        }
        return list;
    }

}
