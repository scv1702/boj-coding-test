package Bfs;

import java.util.*;
import java.io.*;

public class N1261 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("<%d, %d>", x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        int[][] matrix = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    matrix[i][j] = 1;
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, 0));
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.x == N-1 && pair.y == M-1) {
                System.out.println(dist[N-1][M-1]);
                break;
            }
            for (int[] dir: dirs) {
                int nx = pair.x + dir[0];
                int ny = pair.y + dir[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[pair.x][pair.y] + matrix[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = dist[pair.x][pair.y] + matrix[nx][ny];
                    if (matrix[nx][ny] == 1) { // 벽인 경우
                        queue.offerLast(new Pair(nx, ny));
                    } else { // 빈 방인 경우
                        queue.offerFirst(new Pair(nx, ny));
                    }
                }
            }
        }   
    }
}