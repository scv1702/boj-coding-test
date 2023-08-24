package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N14499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] diceR = new int[4]; // 북, 위, 남, 아래
        int[] diceC = new int[4]; // 서, 위, 동, 아래
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
        for (int i = 0; i < K; i++) {
            // 동쪽 1, 서쪽 2, 북쪽 3, 남쪽 4
            int d = Integer.parseInt(st.nextToken());
            int nx = x + dirs[d-1][0];
            int ny = y + dirs[d-1][1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                // 주사위를 해당 방향으로 굴린다.
                rollDice(diceR, diceC, d);
                if (map[nx][ny] > 0) {
                    diceR[3] = map[nx][ny];
                    diceC[3] = map[nx][ny];
                    map[nx][ny] = 0;
                } else {
                    map[nx][ny] = diceR[3];
                }
                sb.append(diceR[1]).append('\n');
                x = nx;
                y = ny;
            }
        }
        System.out.print(sb.toString());
    }

    public static void rollDice(int[] diceR, int[] diceC, int d) {
        switch(d) {
            case 1: rollDiceToEast(diceR, diceC); break;
            case 2: rollDiceToWest(diceR, diceC); break;
            case 3: rollDiceToNorth(diceR, diceC); break;
            case 4: rollDiceToSouth(diceR, diceC); break;
        }
    }

    public static void rollDiceToEast(int[] diceR, int[] diceC) {
        int temp = diceR[3];
        for (int i = 3; i > 0; i--) {
            diceR[i] = diceR[i-1];
        }
        diceR[0] = temp;
        diceC[1] = diceR[1];
        diceC[3] = diceR[3];
    }

    public static void rollDiceToWest(int[] diceR, int[] diceC) {
        int temp = diceR[0];
        for (int i = 0; i <= 2; i++) {
            diceR[i] = diceR[i+1];
        }
        diceR[3] = temp;
        diceC[1] = diceR[1];
        diceC[3] = diceR[3];
    }

    public static void rollDiceToSouth(int[] diceR, int[] diceC) {
        int temp = diceC[3];
        for (int i = 3; i > 0; i--) {
            diceC[i] = diceC[i-1];
        }
        diceC[0] = temp;
        diceR[1] = diceC[1];
        diceR[3] = diceC[3];
    }
    
    public static void rollDiceToNorth(int[] diceR, int[] diceC) {
        int temp = diceC[0];
        for (int i = 0; i <= 2; i++) {
            diceC[i] = diceC[i+1];
        }
        diceC[3] = temp;
        diceR[1] = diceC[1];
        diceR[3] = diceC[3];
    }
}
