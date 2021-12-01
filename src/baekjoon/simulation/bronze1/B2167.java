package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2167
문제제목 : 2차원 배열의 합
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 누적합

알고리즘 설명
1. 해당 사각형 범위의 합계 구하기

채점 결과 : 872ms/47908KB
풀이 날짜 : 2021/12/01
*/

public class B2167 {
    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int row = i - 1; row < x; row++) {
                for (int col = j - 1; col < y; col++) {
                    sum += arr[row][col];
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
