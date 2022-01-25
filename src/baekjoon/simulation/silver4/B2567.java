package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2567
문제제목 : 색종이 - 2
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 색종이인 부분을 1로 마킹
2. 이차원 배열 돌면서 자신이 1이고 주변중 하나가 0이면 둘레이다.

채점 결과 : 128ms/14240KB
풀이 날짜 : 2022/01/25
*/

public class B2567 {
    static final int[] dr = { 1, -1, 0, 0 };
    static final int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[101][101];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int r = y; r < y + 10; r++) {
                for (int c = x; c < x + 10; c++) {
                    paper[r][c] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (1 <= nr && nr <= 100 && 1 <= nc && nc <= 100 && paper[nr][nc] == 0) {
                            answer++;
                        } else if (nr < 1 || nr > 100 || nc < 1 || nc > 100) {
                            answer++;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
