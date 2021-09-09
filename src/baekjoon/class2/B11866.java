package baekjoon.class2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11866
 * 문제제목 : 요세푸스 문제 0
 * 난이도 : 실버 4
 * 제한사항 : 2초/512MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * k - 1번 만큼 큐 회전하고 출력 -> k번째
 * 큐에 원소 하나 남을 때 까지만 해야함.
 *
 * 채점 결과 : 128ms/22320KB
 * 풀이 날짜 : 2021/07/18
**/

public class B11866 {
    static int n, k;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        bw.write("<");
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            bw.write(queue.poll() + ", ");
        }
        bw.write(queue.poll() + ">");
        bw.flush();
        bw.close();
        br.close();
    }
}
