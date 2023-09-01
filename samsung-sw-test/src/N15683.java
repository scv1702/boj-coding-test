import java.util.*;
import java.io.*;

public class N15683 {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int[][][] watchDirs = {
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 3}, {0, 1}, {1, 2}, {2, 3}},
        {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
        {{0, 1, 2, 3}}
    };
    static int answer = Integer.MAX_VALUE;

    static class Pair {
        int r; int c;

        public Pair(int r, int c) {
            this.r = r; this. c = c;
        }
    }

    static class Cctv {
        Pair index;
        int[] watchDir; // 감시 방향

        public Cctv(Pair index, int[] watchDir) {
            this.index = index;
            this.watchDir = watchDir;
        }

        public void watch(int[][] office) {
            for (int dirPtr: watchDir) {
                int[] dir = dirs[dirPtr];
                int nr = this.index.r + dir[0];
                int nc = this.index.c + dir[1];
                // 벽을 만날때 까지 감시
                while (nr >= 0 && nr < office.length && nc >= 0 && nc < office[0].length && office[nr][nc] != 6) {
                    if (office[nr][nc] == 0) office[nr][nc] = 7; // 빈 칸인 경우 감시 영역 추가
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
            }
        }
    }

    public static void dfs(int[][] office, List<List<Cctv>> cctvs, Cctv[] selected, int depth) {
        int[][] tempOffice = new int[office.length][office[0].length];
        for (int i = 0; i < office.length; i++) {
            for (int j = 0; j < office[0].length; j++) {
                tempOffice[i][j] = office[i][j];
            }
        }
        if (depth == cctvs.size()) {
            for (Cctv cctv: selected) {
                cctv.watch(tempOffice);
            }
            answer = Math.min(answer, getBlindSpot(tempOffice));
            return ;
        }
        for (int i = 0; i < cctvs.get(depth).size(); i++) {
            selected[depth] = cctvs.get(depth).get(i);
            dfs(office, cctvs, selected, depth+1);
        }
    }

    // 사각 지대 크기 계산
    public static int getBlindSpot(int[][] office) {
        int blindSpot = 0;
        for (int i = 0; i < office.length; i++) {
            for (int j = 0; j < office[0].length; j++) {
                if (office[i][j] == 0) {
                    blindSpot += 1;
                }
            }
        }
        return blindSpot;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] office = new int[N][M];
        List<List<Cctv>> cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    List<Cctv> cctv = new ArrayList<>();
                    for (int[] dir: watchDirs[office[i][j]-1]) {
                        cctv.add(new Cctv(new Pair(i, j), dir));
                    }
                    cctvList.add(cctv);
                }
            }
        }
        Cctv[] selected = new Cctv[cctvList.size()];
        dfs(office, cctvList, selected, 0);
        System.out.println(answer);
    }
}
