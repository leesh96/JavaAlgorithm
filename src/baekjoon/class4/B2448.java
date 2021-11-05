package baekjoon.class4;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 2448
문제제목 : 별 찍기 - 11
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 분할 정복, 재귀

알고리즘 설명
분할 정복 문제 풀이

채점 결과 : 564ms/54464KB
풀이 날짜 : 2021/11/05
*/

public class B2448 {
    static int n;
    static char[][] pane;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        pane = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pane[i], ' ');
        }
        dfs(n, 0, n - 1);
        for (int i =0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                bw.write(pane[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int n, int row, int col) {
        if (n == 3) {
            print(row, col);
            return;
        }

        dfs(n / 2, row, col);
        dfs(n / 2, row + n / 2, col - n / 2);
        dfs(n / 2, row + n / 2, col + n / 2);
    }

    static void print(int row, int col) {
        pane[row][col] = '*';

        pane[row+1][col-1] = '*';
        pane[row+1][col+1] = '*';

        for (int c = col-2; c <= col + 2; c++) {
            pane[row+2][c] = '*';
        }
    }
}
