package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 17144
문제제목 : 미세먼지 안녕!
난이도 : 골드 4
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 조건에 맞게 미세먼지 확산 -> 원래 양의 /5 만큼 해야하므로 배열 복사해서 사용
2. 공기청정기 바람에 따라 먼지 이동 -> 역방향으로 해주면 간단함

채점 결과 : 264ms/25920KB
풀이 날짜 : 2021/11/08
*/

public class B17144 {
    static int n, m, t;
    static int[][] room;
    static int upRow = -1, downRow = -1;

    static final int[] dr = { -1, 0, 1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    if (upRow == -1) {
                        upRow = i;
                    } else {
                        downRow = i;
                    }
                }
            }
        }

        while (t-- > 0) {
            room = dust();
            clean();
        }

        int answer = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += room[i][j];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] dust() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }

                temp[i][j] += room[i][j];
                int amount = room[i][j] / 5;

                for (int d = 0; d < 4; d++) {
                    int nextR = i + dr[d];
                    int nextC = j + dc[d];

                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && room[nextR][nextC] != -1) {
                        temp[nextR][nextC] += amount;
                        temp[i][j] -= amount;
                    }
                }
            }
        }

        return temp;
    }

    static void clean() {
        // 위쪽
        int dir = 0;
        int row = upRow - 1;
        int col = 0;

        while (room[row][col] != -1) {

            if ((row == 0 && col == 0) || (row == 0 && col == m - 1) || (row == upRow && col == m - 1)) {
                dir++;
            }

            room[row][col] = room[row + dr[dir]][col + dc[dir]];

            if (room[row][col] == -1) {
                room[row][col] = 0;
            }

            row += dr[dir];
            col += dc[dir];
        }

        // 아래쪽
        dir = 2;
        row = downRow + 1;
        col = 0;

        while (room[row][col] != -1) {

            if ((row == n - 1 && col == 0) || (row == n - 1 && col == m - 1) || (row == downRow && col == m - 1)) {
                dir--;
                if (dir < 0) {
                    dir = 3;
                }
            }

            room[row][col] = room[row + dr[dir]][col + dc[dir]];

            if (room[row][col] == -1) {
                room[row][col] = 0;
            }

            row += dr[dir];
            col += dc[dir];
        }
    }
}
