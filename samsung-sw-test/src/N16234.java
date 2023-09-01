import java.util.*;
import java.io.*;

public class N16234 {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static void getUnion(int[][] countries, int unionNum, int[][] visited, int r, int c, int L, int R) {
        visited[r][c] = unionNum;
        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < countries.length && nc >= 0 && nc < countries[0].length && visited[nr][nc] < 0) {
                int diff = Math.abs(countries[r][c] - countries[nr][nc]);
                if (diff >= L && diff <= R) {
                    getUnion(countries, unionNum, visited, nr, nc, L, R);
                }
            }
        }
    }

    public static void print(int[][] countries, int answer, int[][] visited) {
        for (int i = 0; i < countries.length; i++) {
            for (int j = 0; j < countries[0].length; j++) {
                System.out.printf("%d ", countries[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.printf("%d ", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] countries = new int [N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            int[][] visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = -1;
                }
            }
            int unionNum = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c] < 0) {
                        getUnion(countries, unionNum, visited, r, c, L, R);
                        unionNum += 1;
                    }
                }
            }
            if (unionNum == N*N) break;
            int[] sum = new int[unionNum];
            int[] cnt = new int[unionNum];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum[visited[i][j]] += countries[i][j];
                    cnt[visited[i][j]] += 1;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    countries[i][j] = sum[visited[i][j]] / cnt[visited[i][j]];
                }
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
