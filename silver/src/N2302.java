import java.io.*;
import java.util.*;

public class N2302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] vip = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            vip[Integer.parseInt(br.readLine())-1] = true;
        }
        int[] lookup = new int[N+1];
        vip[N] = true;
        lookup[N] = 1;
        for (int i = N-1; i >= 0; i--) {
            lookup[i] = lookup[i+1];
            if (!vip[i] && !vip[i+1]) {
                lookup[i] += lookup[i+2];
            }
        }
        System.out.println(lookup[0]);
    }
}