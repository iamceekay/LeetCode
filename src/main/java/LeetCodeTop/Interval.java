package LeetCodeTop;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for an interval. */
 public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals,(o1,o2)->o1.start-o2.start);
        ArrayList<Interval> output=new ArrayList<>();
        int i=0;
        while(i<intervals.size()-1)
        {
            Interval temp=intervals.get(i);
            while(temp.end>intervals.get(i+1).start)
            {
                temp=new Interval(temp.start,Math.max(temp.end,intervals.get(i+1).end));
            }
            output.add(temp);
        }

        return output;

    }
}
