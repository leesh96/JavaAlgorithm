package baekjoon.classes.class4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 16953
문제제목 : A -> B
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 두 가지 상태 변화에 대해 너비 우선 탐색
2. 방문 배열 또는 비용 담는 배열 사용할 경우 메모리 초과
3. long형으로 선언해야 오버플로우 나지 않음

채점 결과 : 156ms/17628KB
풀이 날짜 : 2021/10/21
*/

public class B16953 {
    static long a, b;

    static class node {
        long num;
        int cost;

        public node(long n, int cost) {
            this.num = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        Queue<node> queue = new LinkedList<>();
        queue.add(new node(a, 0));
        boolean flag = false;

        while (!queue.isEmpty()) {
            node cur = queue.poll();

            if (cur.num == b) {
                flag = true;
                bw.write((cur.cost + 1) + "");
                break;
            }

            long multiple = cur.num * 2;
            long plus = cur.num * 10 + 1;

            if (multiple <= b) {
                queue.add(new node(multiple, cur.cost + 1));
            }

            if (plus <= b) {
                queue.add(new node(plus, cur.cost + 1));
            }
        }

        if (!flag) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
