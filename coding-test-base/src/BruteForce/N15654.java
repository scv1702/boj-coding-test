package BruteForce;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class N15654 {
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {       
                output[depth] = arr[i];
                visited[i] = true;
                dfs(arr, output, visited, depth + 1, n, r);
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[N];
        int[] output = new int[M];
        dfs(arr, output, visited, 0, N, M);
        System.out.print(sb.toString());
    }
}