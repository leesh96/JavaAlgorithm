package baekjoon.subjects.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 18258
 * 문제제목 : 큐 2
 * 난이도 : 실버 4
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * 큐 구현
 *
 * 채점 결과 : 1752ms/384908KB
 * 풀이 날짜 : 2021/07/14
**/

public class B18258 {
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        int lastPush = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];

            if (order.equals("push")) {
                int num = Integer.parseInt(input[1]);
                lastPush = num;
                queue.offer(num);
            } else if (order.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else if (order.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (order.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (order.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if (order.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(lastPush + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
