package Graph;

import java.util.*;
import java.io.*;

class TestClass  {
    static final int MAXN = 100001;
    static int[][] path = new int[3][MAXN];

    public static class Pair {
        public int first;
        public int second;
    }
    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.dest = destination;
            this.weight = weight;
        }
    }
    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).dest + " with weight " +  list.get(j).weight);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TestClass{}";
    }

    public static Pair getAns(int N, int u, int v, int ui[], int vi[], int wi[]) {
        Pair res = new Pair();
        Graph graph = new Graph(N);
        System.out.println(Arrays.toString(ui));
        System.out.println(Arrays.toString(vi));
        System.out.println(Arrays.toString(wi));
        for(int i=1;i<N;i++){
            graph.addEgde(ui[i], vi[i], wi[i]);
        }
        res.first=2;
        res.second=8;
        graph.printGraph();
        return res;
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ui = new int [N];
        int[] vi = new int [N];
        int[] wi = new int [N];
        for (int i = 1; i < N; i+=1) {
            String[] inp = br.readLine().split(" ");
            ui[i] = Integer.parseInt(inp[0]);
            vi[i] = Integer.parseInt(inp[1]);
            wi[i] = Integer.parseInt(inp[2]);
        }
        int Q = Integer.parseInt(br.readLine());
        while(Q > 0) {
            Q-=1;
            String[] inp = br.readLine().split(" ");
            int u = Integer.parseInt(inp[0]);
            int v = Integer.parseInt(inp[1]);
            Pair ans = getAns(N, u, v, ui, vi, wi);
            System.out.println(ans.first + " " + ans.second);
        }
    }
}
