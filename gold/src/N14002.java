import java.io.*;
import java.util.*;

public class N14002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int[] parent = new int[N];
        int[] LIS = new int[N];
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
        }
        for (int i = N-1; i >= 0; i--) {
            int parentIdx = N;
            for (int j = i; j < N; j++) {
                if (A[i] < A[j] && LIS[i] < 1 + LIS[j]) {
                    parentIdx = j;
                    LIS[i] = 1 + LIS[j];
                }
            }
            parent[i] = parentIdx;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (LIS[i] > max) {
                max = LIS[i];
                maxIdx = i;
            }
        }
        sb.append(max).append('\n');
        while (maxIdx < N) {
            sb.append(A[maxIdx]).append(' ');
            maxIdx = parent[maxIdx];
        }
        System.out.println(sb.toString());
    }
}