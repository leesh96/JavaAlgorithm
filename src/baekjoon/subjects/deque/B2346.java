package baekjoon.subjects.deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2346
 * 문제제목 : 풍선 터뜨리기
 * 난이도 : 실버 3
 * 제한사항 : 2초/4MB
 * 알고리즘 분류 : 덱
 *
 * 알고리즘 설명
 * 덱 회전시켜서 푸는 문제
 * ArrayDeque로 선언하고 BufferedWriter 안쓰니까 메모리 초과 안남...
 *
 * 채점 결과 : 136ms/14636KB
 * 풀이 날짜 : 2021/07/16
**/

public class B2346 {
    static int n;
    static Deque<balloon> deque;

    static class balloon {
        int idx, next;

        public balloon(int i, int n) {
            this.idx = i;
            this.next = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.add(new balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.getFirst().idx).append(" ");
            int num = deque.removeFirst().next;
            if (deque.isEmpty()) {
                break;
            }
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else if (num < 0) {
                for (int i = 0; i < Math.abs(num); i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
