package LeetCodePattern;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) {
        // note:
        // this is just an example on how our system
        // takes input and output and automate the process
        // of marking this submission
        try {
            int[][]board=new int[5][5];

            Scanner scan = new Scanner(System.in);

            // check if there is any more line
            if (scan.hasNextLine()) {
                // here's how you read the next line
                String string = scan.nextLine();
                for(int k=0;k<Integer.parseInt(string);k++)
                {
                    for(int i=0;i<5;i++)
                    {
                        String row=scan.nextLine();
                        char[] rowCharArray=row.toCharArray();
                        for(int j=0;j<5;j++)
                        {
                            board[i][j]=Integer.parseInt(String.valueOf(rowCharArray[j]));
                        }

                    }
                    int[][] output=checkForGame(board);
                    output=checkForGame(output);
                    output=checkForGame(output);
                    //output=checkForGame(output);
                    for(int a=0;a<5;a++)
                    {
                        for(int b=0;b<5;b++)
                        {
                            if(output[a][b]==1){
                                System.out.println("YES");
                                break;
                            }
                        }
                    }

                    System.out.println("NO");
                }

                // here's how you output the result
            }

        } catch (Exception e) {
        }
    }
    public static int[][] checkForGame(int[][]board)
    {
        int[][] output=new int[5][5];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                int neighbour=count(i,j,board);
                //Rule 1
                if(board[i][j]==1 && neighbour<2)
                    output[i][j]=0;
                else if(board[i][j]==1 && neighbour>3)
                    output[i][j]=0;
                    //Rule 4
                else if(board[i][j]==0 && neighbour==3)
                    output[i][j]=1;
            }

        }
        return output;
    }
    public static int count(int i,int j,int[][]board)
    {
        int count=0;
        //To find value in 8 Direction left,right,top,down,top left ,top right,bottom left, bottom right

        int[][] direction={{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};
        for(int[] dir:direction)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length)
            {
                count+=board[x][y];
            }
        }
        return count;
    }
}
