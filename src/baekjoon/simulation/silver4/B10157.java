package baekjoon.simulation.silver4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10157
문제제목 : 자리배정
난이도 : 실버 4
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. 좌표 이동, 방향 설정으로 풀어줌
2. 탐색처럼 방문 표시 필요

채점 결과 : 148ms/15232KB
풀이 날짜 : 2022/01/18
*/

public class B10157 {
    static final int[] dx = { 0, 1, 0, -1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int limit = c * r;

        int k = Integer.parseInt(br.readLine());

        if (limit < k) {
            bw.write("0");
        } else {
            int x = 0; // 열
            int y = 0; // 행
            int num = 1;
            int dir = 0;
            boolean[][] visit = new boolean[r][c];

            while (num != k) {
                visit[y][x] = true;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= c || ny < 0 || ny >= r || visit[ny][nx]) {
                    dir++;
                    if (dir > 3) {
                        dir = 0;
                    }
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
                num++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(x + 1).append(" ").append(y + 1);
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
