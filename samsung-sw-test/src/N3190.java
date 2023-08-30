import java.util.*;
import java.io.*;

public class N3190 {
    static class Pair {
        int second;
        String dir;
        public Pair(int second, String dir) {
            this.second = second; this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = true;
        }
        int L = Integer.parseInt(br.readLine());
        int dr = 0;
        int dc = 1; // 뱀의 기본 이동 방향은 오른쪽
        Deque<Pair> queue = new ArrayDeque<>();    
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
        }
    }
}
