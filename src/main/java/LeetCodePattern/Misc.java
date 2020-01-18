package LeetCodePattern;

import java.util.*;

public class Misc {
    class ListNode{
        ListNode next;
        int val;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        min.add(12);
        min.add(2);
        min.add(18);
        min.add(1);
        min.add(0);
        min.add(7);
        int[][] solution = new int[4][4];
        int aaaa = Integer.parseInt("1");
        String a = "abc";
        aaaa = a.indexOf('c', 2);
        System.out.println('a' - 'A');
        System.out.println(polarity("AaAbBC"));
        System.out.println(longestEvenWord("It is a pleasant day today"));
        int[] b=new int[]{1,2,3};
        int[] c=new int[]{2,5,5};

        merge(b,c);
        ArrayList<String> list =new ArrayList<>();
        list.add("the quick brown fox jumps over the lazy dog");
        list.add("the quick brown fox jump over the lazy dog");
        checkPangram(list);


    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        TreeMap<Integer, List<Integer>> thm = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (thm.containsKey(entry.getValue())) {
                thm.get(entry.getValue()).add(entry.getKey());
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>(entry.getKey());
                thm.put(entry.getValue(), temp);
            }

        }
        Map.Entry<Integer, List<Integer>> last = thm.pollLastEntry();
        return result;
    }

    private static String polarity(String value) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            } else {
                char temp = st.peek();
                if ((c - temp == 32 || c - temp == -32)) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }
        Iterator a = st.iterator();
        while (a.hasNext()) {
            sb.append(a.next());
        }
        return sb.reverse().toString();
    }
    public static String  longestEvenWord(String s) {
        String[] allWord=s.split(" ");
        TreeMap<Integer, String> hm=new TreeMap<>(Collections.reverseOrder());
        for(String word:allWord)
        {
            if(!hm.containsKey(word.length()))
                hm.put(word.length(),word);
        }
        for(int count:hm.keySet())
        {
            if(count%2==0) return hm.get(count);
        }
        return "00";

    }

    public static int[]   merge(int[] a,int[] b) {
        int[] c=new int[a.length+b.length];
        int count=0;
        for(int i:a)
            c[count++]=i;
        for(int i:b)
            c[count++]=i;
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        return c;
    }
        public static String checkPangram(List<String> strings) {
           StringBuilder sb = new StringBuilder();
                for(String word:strings)
                {
                    if(checkString(word)) sb.append("1");
                    else sb.append("0");
                }
                return sb.toString();
        }
        public static boolean checkString(String input) {
            return input.toLowerCase()
                    .replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", "").length() == 26;
        }


    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode pre = null;
        ListNode fakeHead = head;
        while(fakeHead != null){
            if(!set.add(fakeHead.val)){
                pre.next = fakeHead.next;
            } else{
                pre = fakeHead;
            }
            fakeHead = fakeHead.next;
        }
        return head;
    }
}
