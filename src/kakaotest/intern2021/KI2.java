package kakaotest.intern2021;

import java.util.LinkedList;
import java.util.Queue;

public class KI2 {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {

    }

    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int tc = 0; tc < 5; tc++) {
            char[][] place = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    place[i][j] = places[tc][i].charAt(j);
                }
            }
            boolean result = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i][j] == 'P') {
                        result = check(place, new point(i, j));
                    }
                    if (!result) {
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
            if (result) {
                answer[tc] = 1;
            } else {
                answer[tc] = 0;
            }
        }
        return answer;
    }

    static class point {
        int r, c;

        public point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean check(char[][] map, point start) {
        boolean[][] visit = new boolean[5][5];
        Queue<point> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (0 <= nextR && nextR < 5 && 0 <= nextC && nextC < 5 && !visit[nextR][nextC]) {
                    if (Math.abs(nextR - start.r) + Math.abs(nextC - start.c) <= 2) {
                        visit[nextR][nextC] = true;
                        if (map[nextR][nextC] == 'O') {
                            queue.offer(new point(nextR, nextC));
                        } else if (map[nextR][nextC] == 'P') {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
