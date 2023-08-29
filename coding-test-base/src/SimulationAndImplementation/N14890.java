package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N14890 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        boolean[][] ramp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ramp[i][j] = true;
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int end = 1;
            boolean available = true;
            while (end < N) {
                while (end < N && map[i][end] == map[i][end-1]) end += 1; // 높이가 같으면 통과
                if (end < N) { // 높이가 다른 경우
                    if (map[i][end] - map[i][end-1] == 1) { // 높이차가 1이며 높이가 증가하는 경우
                        // end-1칸부터 L칸의 높이가 같은지 검사
                        int temp = end;
                        end -= 1;
                        int height = map[i][end];
                        while (end >= 0 && end >= temp-L) {
                            if (map[i][end] == height && ramp[i][end]) {
                                ramp[i][end] = false;
                                end -= 1;
                            } else {
                                break;
                            }
                        }
                        // end-1칸부터 L칸의 높이가 다른 경우, 해당 길은 사용 불가
                        if (end >= temp-L) {
                            available = false;
                            break;
                        }
                        end = temp+1;
                    } else if (map[i][end] - map[i][end-1] == -1) { // 높이차가 1이며 높이가 감소하는 경우
                        // end칸부터 L칸의 높이가 같으며 경사로가 곂지지 않는지 검사
                        int temp = end;
                        int height = map[i][end];
                        while (end < N && end < temp+L) {
                            if (map[i][end] == height && ramp[i][end]) {
                                ramp[i][end] = false;
                                end += 1;
                            } else {
                                break;
                            }
                        }
                        // end칸부터 L칸의 높이가 다른 경우, 해당 길은 사용 불가
                        if (end < temp+L) {
                            available = false;
                            break;
                        }
                        end = temp+L;
                    } else { // 높이차가 1이 아닌 경우
                        available = false;
                        break;
                    }
                }
            }
            if (available) answer += 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ramp[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            int end = 1;
            boolean available = true;
            while (end < N) {
                while (end < N && map[end][i] == map[end-1][i]) end += 1; // 높이가 같으면 통과
                if (end < N) { // 높이가 다른 경우
                    if (map[end][i] - map[end-1][i] == 1) { // 높이차가 1이며 높이가 증가하는 경우
                        // end-1칸부터 L칸의 높이가 같은지 검사
                        int temp = end;
                        end -= 1;
                        int height = map[end][i];
                        while (end >= 0 && end >= temp-L) {
                            if (map[end][i] == height && ramp[end][i]) {
                                ramp[end][i] = false;
                                end -= 1;
                            } else {
                                break;
                            }
                        }
                        // end-1칸부터 L칸의 높이가 다른 경우, 해당 길은 사용 불가
                        if (end >= temp-L) {
                            available = false;
                            break;
                        }
                        end = temp+1;
                    } else if (map[end][i] - map[end-1][i] == -1) { // 높이차가 1이며 높이가 감소하는 경우
                        // end칸부터 L칸의 높이가 같으며 경사로가 곂지지 않는지 검사
                        int temp = end;
                        int height = map[end][i];
                        while (end < N && end < temp+L) {
                            if (map[end][i] == height && ramp[end][i]) {
                                ramp[end][i] = false;
                                end += 1;
                            } else {
                                break;
                            }
                        }
                        // end칸부터 L칸의 높이가 다른 경우, 해당 길은 사용 불가
                        if (end < temp+L) {
                            available = false;
                            break;
                        }
                        end = temp+L;
                    } else { // 높이차가 1이 아닌 경우
                        available = false;
                        break;
                    }
                }
            }
            if (available) answer += 1;
        }
        System.out.println(answer);
    }
}