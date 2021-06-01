package Exam.Amazon;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class WordSearch {
    public static void main(String[] args) {
       char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, word, 0))
                    return true;
            }
        return false;
    }
    private static boolean exist(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) return true;
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
            return false;
        board[i][j]='*';
        boolean result =    exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);
        System.out.println(Arrays.deepToString(board));
        board[i][j] = word.charAt(ind);
        return result;
    }
}
