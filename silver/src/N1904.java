import java.io.*;
import java.util.*;

public class N1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 15746;  
        int[] lookup = new int[N+1];
        lookup[0] = lookup[1] = 1;
        for (int i = 2; i <= N; i++) {
            lookup[i] = (lookup[i-2] % M) + (lookup[i-1] % M);
        }
        System.out.println(lookup[N] % M);
    }
}