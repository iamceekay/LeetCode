package Concurrency;

public class TicTac {
    public static void main(String[] args) {
        tictactoe(new int[3][3]);
    }
        public static String tictactoe(int[][] moves) {
            int n = 3, bd[][] = new int[n][n], rsum[] = new int[n], csum[] = new int[n], diag[] = new int[2], player = 1;
            for (int[] mv : moves) {
                int i = mv[0], j = mv[1];
                rsum[i] += player;
                csum[j] += player;
                if (i == j) diag[0] += player;
                if (i + j == n - 1) diag[1] += player;
                if (rsum[i] == 3 || csum[j] == 3 || diag[0] == 3 || diag[1] == 3) return "A";
                if (rsum[i] == -3 || csum[j] == -3 || diag[0] == -3 || diag[1] == -3) return "B";
                player *= -1;
            }
            return moves.length == n * n ? "Draw" : "Pending";
        }
}
