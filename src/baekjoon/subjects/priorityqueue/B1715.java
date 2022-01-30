package baekjoon.subjects.priorityqueue;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1715
 * 문제제목 : 카드 정렬하기
 * 난이도 : 골드 4
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 우선순위 큐, 그리디
 *
 * 알고리즘 설명
 * 1. 최소 힙의 우선순위 큐에 카드 수를 넣는다.
 * 2. 작은 두 카드의 조합을 다시 우선순위 큐에 넣는다. -> 항상 작은 두 경우만 조합 (그리디)
 * 3. 큐에 원소가 1개 남을때 까지 반복
 *
 * 채점 결과 : 396ms/24912KB
 * 풀이 날짜 : 2021/07/16
**/

public class B1715 {
    static int n;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while (queue.size() > 1) {
            int temp = queue.poll() + queue.poll();
            queue.add(temp);
            result += temp;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
