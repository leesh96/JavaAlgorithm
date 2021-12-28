package baekjoon.simulation.silver5;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 8979
문제제목 : 올림픽
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 정렬

알고리즘 설명
1. 국가의 번호와 메달 수를 담는 클래스 선언
2. 위의 클래스를 담는 우선순위 큐 선언
3. 우선순위 큐에서 poll하면서 랭크 계산

채점 결과 : 168ms/15016KB
풀이 날짜 : 2021/12/28
*/

public class B8979 {

    static class Nation {
        int number, gold, silver, bronze;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Nation> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o2.gold == o1.gold) {
                if (o2.silver == o1.silver) {
                    return o2.bronze - o1.bronze;
                }

                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        }));

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Nation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Nation prev = pq.poll();
        int rank = 1;
        int count = 1;
        if (prev.number != k) {
            while (!pq.isEmpty()) {
                Nation cur = pq.poll();
                count++;
                if (prev.gold != cur.gold || prev.silver != cur.silver || prev.bronze != cur.bronze) {
                    prev = cur;
                    rank = count;
                }

                if (cur.number == k) {
                    break;
                }
            }
        }

        bw.write(String.format("%d", rank));
        bw.flush();
        bw.close();
        br.close();
    }
}
