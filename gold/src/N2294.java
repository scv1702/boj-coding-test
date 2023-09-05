import java.io.*;
import java.util.*;

public class N2294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        // Arrays.sort(v);
        int[] memo = new int[k+1];
        for (int i = 0; i < k+1; i++) {
            memo[i] = k+1;
        }
        memo[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = v[i]; j <= k; j++) {
                memo[j] = Math.min(memo[j], memo[j-v[i]] + 1);
            }
        }
        if (memo[k] < k+1)
            System.out.println(memo[k]);
        else
            System.out.println(-1);
    }    
}
