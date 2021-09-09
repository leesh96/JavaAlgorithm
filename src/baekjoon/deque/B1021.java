package baekjoon.deque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1021
 * 문제제목 : 회전하는 큐
 * 난이도 : 실버 4
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 덱
 *
 * 알고리즘 설명
 * 1. 덱 첫번째 숫자가 같으면 1번 연산으로 뽑아버림
 * 2. 같지 않은 경우 중간 인덱스 보다 뒤에 있으면 3번 연산이 유리, 중간 인덱스와 같거나 앞에 있으면 2번 연산이 유리
 * 3. 덱 회전 하고 각 연산 횟수 더해주기
 *
 * 채점 결과 : 84ms/11700KB
 * 풀이 날짜 : 2021/07/15
**/

public class B1021 {
    static int n, m;
    static LinkedList<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        int result = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (deque.getFirst() == target) {
                deque.removeFirst();
            } else {
                int idx = deque.indexOf(target);
                int mid;

                if (deque.size() % 2 == 0) {
                    mid = (deque.size() / 2) - 1;
                } else {
                    mid = deque.size() / 2;
                }

                if (idx <= mid) {
                    for (int j = 0; j < idx; j++) {
                        deque.addLast(deque.removeFirst());
                    }
                    deque.removeFirst();
                    result += idx;
                } else {
                    for (int j = 0; j < deque.size() - idx; j++) {
                        deque.addFirst(deque.removeLast());
                    }
                    result += (deque.size() - idx);
                    deque.removeFirst();
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
