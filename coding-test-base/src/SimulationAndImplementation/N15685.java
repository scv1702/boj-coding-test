package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N15685 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int COORDINATE_SIZE = 101;
        boolean[][] coordinate = new boolean[COORDINATE_SIZE][COORDINATE_SIZE];
        int[][] dirs = {
            {0, 1}, {-1, 0}, {0, -1}, {1, 0}
        };
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int[][] curve = new int[1025][2];
            curve[0][0] = y;
            curve[0][1] = x;
            curve[1][0] = y + dirs[d][0];
            curve[1][1] = x + dirs[d][1];
            int curvePtr = 1;
            for (int j = 1; j <= g; j++) { // j: generation
                for (int k = (int) Math.pow(2, j-1); k > 0; k--) {
                    int vy = curve[k][0] - curve[k-1][0];
                    int vx = curve[k][1] - curve[k-1][1];
                    // rotates a vector by -90 degree
                    curve[curvePtr+1][0] = curve[curvePtr][0] - vx;
                    curve[curvePtr+1][1] = curve[curvePtr][1] + vy;
                    curvePtr += 1;
                }  
            }
            for (int j = 0; j <= curvePtr; j++) {
                coordinate[curve[j][0]][curve[j][1]] = true;
            }
        }
        int answer = 0;
        for (int i = 0; i < COORDINATE_SIZE-1; i++) {
            for (int j = 0; j < COORDINATE_SIZE-1; j++) {
                if (coordinate[i][j] & coordinate[i][j+1] & coordinate[i+1][j] & coordinate[i+1][j+1])
                    answer += 1;
            }
        }
        System.out.println(answer);
    }
}