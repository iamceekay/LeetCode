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
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = -1;
        int freshCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j}); //gathering rotten oranges to queue
                else if(grid[i][j] == 1) freshCount++;
            }
        }

        if(freshCount == 0) return 0; //there is no fresh orange.
        if(queue.size() == 0) return -1; //there is noting to rotten.

        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size(); //Rotten oranges simultaneously affect adjacent fresh oranges.
            for(int i = 0; i < size; i++) {
                //if using queue.size() instead of size, it will be not working properly, beacuse queue is changeable.
                int[] now = queue.poll();
                for (int[] dir : dirs) { //find fresh oragnes from adjacent directions.
                    int x = now[0] + dir[0];
                    int y = now[1] + dir[1];

                    if (x > grid.length - 1 || x < 0 || y > grid[0].length - 1 || y < 0) continue;
                    if (grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2; //rotten..!!
                        freshCount--;
                    }
                }
            }
        }
        //if freshCount is not 0, it means that all fresh orange couldn't be rotten.
        return freshCount != 0 ? -1 : minutes;
    }

}
