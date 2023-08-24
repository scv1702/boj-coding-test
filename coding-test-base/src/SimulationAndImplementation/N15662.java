package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N15662 {
    static class Gear {
        int[] status;
        int top = 0;

        public Gear(int[] status) {
            this.status = Arrays.copyOf(status, 8);
        }

        public void turnRight() {
            top = (8 + top - 1) % 8;
        }

        public void turnLeft() {
            top = (top + 1) % 8;
        }
    }

    static class Pair {
        int n;
        int d;

        public Pair(int n, int d) {
            this.n = n; this.d = d;
        }
    }

    static class GearArray {
        Gear[] gears;

        public GearArray(Gear[] gears) {
            this.gears = gears;
        }

        public void turn(int n, int d) {
            Deque<Pair> queue = new ArrayDeque<>();
            int temp = d;
            queue.offer(new Pair(n, d));
            for (int i = n+1; i < gears.length; i++) {
                if (gears[i].status[(gears[i].top + 6) % 8] != gears[i-1].status[(gears[i-1].top + 2) % 8]) {
                    d = d * (-1);
                    queue.offer(new Pair(i, d));
                } else {
                    break;
                }
            }
            d = temp;
            for (int i = n-1; i >= 0; i--) {
                if (gears[i].status[(gears[i].top + 2) % 8] != gears[i+1].status[(gears[i+1].top + 6) % 8]) {
                    d = d * (-1);
                    queue.offer(new Pair(i, d));
                } else {
                    break;
                }
            }
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                if (pair.d == 1) gears[pair.n].turnRight();
                if (pair.d == -1) gears[pair.n].turnLeft();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Gear[] gears = new Gear[T];
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int[] status = new int[8];
            for (int j = 0; j < 8; j++) {
                status[j] = line.charAt(j) - '0';
            }
            gears[i] = new Gear(status);
        }
        GearArray gearArray = new GearArray(gears);
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            gearArray.turn(n-1, d);
        }
        int answer = 0;
        for (int i = 0; i < gearArray.gears.length; i++) {
            if (gearArray.gears[i].status[gears[i].top] == 1) answer += 1;
        }
        System.out.println(answer);
    }
}