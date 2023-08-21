package SimulationAndImplementation;

import java.io.*;
import java.util.*;

public class N16935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // column
        int M = Integer.parseInt(st.nextToken()); // row
        int R = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int opcode = Integer.parseInt(st.nextToken());
            switch(opcode) {
                case 1: switchUpToDown(A); break;
                case 2: switchLeftToRight(A); break;
                case 3: A = turnRight(A); break;
                case 4: A = turnLeft(A); break;
                case 5: turnInsideRight(A); break;
                case 6: turnInsideLeft(A); break;
                default: break;
            }
        }
        print(A);
    }

    public static void swap(int[][] A, int a, int b, int c, int d) {
        int temp = A[a][b];
        A[a][b] = A[c][d];
        A[c][d] = temp;
    }

    public static void switchUpToDown(int[][] A) {
        for (int i = 0; i < A.length / 2; i++) {
            for (int j = 0; j < A[0].length; j++) {
                swap(A, i, j, A.length-1-i, j);
            }
        }
    }

    public static void switchLeftToRight(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                swap(A, i, j, i, A[0].length-1-j);
            }
        }
    }

    public static int[][] turnRight(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int count = Math.min(N, M) / 2;
        int[][] B = new int[M][N];
        for (int k = 0; k < count; k++) {
            int tempSize = 2*(N-2*k)+2*(M-2*k)-4;
            int[] temp = new int[tempSize];
            int tempIdx = 0;
            // top right
            for (int j = k; j < M-k; j++) {
                temp[tempIdx++] = A[k][j];
            }
            // down
            for (int i = k+1; i < N-k; i++) {
                temp[tempIdx++] = A[i][M-k-1];
            }
            // bottom left
            for (int j = M-k-2; j >= k; j--) {
                temp[tempIdx++] = A[N-k-1][j];
            }
            // up
            for (int i = N-k-2; i >= k+1; i--) {
                temp[tempIdx++] = A[i][k];
            }
            tempIdx = tempSize-1-(N-2*k-2);
            // top right
            for (int j = k; j < N-k; j++) {
                B[k][j] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // down
            for (int i = k+1; i < M-k; i++) {
                B[i][N-k-1] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // bottom left
            for (int j = N-k-2; j >= k; j--) {
                B[M-k-1][j] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // up
            for (int i = M-k-2; i >= k+1; i--) {
                B[i][k] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
        }
        return B;
    }

    public static int[][] turnLeft(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int count = Math.min(N, M) / 2;
        int[][] B = new int[M][N];
        for (int k = 0; k < count; k++) {
            int tempSize = 2*(N-2*k)+2*(M-2*k)-4;
            int[] temp = new int[tempSize];
            int tempIdx = 0;
            // top left
            for (int j = M-1-k; j >= k; j--) {
                temp[tempIdx++] = A[k][j];
            }
            // down
            for (int i = k+1; i < N-k; i++) {
                temp[tempIdx++] = A[i][k];
            }
            // bottom right
            for (int j = k+1; j < M-k; j++) {
                temp[tempIdx++] = A[N-k-1][j];
            }
            // up
            for (int i = N-k-2; i >= k+1; i--) {
                temp[tempIdx++] = A[i][M-k-1];
            }
            tempIdx = tempSize-1-(N-2*k-2);
            // top left
            for (int j = N-1-k; j >= k; j--) {
                B[k][j] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // down
            for (int i = k+1; i < M-k; i++) {
                B[i][k] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // bottom right
            for (int j = k+1; j < N-k; j++) {
                B[M-k-1][j] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
            // up
            for (int i = M-k-2; i >= k+1; i--) {
                B[i][N-k-1] = temp[tempIdx];
                tempIdx = (tempIdx + 1) % tempSize;
            }
        }
        return B;
    }

    public static void turnInsideRight(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] temp = new int[N/2][M/2];
        // copy group1
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                temp[i][j] = A[i][j];
            }
        }
        // move group 4 to group 1
        for (int i = N/2; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                A[i-N/2][j] = A[i][j];
            }
        }
        // move group 3 to group 4
        for (int i = N/2; i < N; i++) {
            for (int j = M/2; j < M; j++) {
                A[i][j-M/2] = A[i][j];
            }
        }
        // move group 2 to group 3
        for (int i = 0; i < N/2; i++) {
            for (int j = M/2; j < M; j++) {
                A[i+N/2][j] = A[i][j];
            }
        }
        // move group 1 to group 2
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                A[i][j+M/2] = temp[i][j];
            }
        }
    }

    public static void turnInsideLeft(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] temp = new int[N/2][M/2];
        // copy group1
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                temp[i][j] = A[i][j];
            }
        }
        // move group 2 to group 1
        for (int i = 0; i < N/2; i++) {
            for (int j = M/2; j < M; j++) {
                A[i][j-M/2] = A[i][j];
            }
        }
        // move group 3 to group 2
        for (int i = N/2; i < N; i++) {
            for (int j = M/2; j < M; j++) {
                A[i-N/2][j] = A[i][j];
            }
        }
        // move group 4 to group 3
        for (int i = N/2; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                A[i][j+M/2] = A[i][j];
            }
        }
        // move group 1 to group 4
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                A[i+N/2][j] = temp[i][j];
            }
        }
    }

    public static void print(int[][] A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}