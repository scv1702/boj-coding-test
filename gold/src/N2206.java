import java.io.*;
import java.util.*;

public class N2206 {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int N;
    static int M;
    static int MAX_DISTANCE;

    static class Node {
        int row;
        int column;
        int distance;
    
        public Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void bfs(int[][] map, int[][] distances, int N, int M, Node source, Node destination) {
        Deque<Node> queue = new ArrayDeque<>();
        distances[source.row][source.column] = source.distance;
        queue.offer(source);
        while (!queue.isEmpty()) {
            Node node = queue.poll();     
            for (int[] dir: dirs) {
                int nr = node.row + dir[0];
                int nc = node.column + dir[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && distances[nr][nc] >= MAX_DISTANCE) {
                    distances[nr][nc] = distances[node.row][node.column] + 1;
                    if (map[nr][nc] == 0) queue.offer(new Node(nr, nc));
                }  
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAX_DISTANCE = N*M + 1;
        int[][] map = new int[N][M];
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                A[i][j] = MAX_DISTANCE;
                B[i][j] = MAX_DISTANCE;
            }
        }
        bfs(map, A, N, M, new Node(0, 0, 1), new Node(N-1, M-1));
        bfs(map, B, N, M, new Node(N-1, M-1, 1), new Node(0, 0));
        int answer = A[N-1][M-1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 
                && A[i][j] > 0 && A[i][j] < MAX_DISTANCE 
                && B[i][j] > 0 && B[i][j] < MAX_DISTANCE
                ) {
                    answer = Math.min(answer, A[i][j] + B[i][j] - 1);
                }
            }
        }
        if (answer >= MAX_DISTANCE) answer = -1;
        System.out.println(answer);
    }    
}
