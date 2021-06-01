package Concurrency;

import java.util.*;

public class ConnectedComponent {
    public static void main(String[] args) {
        int n=5;
      //  int[][] edge={{0,1},{1,2},{0,2},{3,4}};
        int[][] edge={{2,3},{1,2},{1,3}};
      //  System.out.println(countComponent(n, edge));
        System.out.println(countComponent1(n, edge));
    }

    private static int countComponent1(int n, int[][] edge) {
        HashMap<Integer, List<Integer>> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int[] e:edge)
        {
            hm.get(e[0]).add(e[1]);
            hm.get(e[1]).add(e[0]);
        }
        HashSet<Integer> visited=new HashSet<>();
        int count=0;
        System.out.println(hm);
        for(int k:hm.keySet())
        {
            if(visited.add(k))
            {

                dfs(k,visited,hm);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int k, HashSet<Integer> visited, HashMap<Integer, List<Integer>> hm) {
        for(int i:hm.get(k))
        {
            if(visited.add(i)) dfs(i,visited,hm);
        }
    }

    private static int countComponent(int n, int[][] edge) {
        int[] root=new int[n];
        for(int i=0;i<n;i++) root[i]=-1;
        System.out.println(Arrays.toString(root));
        for(int[] e:edge)
        {
            int root1 = find(root, e[0]);
            int root2 = find(root, e[1]);
            if(root1!=root2)
            {
                n--;
                root[root1]=root2;
            }
        }
        return n;
    }

    private static int find(int[] root, int id) {
       if(root[id]==-1) return id;
      return find(root,root[id]);
        //return id;
    }
}
