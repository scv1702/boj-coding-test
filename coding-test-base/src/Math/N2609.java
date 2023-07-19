package Math;

import java.io.*;
import java.util.StringTokenizer;

public class N2609 {
    // gcd(a, b) = gcd(b, a % b)
    public static int gcd(int a, int b) {
        if (b <= 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Math.max(a, b);
        int m = Math.min(a, b);
        int o = gcd(n, m);
        sb.append(o).append('\n');
        sb.append(n*m/o).append('\n');
        System.out.print(sb.toString());
    }
}