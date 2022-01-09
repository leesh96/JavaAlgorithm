package baekjoon.simulation.silver5;

import java.io.*;
import java.util.PriorityQueue;

/*
플랫폼 : 백준
문제번호 : 1251
문제제목 : 단어 나누기
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열, 브루트포스 알고리즘, 정렬

알고리즘 설명
1. 문자열을 세 부분으로 나눌 수 있는 모든 경우 탐색
2. StringBuilder의 reverse 메소드 사용
3. 최소힙 우선순위큐에 넣고 첫번째 문자열을 꺼내서 출력

채점 결과 : 140ms/15116KB
풀이 날짜 : 2022/01/09
*/

public class B1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                StringBuilder first = new StringBuilder(str.substring(0, i));
                StringBuilder second = new StringBuilder(str.substring(i, j));
                StringBuilder third = new StringBuilder(str.substring(j));

                StringBuilder sb = new StringBuilder();
                sb.append(first.reverse());
                sb.append(second.reverse());
                sb.append(third.reverse());

                pq.add(sb.toString());
            }
        }

        bw.write(pq.poll());
        bw.flush();
        bw.close();
        br.close();
    }
}
