package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11504
문제제목 : 돌려 돌려 돌림판!
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
완전탐색, 인덱스는 모듈러 연산으로 배열 안에서만 돌 수 있도록

채점 결과 : 168ms/16412KB
풀이 날짜 : 2021/11/16
*/

public class B11504 {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                x = x * 10 + Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                y = y * 10 + Integer.parseInt(st.nextToken());
            }

            int[] pane = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pane[i]= Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                int num = 0;
                for (int j = i; j < i + m; j++) {
                    num = num * 10 + pane[j % n];
                }
                if (x <= num && num <= y) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
