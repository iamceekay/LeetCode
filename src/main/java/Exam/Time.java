package Exam;

import java.util.*;

public class Time {
    public static void main(String[] args) {
       /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int a = sc.nextInt();
            int[][] grid=new int[50][50];
            while(a>0)
            {
                int v=sc.nextInt();
                int j=sc.nextInt();
                grid[v][j]=1;
                a--;

            }
            //System.out.println(grid);
            System.out.println(minTotalDistance(grid));
        }*/

       /* Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int a = sc.nextInt();
            int[][] grid = new int[50][50];
            while (a > 0) {
                int v = sc.nextInt();
                int j = sc.nextInt();
                grid[v][j] = 1;
                a--;

            }
            //System.out.println(grid);
            System.out.println(minTotalDistance(grid));

       }*/
        System.out.println(nextClosestTime3("12:36:09"));
    }

        public static String nextClosestTime (String time){
            HashMap<Integer, Integer> hs = new HashMap<>();
            int hour = Integer.valueOf(time.substring(0, 2));
            int minute = Integer.valueOf(time.substring(3, 5));
            int second = Integer.valueOf(time.substring(6, 8));
            if (hour > 23 || minute > 60 || second > 60) return "INVALID";
            while (true) {
                int a = 0;
                hs.put(Integer.valueOf(time.charAt(0) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(0) - '0'), 0) + 1);
                hs.put(Integer.valueOf(time.charAt(1) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(1) - '0'), 0) + 1);
                hs.put(Integer.valueOf(time.charAt(3) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(3) - '0'), 0) + 1);
                hs.put(Integer.valueOf(time.charAt(4) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(4) - '0'), 0) + 1);
                hs.put(Integer.valueOf(time.charAt(6) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(6) - '0'), 0) + 1);
                hs.put(Integer.valueOf(time.charAt(7) - '0'), hs.getOrDefault(Integer.valueOf(time.charAt(7) - '0'), 0) + 1);
               /* second = second % 60;
                hour = second / 60;
                minute = hour % 60;
                hour = hour / 60;*/
               second++;
               if(second>59) {
                   minute++;
                   second = 0;
               }
               if(minute>59)
               {
                   hour++;
                   minute=0;
               }
                if(hour >23 )
                {
                    hour=0;
                    minute=0;
                    second=0;
                }
               /*
                second = second / 60;
                minute = (minute + second / 60) % 60;
                hour = (hour + minute / 60) % 24;*/
                if (hour == 10 && minute == 23 && second == 33) {
                    System.out.println("check");
                }
                if (hs.containsKey(second / 10) && hs.get(second / 10) > 0) {
                    a = a + 1;
                    hs.put((second / 10), hs.get((second / 10)) - 1);
                }
                if (hs.containsKey(second % 10) && hs.get(second % 10) > 0) {
                    a = a + 1;
                    hs.put((second % 10), hs.get((second % 10)) - 1);
                }
                if (hs.containsKey(minute / 10) && hs.get(minute / 10) > 0) {
                    a = a + 1;
                    hs.put((minute / 10), hs.get((minute / 10)) - 1);
                }
                if (hs.containsKey(minute % 10) && hs.get(minute % 10) > 0) {
                    a = a + 1;
                    hs.put((minute % 10), hs.get((minute % 10)) - 1);
                }
                if (hs.containsKey(hour / 10) && hs.get(hour / 10) > 0) {
                    a = a + 1;
                    hs.put((hour / 10), hs.get((hour / 10)) - 1);
                }
                if (hs.containsKey(hour % 10) && hs.get(hour % 10) > 0) {
                    a = a + 1;
                    hs.put((hour % 10), hs.get((hour % 10)) - 1);
                }

                System.out.println(hour+"hour");
                System.out.println(minute+"minute");
                System.out.println(second+"sec");


           /* if(hs.contains(hour/10) && hs.contains(hour%10) && hs.contains(minute/10) && hs.contains(minute%10) && hs.contains(second/10) && hs.contains(second%10))
                break;*/
                hs.clear();
                if (a == 6) break;
            }
            return String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
        }

   /* public static String nextClosestTime(String time) {
        char[] res = time.toCharArray(); // res contains original time order
        char[] digits = new char[]{res[0], res[1], res[3], res[4],res[6],res[7]}; // omit char ':'

        Arrays.sort(digits);
        res[7] = findNext(res[7], '9', digits);
        if (res[7]>time.charAt(7)) return new String(res);

        res[6] = findNext(res[6], '5', digits);
        if (res[6]>time.charAt(6)) return new String(res);


        res[4] = findNext(res[4], '9', digits);
        if (res[4]>time.charAt(4)) return new String(res);

        res[3] = findNext(res[3], '5', digits);
        if (res[3]>time.charAt(3)) return new String(res);

        res[1] = findNext(res[1], res[0] == '2' ? '3' : '9', digits);
        if (res[1]>time.charAt(1)) return new String(res);

        res[0] = findNext(res[0], '2', digits);

        return new String(res);
    }

    private static char findNext(char cur, char upper, char[] digits) {
        if (cur>=upper) {
            return digits[0];
        }

        int pos = Arrays.binarySearch(digits, cur)+1;
        // pos suppose to be already at the index of the element which is bigger than or equals to cur, there could be duplications.
        // traverse one by one to find next greater digit, also avoid duplications by '=='
        while (pos<4 && (digits[pos] > upper || digits[pos] == cur)) {
            // TODO: if digits[pos] > upper we probably can return digtis[0] directly since digits is in asc order
            pos++;
        }

        return pos == 4 ? digits[0] : digits[pos];
    }*/
        public static int minTotalDistance ( int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            List<Integer> I = new ArrayList<>(m);
            List<Integer> J = new ArrayList<>(n);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        I.add(i);
                        J.add(j);
                    }
                }
            }

            int val = findMin(I) + findMin(J);
            int count=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            System.out.println(count+"COunt");
            return val;
        }

        private static int findMin (List < Integer > list) {
            int ret = 0;

            Collections.sort(list);

            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                ret += list.get(j--) - list.get(i++);
            }

            return ret;
        }


    public static String nextClosestTime2(String time) {
        char[] timeArray = time.toCharArray();
        List<Character> charArray = new ArrayList<>();
        TreeMap<Character,Integer> set=new TreeMap<>();
        for(char c : timeArray) {
            charArray.add(c);
        }

       TreeSet<Character> set1 = new TreeSet<>(charArray);
       // set.remove(':');
        set.put(time.charAt(0), set.getOrDefault(time.charAt(0) , 0) + 1);
        set.put(time.charAt(1), set.getOrDefault(time.charAt(1) , 0) + 1);
        set.put(time.charAt(3), set.getOrDefault(time.charAt(3) , 0) + 1);
        set.put(time.charAt(4), set.getOrDefault(time.charAt(4) , 0) + 1);
        set.put(time.charAt(6), set.getOrDefault(time.charAt(6) , 0) + 1);
        set.put(time.charAt(7), set.getOrDefault(time.charAt(7) , 0) + 1);
        timeArray[7] = getMinChar(set, charArray.get(7), '9');
        if(timeArray[7] > charArray.get(7)) return new String(timeArray);

        timeArray[6] = getMinChar(set, charArray.get(6), '5');
        if(timeArray[6] > charArray.get(6)) return new String(timeArray);

        timeArray[4] = getMinChar(set, charArray.get(4), '9');
        if(timeArray[4] > charArray.get(4)) return new String(timeArray);

        timeArray[3] = getMinChar(set, charArray.get(3), '5');
        if(timeArray[3] > charArray.get(3)) return new String(timeArray);

        timeArray[1] = getMinChar(set, charArray.get(1), charArray.get(0) == '2' ? '3' : '9');
        if(timeArray[1] > charArray.get(1)) return new String(timeArray);

        timeArray[0] = getMinChar(set, charArray.get(0), '2');
        return new String(timeArray);
    }

    private static char getMinChar(TreeMap<Character,Integer> set, char n, char limit) {
            for(char c: set.keySet())
            {
                if(set.get(c)<1) set.remove(c);
            }
        Character highChar  =set.firstKey();
            set.put(highChar,set.get(highChar)-1);
        return (highChar == null || highChar > limit) ? 0 : highChar;
    }

    public static String nextClosestTime3(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4],result[6],result[7]};
        Arrays.sort(digits);

        // find next digit for HH:M_

        result[7] = findNext(result[7], (char)('9' + 1), digits);  // no upperLimit for this digit, i.e. 0-9
        if(result[7] > time.charAt(7)) return String.valueOf(result);  // e.g. 23:43 -> 23:44

        // find next digit for HH:_M
        result[6] = findNext(result[6], '5', digits);
        if(result[6] > time.charAt(6)) return String.valueOf(result);  // e.g. 14:29 -> 14:41

        result[4] = findNext(result[4], (char)('9' + 1), digits);  // no upperLimit for this digit, i.e. 0-9
        if(result[4] > time.charAt(4)) return String.valueOf(result);  // e.g. 23:43 -> 23:44

        // find next digit for HH:_M
        result[3] = findNext(result[3], '5', digits);
        if(result[3] > time.charAt(3)) return String.valueOf(result);  // e.g. 14:29 -> 14:41

        // find next digit for H_:MM
        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
        if(result[1] > time.charAt(1)) return String.valueOf(result);  // e.g. 02:37 -> 03:00

        // find next digit for _H:MM
        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);  // e.g. 19:59 -> 11:11
    }

    /**
     * find the next bigger digit which is no more than upperLimit.
     * If no such digit exists in digits[], return the minimum one i.e. digits[0]
     * @param current the current digit
     * @param upperLimit the maximum possible value for current digit
     * @param digits[] the sorted digits array
     * @return
     */
    private static char findNext(char current, char upperLimit, char[] digits) {
        //System.out.println(current);
        if(current == upperLimit) {
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, current) + 1;
        while(pos < 6 && (digits[pos] > upperLimit || digits[pos] == current)) { // traverse one by one to find next greater digit
            pos++;
        }
        return pos == 6 ? digits[0] : digits[pos];
    }
    }



