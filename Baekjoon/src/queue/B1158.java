package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1158
 * 문제제목 : 요세푸스 문제
 * 난이도 : 실버 5
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * 1. q에 원소가 남아있을 때까지
 * 2. k - 1번 빼고 넣고
 * 3. k번째 원소 빼서 출력 -> K번째 사람 제거
 * 4. 마지막 원소 빼고 출력
 *
 * 채점 결과 : 572ms/293816KB;
 * 풀이 날짜 : 2021/07/14
**/

public class B1158 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        bw.write("<");
        while (q.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            bw.write(q.poll() + ", ");
        }
        bw.write(q.poll() + ">");
        bw.flush();
        bw.close();
        br.close();
    }
}
