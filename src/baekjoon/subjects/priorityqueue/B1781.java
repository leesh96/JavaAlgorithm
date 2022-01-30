package baekjoon.subjects.priorityqueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1781
 * 문제제목 : 컵라면
 * 난이도 : 골드 2
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 우선순위 큐, 그리디
 *
 * 알고리즘 설명
 * 1. 우선순위 큐 2개 사용
 * 2. 퀴즈 데드라인 최소 힙, 라면 최소 힙
 * 3. 퀴즈 데드라인 하나씩 뽑으면서, 라면에 넣고 라면 최소 힙에 데드라인 보다 많은 size가 들어있으면 빼준다. (최소 힙으로 구현해서 그리디)
 *
 * 채점 결과 : 1116ms/74164KB
 * 풀이 날짜 : 2021/07/16
**/

public class B1781 {
    static int n;
    static PriorityQueue<quiz> queue;
    static PriorityQueue<Integer> ramen;

    static class quiz {
        int time, ramen;

        public quiz(int t, int r) {
            this.time = t;
            this.ramen = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>(((o1, o2) -> o1.time - o2.time));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new quiz(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        long result = 0;
        ramen = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            quiz cur = queue.poll();
            ramen.add(cur.ramen);
            while (!ramen.isEmpty() && ramen.size() > cur.time) {
                ramen.poll();
            }
        }
        while (!ramen.isEmpty()) {
            result += ramen.poll();
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
