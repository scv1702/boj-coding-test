package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N16926 {
    public static void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dirs = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int k = 0; k < R; k++) {
            int sr = 0;
            int sc = 0;
            int desr = N-1;
            int desc = M-1;
            int r = 0;
            int c = 0;
            int dirIdx = 0;
            while (sr < desr && sc < desc) {
                int nr = r + dirs[dirIdx % 4][0];
                int nc = c + dirs[dirIdx % 4][1];
                while (nr != sr || nc != sc) {
                    if (nr >= sr && nr <= desr && nc >= sc && nc <= desc) {
                        B[nr][nc] = A[r][c];
                        r = nr;
                        c = nc;
                    } else {
                        dirIdx += 1;
                    }
                    nr = r + dirs[dirIdx % 4][0];
                    nc = c + dirs[dirIdx % 4][1];
                }
                B[sr][sc] = A[r][c];
                sr += 1;
                sc += 1;
                desr -= 1;
                desc -= 1;
                r = sr;
                c = sc;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    A[i][j] = B[i][j];
                }
            }
        }
        print(B);
    }
}