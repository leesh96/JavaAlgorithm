package baekjoon.classes.class4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2206
문제제목 : 벽 부수고 이동하기
난이도 : 골드 4
제한사항 : 2초/192MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 4가지 방향과 3가지 경우에 대해서 너비우선탐색
2. 다음 좌표가 벽이 아닌경우 벽을 부순적이 있다면 벽을 부순 상태를 큐에 넣고 벽 부수고 방문 배열 체크
3. 벽을 부순적이 없다면 벽을 부수지 않은 상태를 큐에 넣고 벽 안 부수고 방문 배열 체크
4. 다음 좌표가 벽인 경우 벽을 부순적이 없을때만 진행가능
5. 다음 상태 정보에는 좌표와 거리, 벽을 부수고 이동했는지 여부를 담는 flag가 들어있음

채점 결과 : 776ms/165036KB
풀이 날짜 : 2021/10/29
*/

public class B2206 {
    static int n, m;
    static int[][] map;
    static boolean[][][] visit;

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    static class State {
        int r, c, dist;
        boolean wall;

        public State(int r, int c, int dist, boolean wall) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visit = new boolean[n][m][2];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 1, false));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.r == n - 1 && cur.c == m - 1) {
                bw.write(cur.dist + "");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            int nextD = cur.dist + 1;

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m) {
                    if (map[nextR][nextC] == 0) {
                        if (!visit[nextR][nextC][0] && !cur.wall) {
                            visit[nextR][nextC][0] = true;
                            queue.offer(new State(nextR, nextC, nextD, false));
                        } else if (!visit[nextR][nextC][1] && cur.wall) {
                            visit[nextR][nextC][1] = true;
                            queue.offer(new State(nextR, nextC, nextD, true));
                        }
                    } else {
                        if (!cur.wall) {
                            visit[nextR][nextC][1] = true;
                            queue.offer(new State(nextR, nextC, nextD, true));
                        }
                    }
                }
            }
        }

        bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
    }
}
