import java.io.*;
import java.util.*;

public class N2293 {
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
        int[][] memo = new int[n+1][k+1]; 
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                if (j % v[i] == 0) { // 동전 i로만 j를 만들 수 있는 경우
                    memo[i][j] = 1;
                }
                int s = 0;
                while (s <= k && j-v[i]*s >= 0) {
                    memo[i][j] += memo[i+1][j-v[i]*s];
                    s += 1;
                }
            }
        }
        System.out.println(memo[0][k]);
    }    
}
