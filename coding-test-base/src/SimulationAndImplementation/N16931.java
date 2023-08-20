package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N16931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        // bottom, top
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] > 0) {
                    answer += 2;
                }
            }
        }
        // left, right
        for (int i = 0; i < N; i++) {
            answer += paper[i][0];
            for (int j = 1; j < M; j++) {
                answer += Math.abs(paper[i][j-1] - paper[i][j]);
            }
            answer += paper[i][M-1];
        }
        // front, back
        for (int i = 0; i < M; i++) {
            answer += paper[0][i];
            for (int j = 1; j < N; j++) {
                answer += Math.abs(paper[j-1][i] - paper[j][i]);
            }
            answer += paper[N-1][i];
        }
        System.out.println(answer);
    }
}