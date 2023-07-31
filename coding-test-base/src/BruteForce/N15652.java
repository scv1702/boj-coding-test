package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class N15652 {
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] output, int idx, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = idx; i <= n; i++) {
            output[depth] = i;
            dfs(output, i, depth + 1, n, r);
            output[depth] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] output = new int[M];
        dfs(output, 1, 0, N, M);
        System.out.print(sb.toString());
    }
}