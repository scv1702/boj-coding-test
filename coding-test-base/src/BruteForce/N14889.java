package BruteForce;

import java.io.*;
import java.util.*;

public class N14889 {
    static int N;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            int[] startTeam = new int[N/2];
            int[] linkTeam = new int[N/2];
            int startTeamIdx = 0;
            int linkTeamIdx = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    startTeam[startTeamIdx++] = i;
                } else {
                    linkTeam[linkTeamIdx++] = i;
                }
            }
            int startTeamPoint = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    startTeamPoint += board[startTeam[i]][startTeam[j]];
                }
            }
            int linkTeamPoint = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    linkTeamPoint += board[linkTeam[i]][linkTeam[j]];
                }
            }
            answer = Math.min(answer, Math.abs(linkTeamPoint - startTeamPoint));
            return ;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        dfs(1, 1);
        System.out.println(answer);
    }
}