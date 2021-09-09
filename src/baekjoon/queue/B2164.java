package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2164
 * 문제제목 : 카드2
 * 난이도 : 실버 4
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * 문제 조건대로 큐를 사용하여 구현
 *
 * 채점 결과 : 160ms/43332KB
 * 풀이 날짜 : 2021/07/14
**/

public class B2164 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }
        bw.write(q.peek() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
