import java.io.*;
import java.util.*;

public class N17144 {
    static class AirCleaner {
        Pair up;
        Pair down;
        
        public AirCleaner(Pair up, Pair down) {
            this.up = up; 
            this.down = down;
        }

        public void clean(int[][] room) {
            int R = room.length;
            int C = room[0].length;
            // up
            for (int i = up.i-1; i > 0; i--) {
                if (room[i][up.j] >= 0) {
                    room[i][up.j] = room[i-1][up.j];
                }
            }
            for (int j = 1; j < C; j++) {
                if (room[0][j] >= 0) {
                    room[0][j-1] = room[0][j];
                }
            }
            for (int i = 1; i <= up.i; i++) {
                if (room[i][C-1] >= 0) {
                    room[i-1][C-1] = room[i][C-1];
                }
            }
            for (int j = C-1; j >= 2; j--) {
                if (room[up.i][j] >= 0) {
                    room[up.i][j] = room[up.i][j-1];
                }
            }
            room[up.i][1] = 0;
            // down
            for (int i = down.i+2; i < R; i++) {
                if (room[i][up.j] >= 0) {
                    room[i-1][up.j] = room[i][up.j];
                }
            }
            for (int j = 1; j < C; j++) {
                if (room[R-1][j] >= 0) {
                    room[R-1][j-1] = room[R-1][j];
                }
            }
            for (int i = R-1; i > down.i; i--) {
                if (room[i][C-1] >= 0) {
                    room[i][C-1] = room[i-1][C-1];
                }
            }
            for (int j = C-1; j >= 2; j--) {
                if (room[down.i][j] >= 0) {
                    room[down.i][j] = room[down.i][j-1];
                }
            }
            room[down.i][1] = 0;
        }
    }

    static class Pair {
        int i; 
        int j;
        
        public Pair(int i, int j) {
            this.i = i; 
            this.j = j;
        }
    }

    static class Space {
        int dust;
        Pair idx;
        
        public Space(int dust, Pair idx) {
            this.dust = dust;
            this.idx = idx;
        }
    }

    public static int getAmountOfDust(int[][] room) {
        int amountOfDust = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] > 0) amountOfDust += room[i][j];
            }
        }
        return amountOfDust;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] room = new int[R][C];
        List<Pair> airCleanerIdx = new ArrayList<>(2);
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] < 0) {
                    airCleanerIdx.add(new Pair(i, j));
                }
            }
        }
        AirCleaner airCleaner = new AirCleaner(airCleanerIdx.get(0), airCleanerIdx.get(1));
        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int t = 0; t < T; t++) {
            Deque<Space> queue = new ArrayDeque<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] > 0) queue.offer(new Space(room[i][j], new Pair(i, j)));
                }
            }
            // 1. 미세먼지 확산
            while (!queue.isEmpty()) {
                Space space = queue.poll();
                int cnt = 0;
                for (int[] dir: dirs) {
                    int ni = space.idx.i + dir[0];
                    int nj = space.idx.j + dir[1];
                    if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                        if (room[ni][nj] >= 0) {
                            room[ni][nj] += space.dust / 5;
                            cnt += 1;
                        }
                    }
                    
                }
                room[space.idx.i][space.idx.j] -= cnt * (space.dust / 5);
            }
            // 2.공기청정기 작동
            airCleaner.clean(room);
        }
        System.out.println(getAmountOfDust(room));
    }
}