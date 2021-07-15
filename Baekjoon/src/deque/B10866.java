package deque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10866
 * 문제제목 : 덱
 * 난이도 : 실버 4
 * 제한사항 : 0.5초/256MB
 * 알고리즘 분류 : 덱
 *
 * 알고리즘 설명
 * 덱 구현
 *
 * 채점 결과 : 168ms/17252KB
 * 풀이 날짜 : 2021/07/15
**/

public class B10866 {
    static int n;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];
            if (order.equals("push_front")) {
                deque.addFirst(Integer.parseInt(input[1]));
            } else if (order.equals("push_back")) {
                deque.addLast(Integer.parseInt(input[1]));
            } else if (order.equals("pop_front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.removeFirst() + "\n");
                }
            } else if (order.equals("pop_back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.removeLast() + "\n");
                }
            } else if (order.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (order.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (order.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekFirst() + "\n");
                }
            } else if (order.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
