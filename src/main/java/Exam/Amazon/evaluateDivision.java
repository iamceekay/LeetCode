package Exam.Amazon;

import java.util.*;

class evaluateDivision {
    class Node{
        String key;
        double value;
        public Node(String key,double value)
        {
            this.key=key;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        evaluateDivision ev=new evaluateDivision();
        List<String> list=Arrays.asList("a","b");
        List<String> list2=Arrays.asList("b","c");
        ArrayList<List<String>> equations =new ArrayList<>();
        equations.add(list);
        equations.add(list2);
        List<String> list3=Arrays.asList("a","c");
        List<String> list4=Arrays.asList("b","a");
        List<String> list5=Arrays.asList("a","e");
        List<String> list6=Arrays.asList("a","a");
        List<String> list7=Arrays.asList("x","x");
        ArrayList<List<String>> queries =new ArrayList<>();
        queries.add(list3);
        queries.add(list4);
        queries.add(list5);
        queries.add(list6);
        queries.add(list7);
        double[] values={2.0,3.0};
        ev.calcEquation(equations,values,queries);

    }
    HashMap<String,List<Node>> graph=new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build graph
        //query
        //dfs Calculating value;
        //return

        buildgraph(equations,values);
        double[] res=new double[queries.size()];
        int i=0;
        for(List<String> q:queries)
        {
            res[i++]=dfs(q.get(0),q.get(1),new HashSet<>());
        }
        return res;

    }

    public double dfs(String source,String target,HashSet<String> visited)
    {
        System.out.println(graph);

        System.out.println(source);
        System.out.println(target);
        //  if(!(graph.containsKey(source) && graph.containsKey(target))) return -1.0;
        if(source.equals(target)) {
            return 1.0;
        }
        visited.add(source);
        for(Node n:graph.get(source))
        {
            if(!visited.contains(n.key)){
                double result=dfs(n.key,target,visited);
                if(result!=-1.0)
                    return result*n.value;
            }
        }
        return -1;
    }
    public void buildgraph(List<List<String>> equations, double[] values)
    {
        for(int i=0;i<equations.size();i++)
        {
            String source=equations.get(i).get(0);
            String target=equations.get(i).get(1);
            graph.putIfAbsent(source,new ArrayList<>());
            graph.putIfAbsent(target,new ArrayList<>());
            graph.get(source).add(new Node(target,values[i]));
            graph.get(target).add(new Node(source,1/values[i]));
        }

    }
}
