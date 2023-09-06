import java.io.*;
import java.util.*;

public class N15486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int[] lookup = new int[N+2];
        for (int i = N; i >= 1; i--) {
            if (i + T[i] - 1 <= N)
                lookup[i] = Math.max(P[i] + lookup[i + T[i]], lookup[i+1]);
            else
                lookup[i] = lookup[i+1];
        }
        System.out.println(lookup[1]);
    }
}