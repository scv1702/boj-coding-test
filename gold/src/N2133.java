import java.io.*;
import java.util.*;

public class N2133 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] lookup = new long[N+1];
        lookup[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            lookup[i] = 3 * lookup[i-2];
            if (i >= 4) lookup[i] += 6 * lookup[i-4];
        }
        System.out.println(Arrays.toString(lookup));
        System.out.println(lookup[N]);
    }
}