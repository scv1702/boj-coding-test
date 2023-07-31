package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class N15649 {
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        int[] output = new int[M];
        boolean[] visited = new boolean[N];
        permutation(arr, output, visited, 0, N, M);
        System.out.print(sb.toString());
    }
}