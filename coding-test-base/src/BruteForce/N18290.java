package BruteForce;

import java.io.*;
import java.util.*;

public class N18290 {
    static int answer = Integer.MIN_VALUE;
    static int N;
    static int M;
    static int K;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static boolean check(int r, int c) {
        boolean flag = true;
        for (int[] dir: dirs) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (dr >= 0 && dr < N && dc >= 0 && dc < M && visited[dr][dc]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void dfs(int depth, int s) {
        if (depth == K) {
            answer = Math.max(answer, s);
            return ;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && check(r, c)) {
                    visited[r][c] = true;
                    dfs(depth + 1, s + board[r][c]);
                    visited[r][c] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }
}