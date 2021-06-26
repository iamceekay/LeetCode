package Concurrency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LargestIsland {
    public static void main(String[] args) {
        int[][] grid={{1,1},{0,0}};
        largestIsland(grid);
    }

    private static int largestIsland(int[][] grid) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0;
        int  m=grid.length;
        int n=grid.length;
        int colorIndex=2;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1){
                    int size=paint(grid,i,j,colorIndex);
                    hm.put(colorIndex,size);
                    colorIndex++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0)
                {
                    Set<Integer> hs=new HashSet<>();
                    hs.add(i>0?grid[i-1][j]:0);
                    hs.add(j>0?grid[i][j-1]:0);
                    hs.add(i<n-1?grid[i+1][j]:0);
                    hs.add(j<n-1?grid[i][j+1]:0);
                    int size=1;
                    for(int color:hs){
                        if(hm.containsKey(color))
                            size+=hm.get(color);
                    }

                    res=Math.max(res,size);
                }
            }
            System.out.println(res);

        }
        return res;
    }

    private static int paint(int[][] grid, int i, int j, int colorIndex) {
    if(i<0||i>= grid.length || j<0|| j>=grid[0].length || grid[i][j]!=1) return 0;
        grid[i][j]=colorIndex;
       return paint(grid,i-1,j,colorIndex)+
               paint(grid,i,j-1,colorIndex)+
               paint(grid,i+1,j,colorIndex)+
               paint(grid,i,j+1,colorIndex)+1;
    }
}
