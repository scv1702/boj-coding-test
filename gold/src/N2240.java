import java.io.*;
import java.util.*;

public class N2240 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] u = new int[T+1];
        int[][][] memo = new int[T+1][W+1][2];
        for (int i = 1; i <= T; i++) {
            u[i] = Integer.parseInt(br.readLine())-1;
        }
        br.close();
        for (int t = 1; t <= T; t++) {
            memo[t][0][0] = memo[t-1][0][0];
            if (u[t] == 0) memo[t][0][0] += 1;
        }
        for (int t = 1; t <= T; t++) {
            for (int w = 1; w <= W; w++) {
                memo[t][w][0] = Math.max(memo[t-1][w-1][1], memo[t-1][w][0]);
                memo[t][w][1] = Math.max(memo[t-1][w-1][0], memo[t-1][w][1]);
                if (u[t] == (w % 2)) memo[t][w][u[t]] += 1;
            }
        }
        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(answer, Math.max(memo[T][i][0], memo[T][i][1]));
        }
        System.out.println(answer);
    }    
}
