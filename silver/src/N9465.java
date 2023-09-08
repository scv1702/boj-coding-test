import java.io.*;
import java.util.*;

public class N9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Math.abs(N);
        int K = 1000000000;  
        int[] lookup = new int[2*M+1];
        if (M > 0) {
            lookup[M-1] = lookup[M+1] = 1;
            lookup[M] = 0;
            if (N >= 0) {
                for (int i = M+2; i < 2*M+1; i++) {
                    lookup[i] = (lookup[i-1] % K) + (lookup[i-2] % K);
                }
            } else {
                for (int i = M-1; i >= 0; i--) {
                    lookup[i] = (lookup[i+2] % K) - (lookup[i+1] % K);
                }
            }
        }
        if (lookup[M+N] > 0) {
            System.out.println(1);
        } else if (lookup[M+N] == 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
        System.out.println(Math.abs(lookup[M+N]) % K);
    }
}