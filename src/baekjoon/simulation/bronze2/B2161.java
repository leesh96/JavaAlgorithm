package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
플랫폼 : 백준
문제번호 : 2161
문제제목 : 카드1
난이도 : 브론즈 2
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 자료 구조, 덱, 큐

알고리즘 설명
1. deque에서 카드 조작
2. dummy 큐에 버리는 카드 추가
3. dummy 먼저 출력하고 deque 출력

채점 결과 : 140ms/14536KB
풀이 날짜 : 2021/11/27
*/

public class B2161 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> dummy = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            dummy.add(deque.poll());
            deque.addLast(deque.poll());
        }

        while (!dummy.isEmpty()) {
            bw.write(dummy.poll() + " ");
        }

        while (!deque.isEmpty()) {
            bw.write(deque.poll() + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
