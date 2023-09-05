import java.io.*;
import java.util.*;

public class N9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            int N = Integer.parseInt(br.readLine());
            int[] v = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] memo = new int[M+1];
            memo[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = v[i]; j <= M; j++) {
                    memo[j] += memo[j-v[i]];
                }
            }
            sb.append(memo[M]).append('\n');
        }
        br.close();
        System.out.print(sb.toString());
    }    
}
