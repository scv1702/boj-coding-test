package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N2290 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(st.nextToken());
        String token = st.nextToken();
        int m = token.length();
        int[][] template = {
            {1,1,1,0,1,1,1},
            {0,0,1,0,0,1,0},
            {1,0,1,1,1,0,1},
            {1,0,1,1,0,1,1},
            {0,1,1,1,0,1,0},
            {1,1,0,1,0,1,1},
            {1,1,0,1,1,1,1},
            {1,0,1,0,0,1,0},
            {1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1},
        };
        char[][] num = new char[2*s+3][(s+2)*m+m-1];
        for (int i = 0; i < 2*s+3; i++) {
            for (int j = 0; j < (s+2)*m+m-1; j++) {
                num[i][j] = ' ';
            }
        }
        int bias = 0;
        for (int i = 0; i < m; i++) {
            int n = token.charAt(i) - '0';
            int templateIdx = 0;
            for (int j = 0; j < 2*s+3; j++) {
                if (j % (s+1) == 0) {
                    if (template[n][templateIdx] == 1) {
                        for (int k = 0; k < s+2; k++) {
                            if (k != 0 && k != s+1) num[j][bias+k] = '-';
                        }
                    }
                    templateIdx += 1;
                } else {
                    if (template[n][templateIdx] == 1) {
                        num[j][bias+0] = '|';
                    }
                    if (template[n][templateIdx+1] == 1) {
                        num[j][bias+s+1] = '|';
                    }
                    if ((j+1) % (s+1) == 0) {
                        templateIdx += 2;
                    }
                }
            }
            bias += s+3;
        }
        for (int i = 0; i < 2*s+3; i++) {
            for (int j = 0; j < (s+2)*m+m-1; j++) {
                sb.append(num[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}