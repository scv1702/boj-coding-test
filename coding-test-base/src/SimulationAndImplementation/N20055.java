package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N20055 {
    static int N;
    static int K;
    static int[] belt;
    static int front;
    static int broken;
    static boolean[] robots;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robots = new boolean[N];
        broken = 0;
        front = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 1;
        while (true) {
            stepOne();
            stepTwo();
            stepThree(); 
            if (stepFour()) break;
            answer += 1;
        }
        System.out.println(answer);
    }

    // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    public static void stepOne() {
        // 로봇들을 한 칸씩 회전시킨다.
        for (int i = N-2; i >= 0; i--) {
            if (robots[i]) {
                if (i < N-2) robots[i+1] = true;
                robots[i] = false;
            }
        }
        // 벨트를 한 칸씩 회전시킨다.
        front = (front - 1 + 2*N) % (2*N);
    }

    // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    public static void stepTwo() {
        for (int i = N-2; i >= 0; i--) {
            if (robots[i] && !robots[i+1] && belt[(front+i+1) % (2*N)] >= 1) { 
                if (i < N-2) robots[i+1] = true;
                robots[i] = false;
                belt[(front+i+1) % (2*N)] -= 1;
                if (belt[(front+i+1) % (2*N)] <= 0) broken += 1;
            }
        }
    }

    // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    public static void stepThree() {
        if (belt[front] > 0) {
            robots[0] = true;
            belt[front] -= 1;
            if (belt[front] <= 0) broken += 1;
        }
    }

    // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
    public static boolean stepFour() {
        return broken >= K;
    }
}