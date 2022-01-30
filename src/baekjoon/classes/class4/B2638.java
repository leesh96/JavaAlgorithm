package baekjoon.classes.class4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2638
문제제목 : 치즈
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, DFS, BFS, 구현, 시뮬레이션

알고리즘 설명
1. BFS로 외부 공기인 곳 표시 (4방향에서 치즈가 아닌 애를 큐에 삽입하면 내부 공기는 외부 공기가 아니게 됨)
2. 치즈 좌표들에 대해서 녹아야하는지 체크
3. 치즈의 개수가 0이라면 전부 녹은것

채점 결과 : 292ms/41644KB
풀이 날짜 : 2021/11/06
*/

public class B2638 {
    static int n, m, cheeseCount;
    static int[][] map;
    static ArrayList<Point> cheese;
    static boolean[][] visit;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cheeseCount = 0;
        cheese = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese.add(new Point(i, j));
                    cheeseCount++;
                }
            }
        }

        int time = 0;
        while (cheeseCount != 0) {
            visit = new boolean[n][m];
            bfs();
            check();
            time++;
        }

        bw.write(time + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visit[0][0] = true;
        map[0][0] = -1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (0 <= nextR && nextR < n && 0<= nextC && nextC < m) {
                    if (!visit[nextR][nextC] && map[nextR][nextC] != 1) {
                        visit[nextR][nextC] = true;
                        map[nextR][nextC] = -1;
                        queue.offer(new Point(nextR, nextC));
                    }
                }
            }
        }
    }

    static void check() {
        for (int i = 0; i < cheese.size(); i++) {
            Point cur = cheese.get(i);
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nextR = cur.r + dr[j];
                int nextC = cur.c + dc[j];

                if (map[nextR][nextC] == -1) {
                    count++;
                }

                if (count >= 2) {
                    break;
                }
            }

            if (count >= 2) {
                map[cur.r][cur.c] = 0;
                cheeseCount--;
                cheese.remove(i);
                i--;
            }
        }
    }
}
