package Exam.Amazon;

import java.util.*;
import java.util.stream.Collectors;

//finding largest connected component and sorting it?
public class largestItem {

    public static void main(String[] args) {


    }

    public static List<String> largestItemAssociation(List<PairString> pairs) {
        if (pairs.isEmpty())
            return null;
        PriorityQueue<Set<String>> max_heap = new PriorityQueue<>(//
                (l1, l2) -> Integer.compare(l2.size(), l1.size()));//
        Collections.sort(pairs, (a, b) -> a.first.compareTo(b.first));
        for (int pair = 0; pair < pairs.size(); pair++) {
            Set<String> buildList = new TreeSet<>(Arrays.asList(pairs.get(pair).first, pairs.get(pair).second));
            for (int inner = pair + 1; inner < pairs.size(); inner++) {
                mergeTag(buildList, pairs.get(inner));
            }
            max_heap.add(buildList);
        }

        return max_heap.poll().stream().collect(Collectors.toList());
    }

    private static void mergeTag(Set<String> buildList, PairString pairString) {
        if (buildList.contains(pairString.first) && buildList.contains(pairString.second))
            return;
        if (buildList.contains(pairString.first)) {
            buildList.add(pairString.second);
        } else if (buildList.contains(pairString.second)) {
            buildList.add(pairString.first);
        }

    }

    class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
