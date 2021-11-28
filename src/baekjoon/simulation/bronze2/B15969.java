package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15969
문제제목 : 행복
난이도 : 브론즈 2
제한사항 : 2초/512MB
알고리즘 분류 : 수학, 구현, 사칙연산

알고리즘 설명
1. 받으면서 비교 -> 시간복잡도 O(n)

채점 결과 : 144ms/14612KB
풀이 날짜 : 2021/11/28
*/

public class B15969 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        bw.write(String.format("%d", max - min));
        bw.flush();
        bw.close();
        br.close();
    }
}
