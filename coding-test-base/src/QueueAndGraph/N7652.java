package QueueAndGraph;

import java.io.*;
import java.util.*;

public class N7652 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] dirs = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            int[][] visited = new int[I][I];    
            StringTokenizer st = new StringTokenizer(br.readLine());
            Pair start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Pair destination = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Deque<Pair> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start.x][start.y] = 0;
            while(!queue.isEmpty()) {
                Pair pair = queue.poll();
                if (pair.x == destination.x && pair.y == destination.y) break;
                for (int[] dir: dirs) {
                    int nx = pair.x + dir[0];
                    int ny = pair.y + dir[1];
                    if (nx >= 0 && nx < I && ny >= 0 && ny < I && visited[nx][ny] <= 0) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = visited[pair.x][pair.y] + 1;
                    } 
                }
            }
            sb.append(visited[destination.x][destination.y]).append('\n');
        }
        System.out.print(sb.toString());
    }
}