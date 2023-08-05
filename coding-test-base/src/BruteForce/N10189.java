package BruteForce;

import java.io.*;
import java.util.*;

public class N10189 {
    static int N;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] arr;
    static int[] output;

    public static void permutation(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int m = 0; m < N-1; m++) {
                sum += Math.abs(output[m+1] - output[m]);
            }
            answer = Math.max(answer, sum);
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                output[depth] = arr[i];
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
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
        System.out.println(answer);
    }
}
