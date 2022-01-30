package baekjoon.classes.class4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 13549
문제제목 : 숨바꼭질 3
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS, 다익스트라, 0-1 BFS

알고리즘 설명
3가지 풀이법
1. BFS
2. 다익스트라(우선순위 큐)
3. 0-1 BFS(덱)

채점 결과 : 184ms/19124KB
풀이 날짜 : 2021/10/27
*/

public class B13549 {
    static int n, k;
    static int[] time;
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            bw.write("0");
        } else {
            time = new int[MAX + 1];
            Arrays.fill(time, -1);
            bfs();
            bw.write(time[k] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == k) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = cur * 2;
                } else if (i == 1) {
                    next = cur - 1;
                } else {
                    next = cur + 1;
                }

                if (0 <= next && next <= MAX && time[next] == -1) {
                    queue.offer(next);
                    if (i == 0) {
                        time[next] = time[cur];
                    } else {
                        time[next] = time[cur] + 1;
                    }
                }
            }
        }
    }
}
