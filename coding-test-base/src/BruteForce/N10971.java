package BruteForce;

import java.io.*;
import java.util.*;

public class N10971 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] W;
    static int[] output;

    public static void permutation(int depth) {
        if (depth == N) {
            if (W[output[N-1]][output[0]] > 0) {
                int sum = 0;
                for (int i = 0; i < N-1; i++) {
                    sum += W[output[i]][output[i+1]];
                }
                sum += W[output[N-1]][output[0]];
                answer = Math.min(answer, sum);
            }
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (depth > 0) {
                if (!visited[i] && W[output[depth-1]][i] > 0) {
                    output[depth] = i;
                    visited[i] = true;
                    permutation(depth + 1);
                    visited[i] = false;
                }
            } else {
                output[depth] = i;
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        output = new int[N];
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        permutation(0);
        System.out.println(answer);
    }
}
