package Exam.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Critical {
    public static void main(String[] args) {
        int n=10;
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> s1=new ArrayList<>();
        s1.add(1);
        s1.add(2);
        input.add(s1);
        List<Integer> s2=new ArrayList<>();
        s2.add(1);
        s2.add(3);
        input.add(s2);
        List<Integer> s3=new ArrayList<>();
        s3.add(2);
        s3.add(3);
        input.add(s3);
        List<Integer> s4=new ArrayList<>();
        s4.add(3);
        s4.add(4);
        input.add(s4);
        List<Integer> s5=new ArrayList<>();
        s5.add(4);
        s5.add(5);
        input.add(s5);
        List<Integer> s6=new ArrayList<>();
        s6.add(4);
        s6.add(6);
        input.add(s6);
        List<Integer> s7=new ArrayList<>();
        s7.add(5);
        s7.add(6);
        input.add(s7);
        List<Integer> s8=new ArrayList<>();
        s8.add(5);
        s8.add(7);
        input.add(s8);
        List<Integer> s9=new ArrayList<>();
        s9.add(6);
        s9.add(7);
        input.add(s9);
        List<Integer> s10=new ArrayList<>();
        s10.add(7);
        s10.add(8);
        input.add(s10);
        List<Integer> s11=new ArrayList<>();
        s11.add(8);
        s11.add(9);
        input.add(s11);
        List<Integer> s12=new ArrayList<>();
        s12.add(8);
        s12.add(10);
        input.add(s12);
        List<Integer> s13=new ArrayList<>();
        s13.add(9);
        s13.add(10);
        input.add(s13);
        System.out.println(criticalConnections(n,input));
      //  System.out.println(splitsFile(new int[]{1,2,5,10,35,89}));
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)-1].add(oneConnection.get(1)-1);
            graph[oneConnection.get(1)-1].add(oneConnection.get(0)-1);
        }
        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        for(List<Integer> resu : results)
        {
            resu.set(0,resu.get(0)+1);
            resu.set(1,resu.get(1)+1);
        }
        return results;
    }


    public static void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int[] timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];

        for (int oneNeighbour : graph[node]) {
            if (oneNeighbour == parent) continue;
            if (!visited[oneNeighbour])
                criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if (currentTimeStamp < timeStampAtThatNode[oneNeighbour]) results.add(Arrays.asList(node, oneNeighbour));
        }


    }
    public static int  splitsFile(int[] file){
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        int sum=0;
        for(int f:file)
            pq.add(f);
        while(pq.size()>1)
        {
            int first=pq.poll();
            int second=pq.poll();
            pq.add(first+second);
            sum+=first+second;
        }
        return sum;
    }
}

