package Concurrency;

public class leftMostAtleast {
    public static void main(String[] args) {
    // int[][] array={{0,0,0,1},{0,0,1,1},{0,1,1,1}};
        int[][] array={{0,0},{1,1}};
        System.out.println(leftmost(array));
    }

    private static int leftmost(int[][] array) {
        int m=array.length;
        int n=array[0].length;
        for(int j=0;j<n;j++)
        {
          //  boolean check=false;
            for(int i=0;i<m;i++)
            {
                if(array[i][j]==1) return j;
            }
        }
        return -1;
    }
}
