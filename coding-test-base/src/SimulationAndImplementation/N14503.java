package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N14503 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dirs = {
            {-1, 0}, // 북
            {0, 1}, // 동
            {1, 0}, // 남
            {0, -1}, // 서
        };
        int answer = 0;
        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (room[r][c] == 0) {
                room[r][c] = 2;
                answer += 1;
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            int pr = r;
            int pc = c;
            for (int i = 0; i < dirs.length; i++) {
                int nd = (d + dirs.length - i - 1) % dirs.length;
                int nr = r + dirs[nd][0];
                int nc = c + dirs[nd][1];
                if (nr >= 0 & nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
                    d = nd;
                    r = nr;
                    c = nc;
                    break;
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (r == pr && c == pc) {
                int nd = (d + 2) % dirs.length;
                int br = r + dirs[nd][0];
                int bc = c + dirs[nd][1];
                if (room[br][bc] != 1) {
                    r = br;
                    c = bc;
                } else if (room[br][bc] == 1) {
                    System.out.println(answer);
                    break;
                }
            }
        }
    }
}