import java.io.*;
import java.util.*;

public class N14940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int si = 0;
        int sj = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    si = i;
                    sj = j;
                }
                if (map[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        visited[si][sj] = 0;
        queue.offer(si * m + sj);
        while (!queue.isEmpty()) {
            int k = queue.poll();
            int i = k / m;
            int j = k % m;
            for (int[] dir: dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 1 && visited[ni][nj] < 0) {
                    visited[ni][nj] = visited[i][j] + 1;
                    queue.offer(ni * m + nj);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}