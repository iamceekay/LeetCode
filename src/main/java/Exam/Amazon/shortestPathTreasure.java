package Exam.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathTreasure {
        public static void main(String[] args) {
            char[][] island = new char[][]{
                    {'O', 'O', 'O', 'O'},
                    {'D', 'O', 'D', 'O'},
                    {'O', 'O', 'O', 'O'},
                    {'O', 'O', 'O', 'X'}
            };
           // System.out.println(String.format("%s (expect 6)", new ShortestPathToTreasure().treasureIsland(island)));
        }

        public int treasureIsland(char[][] island) {
            if (island == null || island.length == 0)
                return 0;

            int steps = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0,0});
            System.out.println(0 + "," + 0);
            boolean[][] visited = new boolean[island.length][island[0].length];
            visited[0][0] = true;
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // bfs
            while (!queue.isEmpty()) {
                int size = queue.size();
                //System.out.println("new level");
                steps++;
                for (int i = 0; i < size; i++) {
                    int[] coordinate = queue.poll();
                    if (island[coordinate[0]][coordinate[1]] == 'X') {
                        //System.out.println("treasure");
                        return steps - 1;
                    }
                    for (int[] dir : dirs) {
                        int newX = coordinate[0] + dir[0], newY = coordinate[1] + dir[1];
                        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length && island[newX][newY] != 'D' && !visited[newX][newY]) {
                            queue.add(new int[] { newX, newY });
                            //System.out.println("from: " + coordinate[0] + "," + coordinate[1] + " to: " + newX + "," + newY);
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
            return steps -1;
        }
    }
