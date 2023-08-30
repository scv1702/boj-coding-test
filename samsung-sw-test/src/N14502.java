import java.io.*;
import java.util.*;

public class N14502 {
    static int N;
    static int M;
    static int answer;
    static int[][] lab;
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static Pair[] wall;
    static List<Pair> blanks;
    static List<Pair> virus;
    
    static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r; this.c = c;
        }

        @Override
        public String toString() {
            return String.format("%d %d", this.r, this.c);
        }
    }

    // 빈 칸들 중 벽을 세울 세 칸 선택
    static void combination(int now, int pos, int n, int r) {
        if (now == r) {
            // 벽 세우기
            infection();
            return ;
        }
        for (int i = pos; i < n; i++) {
            wall[now] = blanks.get(i);
            combination(now+1, i+1, n, r);
        }
    }

    static void infection() {
        int[][] tempLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempLab[i][j] = lab[i][j];
            }
        }
        // 벽 세우기
        for (int i = 0; i < wall.length; i++) {
            tempLab[wall[i].r][wall[i].c] = 1;
        }
        Deque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < virus.size(); i++) {
            Pair pair = virus.get(i);
            queue.offer(pair);
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int[] dir: dirs) {
                int nr = pair.r + dir[0];
                int nc = pair.c + dir[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && tempLab[nr][nc] == 0) {
                    tempLab[nr][nc] = 2;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
        int notInfected = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) notInfected += 1;
            }
        }
        answer = Math.max(answer, notInfected);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        blanks = new ArrayList<>();
        wall = new Pair[3];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) blanks.add(new Pair(i, j));
                if (lab[i][j] == 2) virus.add(new Pair(i, j));
            }
        }
        combination(0, 0, blanks.size(), 3);
        System.out.println(answer);
    }    
}
