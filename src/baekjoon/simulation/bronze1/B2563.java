package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2563
문제제목 : 색종이
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 색종이를 붙인 영역을 1로 표시
2. 1의 개수 카운트

채점 결과 : 128ms/14264KB
풀이 날짜 : 2021/12/02
*/

public class B2563 {
    static int t;
    static int[][] arr;

    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        arr = new int[MAX+1][MAX+1];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int row = y; row < y + 10; row++) {
                for (int col = x; col < x + 10; col++) {
                    arr[row][col] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                }
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
