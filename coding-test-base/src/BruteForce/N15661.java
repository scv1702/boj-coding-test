package BruteForce;

import java.io.*;
import java.util.*;

public class N15661 {
    static int N;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void dfs(int idx, int depth, int DEPTH_LIMIT) {
        if (depth == DEPTH_LIMIT) {
            int[] startTeam = new int[DEPTH_LIMIT];
            int[] linkTeam = new int[N - DEPTH_LIMIT];
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
            for (int i = 0; i < DEPTH_LIMIT; i++) {
                for (int j = 0; j < DEPTH_LIMIT; j++) {
                    startTeamPoint += board[startTeam[i]][startTeam[j]];
                }
            }
            int linkTeamPoint = 0;
            for (int i = 0; i < N - DEPTH_LIMIT; i++) {
                for (int j = 0; j < N - DEPTH_LIMIT; j++) {
                    linkTeamPoint += board[linkTeam[i]][linkTeam[j]];
                }
            }
            answer = Math.min(answer, Math.abs(linkTeamPoint - startTeamPoint));
            return ;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, DEPTH_LIMIT);
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
        for (int i = 1; i < N-1; i++) {
            visited[0] = true;
            dfs(1, 1, i);
        }
        System.out.println(answer);
    }
}