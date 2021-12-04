package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2669
문제제목 : 직사각형 네개의 합집합의 면적 구하기
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 좌표에 사각형 1로 표시
2. 좌표 구역의 합계 구해서 출력

채점 결과 : 124ms/14256KB
풀이 날짜 : 2021/12/04
*/

public class B2669 {
    static final int MAX = 100;
    static int[][] map = new int[MAX+1][MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int col = a; col < c; col++) {
                for (int row = b; row < d; row++) {
                    map[row][col] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                sum += map[i][j];
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
