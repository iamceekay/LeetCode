package Concurrency;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
         String[] words={"wrt","wrf","er","ett","rftt"};
        //String[] words = {"z", "z"};
        alienOrder(words);
    }

    /*static HashMap<AlienNode,List<AlienNode>> allMapping=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    static HashSet<AlienNode>seen=new HashSet();
    private static String alienOrder(String[] words) {
        for (int i = 1; i < words.length; i++) {
                process(words[i],words[i-1]);
        }
     //   char[] result=new char[allCharacter.size()];

        System.out.println(allMapping.size());
        for(AlienNode c:allMapping.keySet())
        {
            if(isCycle(c))
                return "";
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static boolean isCycle(AlienNode current) {
        if(seen.contains(current)) return false;
        if (current.visited==true) return true;
        current.visited=true;
        if(allMapping.get(current)!=null) {
            for (AlienNode c : allMapping.get(current)) {
                if (isCycle(c)) return true;

            }
        }
        seen.add(current);
        current.tested=true;
        sb.append(current.character);
        return false;
    }


    private static void process(String word1, String word2) {
        int i=0,j=0;
        while(i<word1.length() && j<word2.length())
        {

            if(word1.charAt(i)!=word2.charAt(j))
            {

                AlienNode current=new AlienNode(word1.charAt(i));
                AlienNode preReq=new AlienNode(word2.charAt(j));
                allMapping.putIfAbsent(current,new ArrayList<>());
                allMapping.get(current).add(preReq);
                break;
            }
            i++;j++;

        }
    }

    static class AlienNode {
            boolean visited = false;
            boolean tested = false;
            Character character;
            List<AlienNode> prereq = new ArrayList<AlienNode>();
            public AlienNode(Character c) {
                character = c;
            }
            public void add(AlienNode a) {
                prereq.add(a);
            }

        @Override
        public String toString() {
            return "AlienNode{" +
                    "visited=" + visited +
                    ", tested=" + tested +
                    ", character=" + character +
                    ", prereq=" + prereq +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AlienNode alienNode = (AlienNode) o;

            return character.equals(alienNode.character);
        }

        @Override
        public int hashCode() {
            return character.hashCode();
        }
    }
    }*/
    private static Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private static Map<Character, Boolean> seen = new HashMap<>();
    private static StringBuilder output = new StringBuilder();

    public static String alienOrder(String[] words) {

        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        System.out.println(reverseAdjList);
        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }


        if (output.length() < reverseAdjList.size()) {
            return "";
        }
        System.out.println(output.toString());
        return output.toString();
    }

    // Return true iff no cycles detected.
    private static boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}

