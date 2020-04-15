package Exam.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
    public static void main(String[] args) {

            int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
            System.out.println(minDays(grid));

    }

    private static int minDays(int[][] grid) {
       /* int[][] newGrid = grid.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);*/
       if(grid==null || grid.length==0) return -1;
        Queue<int[]> queue= new LinkedList<>();
        int days=0,humanCount=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    queue.offer(new int[]{i,j});
                }
                else{
                    humanCount++;
                }
            }
        }
        int[][] dir={{0,-1},{-1,0},{1,0},{0,1}};
        while(!queue.isEmpty() && humanCount >0)
        {
            int queueSize=queue.size();
            for(int i=0;i<queueSize;i++)
            {
                int[] zombie=queue.poll();
                for(int[] di:dir)
                {
                    int X=zombie[0]+di[0];
                    int Y=zombie[1]+di[1];
                    if(X>=0 && X<grid.length && Y>=0 && Y<grid[0].length && grid[X][Y]==0)
                    {
                        grid[X][Y]=1;
                        queue.offer(new int[]{X,Y});
                        humanCount--;
                    }
                }
            }
            days++;
        }
        return humanCount==0?days:-1;
    }
}
