package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 9455
문제제목 : 박스
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. 열마다 탐색하면서 박스인 곳이 나오면 해당 행 아래에 박스가 아닌 곳의 갯수를 센다

채점 결과 : 396ms/33664KB
풀이 날짜 : 2021/12/17
*/

public class B9455 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(count(grid, n, m) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int count(int[][] grid, int n, int m) {
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    int ptr = j + 1;
                    int temp = 0;
                    while (ptr < n) {
                        if (grid[ptr][i] == 0) {
                            temp++;
                        }
                        ptr++;
                    }
                    cnt += temp;
                }
            }
        }

        return cnt;
    }
}
