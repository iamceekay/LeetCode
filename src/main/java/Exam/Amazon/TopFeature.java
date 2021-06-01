package Exam.Amazon;

import java.util.*;

public class TopFeature {
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 15;
        String[] keywords2 = { "plant", "flower", "cde", "def", "efg" };
        String[] reviews2 = { "gfhjk gjhkj uyk bkj sdf flower" , "lkjmbghjk fgjhnmb ykjjbjhu yhjk plant" , "gfhjk gjhkj uyk bkj sdf cde" , "gfhjk gjhkj uyk bkj sdf def" , "gfhjk gjhkj uyk bkj sdf efg"};
       // System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
        System.out.println("My ANswer");
        System.out.println(topFeatureRequests(k2,Arrays.asList(keywords2),Arrays.asList(reviews2)));

    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for(String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        System.out.println(map);
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        System.out.println(res);
        return res;
    }
    public static List<String> topFeatureRequests(int topFeatures, List<String> possibleFeatures, List<String> featureRequests) {
        // Write your code here
        System.out.println(topFeatures+"topFeatures");
        System.out.println(possibleFeatures+"possibleFeatures");
        System.out.println(featureRequests+"featureRequests");
        HashMap<String,Integer> hm=new HashMap<>();
        List<String> res= new ArrayList<>();
        Set<String> set = new HashSet<>(possibleFeatures);
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
        for(String feature:featureRequests)
        {
            String[] splitted=feature.split("\\W");
            Set<String> finalfeature=new HashSet<>();
            for(String spl:splitted)
            {
                spl=spl.toLowerCase();
                if(possibleFeatures.contains(spl) && !finalfeature.contains(spl))
                {
                    hm.put(spl,hm.getOrDefault(spl, 0)+1);
                    finalfeature.add(spl);
                }
            }
        }
        pq.addAll(hm.entrySet());
        while(!pq.isEmpty() && topFeatures-- >0)
        {
            res.add(pq.poll().getKey());
        }
        System.out.println(res+"res");
        return res;

    }
}
