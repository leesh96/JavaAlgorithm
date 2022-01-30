package baekjoon.classes.class4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 12851
문제제목 : 숨바꼭질 2
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 다음 노드에서의 시간의 경우에 따라 큐 조작
2. 같거나 한번도 방문하지 않은 경우에만 큐에 넣어주고 시간 배열 갱신
3. 작은 경우 발생하지 않음 -> 다음 노드가 1초 후이기 때문에
4. 큰 경우는 볼 필요가 없음
5. 갱신된 최소 시간보다 커진 경우는 볼 필요 없음

채점 결과 : 216ms/23108KB
풀이 날짜 : 2021/11/02
*/

public class B12851 {
    static int n, k;
    static int[] time;
    static int count, minT;

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        time = new int[MAX+1];
        count = 0;
        minT = Integer.MAX_VALUE;

        if (n >= k) {
            bw.write((n - k) + "\n1");
        } else {
            bfs();
            bw.write(minT + "\n" + count);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty() && minT >= time[queue.peek()]) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                } else {
                    next = cur * 2;
                }

                if (0 > next || next > MAX) {
                    continue;
                }

                if (next == k) {
                    minT = time[cur];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[cur] + 1) {
                    queue.offer(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
    }
}
