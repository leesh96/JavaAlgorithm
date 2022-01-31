package baekjoon.simulation.silver3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2057
문제제목 : 토너먼트
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 수학, 브루트포스 알고리즘

알고리즘 설명
1. 트리 구조에서 위로 따라 올라가면 됌
2. 다음 라운드에서의 자신의 노드 번호는 자신 / 2 + 자신 % 2
3. 지민과 한수의 노드 번호가 같아질 때까지 반복

채점 결과 : 136ms/14240KB
풀이 날짜 : 2022/01/31
*/

public class B1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int round = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }

        bw.write(String.valueOf(round));
        bw.close();
        br.close();
    }
}
