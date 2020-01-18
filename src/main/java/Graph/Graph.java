package Graph;

import java.util.*;

public class Graph {
    class Vertex{
        String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public String toString() {
            return  label;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }
    HashMap<Vertex, ArrayList<Vertex> > adjecencyList =new HashMap<>();
    public void addVertex(String label)
    {
        Vertex v1=new Vertex(label);
        adjecencyList.putIfAbsent(v1,new ArrayList<Vertex>());
    }
    public void removeVertex(String label)
    {
        Vertex v1=new Vertex(label);
        adjecencyList.values().stream().forEach(e->e.remove(v1));
        adjecencyList.remove(v1);
    }
    public void  addEdge(String from, String to)
    {
        Vertex vFrom=new Vertex(from);
        Vertex vTo=new Vertex(to);
        ArrayList<Vertex> fromList = adjecencyList.get(vFrom);
        if(fromList.isEmpty())
        {
            ArrayList<Vertex> tempList=new ArrayList<>();
            tempList.add(vTo);
            adjecencyList.put(vFrom,tempList);
            return;
        }
        adjecencyList.get(vFrom).add(vTo);
    }
    public void removeEdge(String from, String to)
    {
        Vertex vFrom=new Vertex(from);
        Vertex vTo=new Vertex(to);
        adjecencyList.get(vFrom).remove(vTo);
    }
    public void print()
    {
        for(Map.Entry<Vertex,ArrayList<Vertex>> entry:adjecencyList.entrySet())
        {
            System.out.println(entry.getKey().toString()+"-->"+entry.getValue());
        }
    }
    private void dfsAlgorithm(String label)
    {
        Vertex vStart=new Vertex(label);
        dfsAlgorithm(vStart,new HashSet<Vertex>());

    }
    public void dfsAlgorithm(Vertex vertex,Set<Vertex> set)
    {
        System.out.println(vertex.toString());
        set.add(vertex);
        for(Vertex current:adjecencyList.get(vertex))
        {
            if(!set.contains(current))
            dfsAlgorithm(current,set);
        }
    }
    private void dfsAlgorithmIterative(String label)
    {
        Vertex vStart=new Vertex(label);
        HashSet<Vertex> visited= new HashSet<>();
       Stack<Vertex> stack= new Stack<Vertex>();
       stack.push(vStart);
       while(!stack.isEmpty())
       {
           Vertex current=stack.pop();
           if(visited.contains(current)) continue;
           System.out.println(current.toString());
           visited.add(current);
           for(Vertex vCurrent:adjecencyList.get(current)) {
               if (!visited.contains(vCurrent)) {
                   stack.push(vCurrent);
               }
           }

       }

    }

    private void bfsAlgorithmIterative(String label)
    {
        Vertex vStart=new Vertex(label);
        HashSet<Vertex> visited= new HashSet<>();
        Queue<Vertex> queue= new LinkedList<Vertex>();
        queue.add(vStart);
        while(!queue.isEmpty())
        {
            Vertex current=queue.remove();
            if(visited.contains(current)) continue;
            System.out.println(current.toString());
            visited.add(current);
            for(Vertex vCurrent:adjecencyList.get(current)) {
                if (!visited.contains(vCurrent)) {
                    queue.add(vCurrent);
                }
            }

        }

    }
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","D");
        graph.addEdge("C","B");
        graph.addEdge("D","C");
        graph.print();
        graph.dfsAlgorithm("A");
        System.out.println("Iterative DFS");
        graph.dfsAlgorithmIterative("A");
        System.out.println("Iterative BFS");
        graph.bfsAlgorithmIterative("A");
    }
}
