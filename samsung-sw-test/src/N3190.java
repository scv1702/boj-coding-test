import java.util.*;
import java.io.*;

public class N3190 {
    static boolean[][] board;

    static class Direction {
        int second;
        String dir;
        public Direction(int second, String dir) {
            this.second = second; this.dir = dir;
        }
    }

    static class Snake {
        static int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        class Pair {
            int r;
            int c;
            
            public Pair(int r, int c) {
                this.r = r; this.c = c;
            }

            @Override
            public String toString() {
                return String.format("<%d, %d>", r, c);
            }
        }

        int dirPtr = 0;
        List<Pair> moveHistory = new ArrayList<>();
        boolean isDead;
        
        public Snake() {
            moveHistory.add(new Pair(0, 0));
        }

        public void moveHead(String dir) {
            if (dir.equals("D")) {
                dirPtr = (dirPtr + 1) % dirs.length;
            }
            if (dir.equals("L")) {
                dirPtr = (dirPtr + dirs.length - 1) % dirs.length;
            }
        }

        public boolean isCrush(int r, int c) {
            for (int i = 0; i < moveHistory.size(); i++) {
                Pair m = moveHistory.get(i);
                if (m.r == r && m.c == c) return true;
            }
            return false;
        }

        public void move() {
            Pair tail = moveHistory.get(moveHistory.size()-1);
            // 뱀의 머리 이동
            Pair m = moveHistory.get(0);
            int nr = m.r + dirs[dirPtr][0];
            int nc = m.c + dirs[dirPtr][1];
            // 뱀이 벽이 부딪힌 경우 또는 뱀이 자기자신과 부딪힌 경우 게임 종료
            if (nr >= board.length ||
                nr < 0 || 
                nc >= board.length || 
                nc < 0 ||
                isCrush(nr, nc)) {
                this.isDead = true;
                return ;
            }
            // 뱀의 몸통 이동
            for (int i = moveHistory.size()-1; i >= 1; i--) {
                moveHistory.set(i, moveHistory.get(i-1));
            }
            moveHistory.set(0, new Pair(nr, nc));
            // 뱀의 머리가 이동한 곳에 사과가 있는 경우, 꼬리는 움직이지 않는다.
            if (board[nr][nc]) {
                moveHistory.add(tail);
                board[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r-1][c-1] = true;
        }
        int L = Integer.parseInt(br.readLine());
        Snake snake = new Snake(); // 뱀의 기본 이동 방향은 오른쪽
        Deque<Direction> queue = new ArrayDeque<>();    
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            queue.offer(new Direction(X, C));
        }
        int time = 0;
        while (!snake.isDead) {
            if (!queue.isEmpty()) {
                Direction direction = queue.peek();
                if (direction.second == time) {
                    direction = queue.poll();
                    snake.moveHead(direction.dir);
                }
            }
            snake.move();
            time += 1;
        }
        System.out.println(time);
    }
}
