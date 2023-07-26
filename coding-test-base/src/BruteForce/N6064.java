package BruteForce;

import java.io.*;
import java.util.*;

public class N6064 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Math.min(x, y);
            int X = k;
            int Y = k;
            int lcmOfMandN = lcm(Math.max(M, N), Math.min(M, N));
            if (x <= y) {
                for (int j = 0; j < lcmOfMandN / M; j++) {
                    if (Y == y) break;
                    Y = (Y + M) % N;
                    if (Y == 0)
                        Y = N;
                    k += M;
                }
            } else {
               for (int j = 0; j < lcmOfMandN / N; j++) {
                    if (X == x) break;
                    X = (X + N) % M;
                    if (X == 0)
                        X = M;
                    k += N;
                }
            }
            if (X == x && Y == y)
                sb.append(k).append('\n');   
            else
                sb.append(-1).append('\n');
        }
        System.out.print(sb.toString());
    }
}