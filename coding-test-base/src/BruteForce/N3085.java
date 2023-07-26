package BruteForce;

import java.io.*;

public class N3085 {
    public static void swap(char[][] arr, int y, int x, int nextY, int nextX) {
        char temp = arr[y][x];
        arr[y][x] = arr[nextY][nextX];
        arr[nextY][nextX] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) { 
                board[i][j] = line.charAt(j);
            }
        }
        br.close();
        int answer = 0;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {-1, 0} }; // up, right, down, left
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int k = 0; k < directions.length; k++) {
                    int nextY = y + directions[k][0];
                    int nextX = x + directions[k][1];
                    // find a candy of difference color and swap
                    if ((nextX >= 0 && nextX < N) && (nextY >= 0 && nextY < N)) {
                        if (board[nextY][nextX] != board[y][x]) {
                            swap(board, y, x, nextY, nextX);
                            // search a some sequence in row of same color candies
                            for (int r = 0; r < N; r++) {
                                int contiguous = 1;
                                for (int c = 1; c < N; c++) {
                                    if (board[r][c] == board[r][c-1]) {
                                        contiguous += 1;
                                        answer = Math.max(contiguous, answer);
                                    } else {
                                        contiguous = 1;
                                    }
                                }
                            }
                            // search a some sequence in column of same color candies
                            for (int c = 0; c < N; c++) {
                                int contiguous = 1;
                                for (int r = 1; r < N; r++) {
                                    if (board[r][c] == board[r-1][c]) {
                                        contiguous += 1;
                                        answer = Math.max(contiguous, answer);
                                    } else {
                                        contiguous = 1;
                                    }
                                }
                            }
                            // rollback swap
                            swap(board, nextY, nextX, y, x);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}