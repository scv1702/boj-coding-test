package BruteForce;

import java.io.*;
import java.util.*;

public class N14500 {
    static int[][] dirs = {
            { 0, 1 }, // right
            { 1, 0 }, // down
            { 0, -1 }, // left
            { -1, 0 } // up
    };
    static int[][] paper;
    static int answer;
    static int N;
    static int M;
    static boolean[][] visited;

    public static void dfs(int i, int j, int sum, int size) {
        if (size == 4) {
            answer = Math.max(answer, sum);
            return ;
        }
        for (int[] dir: dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if ((nextI >= 0 && nextI < N) && (nextJ >= 0 && nextJ < M)) {
                if (!visited[nextI][nextJ]) {
                    if (size == 2) {
                        visited[nextI][nextJ] = true;
                        dfs(i, j, sum + paper[nextI][nextJ], size + 1);
                        visited[nextI][nextJ] = false;
                    }
                    visited[nextI][nextJ] = true;
                    dfs(nextI, nextJ, sum + paper[nextI][nextJ], size + 1);
                    visited[nextI][nextJ] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }    
}