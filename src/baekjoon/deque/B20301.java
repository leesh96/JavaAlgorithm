package baekjoon.deque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 20301
 * 문제제목 : 반전 요세푸스
 * 난이도 : 실버 4
 * 제한사항 : 1초/1024MB
 * 알고리즘 분류 : 덱, 시뮬레이션
 *
 * 알고리즘 설명
 * M번째 마다 꺼내는 방향 반대로 바꿔준다.
 *
 * 채점 결과 : 644ms/296836KB
 * 풀이 날짜 : 2021/07/16
**/

public class B20301 {
    static int n, k, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int count = 0;
        boolean isReverse = false;
        while (deque.size() != 1) {
            if (!isReverse) {
                for (int i = 0; i < k - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
                bw.write(deque.removeFirst() + "\n");
            } else {
                for (int i = 0; i < k - 1; i++) {
                    deque.addFirst(deque.removeLast());
                }
                bw.write(deque.removeLast() + "\n");
            }
            count++;
            if (count % m == 0) {
                isReverse = !isReverse;
            }
        }
        bw.write(deque.removeFirst() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
