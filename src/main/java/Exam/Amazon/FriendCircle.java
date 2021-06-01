package Exam.Amazon;

import java.util.ArrayList;
import java.util.List;

public class FriendCircle {
    public static void main(String[] args) {
        List<String> ls=new ArrayList<>();
        ls.add("100");
        ls.add("010" );
        ls.add("001");
        System.out.println(findCircleNum(ls));
        //TC:O(n^2)
    }


    public static int findCircleNum( List<String> M) {
        int[] visited=new int[M.size()];
        int count=0;
        for(int i=0;i<M.size();i++)
        {
            if (visited[i] == 0) {
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs(List<String> M,int[] visited,int i)
    {
        for(int j=0;j<M.size();j++)
        {
            if(M.get(i).charAt(j)=='1' && visited[j]==0){
                visited[j]=1;
                dfs(M,visited,j);
            }
        }
    }
}
