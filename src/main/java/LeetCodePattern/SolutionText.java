package LeetCodePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionText {
    public static void main(String[] args) {
            TimeMap time=new TimeMap();
            time.set("a","1");
            time.set("a","2");
            time.set("a","3");
            time.set("a","4");
            time.set("b","4");
        System.out.println(time.get("a",3));

    }
   static class Data {
        String val;
        int time;
        Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
     static class TimeMap {

        /** Initialize your data structure here. */
        private  Map<String, List<Data>> map;
        int starttime;
        public TimeMap() {
            map = new HashMap<String, List<Data>>();
            starttime=1;
        }

        public  void set(String key, String value) {
            int timestamp=starttime++;
            if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
            map.get(key).add(new Data(value, timestamp));
        }
        public  String get(String key) {
           return get(key,starttime-1);
        }

        public  String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(map.get(key), timestamp);
        }

        protected  String binarySearch(List<Data> list, int time) {
            int low = 0, high = list.size() - 1;
            while (low < high) {
                int mid = (low + high) >> 1;
                if (list.get(mid).time == time) return list.get(mid).val;
                if (list.get(mid).time < time) {
                    if (list.get(mid+1).time > time) return list.get(mid).val;
                    low = mid + 1;
                }
                else high = mid -1;
            }
            return list.get(low).time <= time ? list.get(low).val : "";
        }
    }


}
