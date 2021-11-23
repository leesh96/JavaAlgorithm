package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10996
문제제목 : 별 찍기 - 21
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. n의 2배 까지 돌면서, 홀수 줄과 짝수 줄에서 다른 패턴

채점 결과 : 140ms/14364KB
풀이 날짜 : 2021/11/22
*/

public class B10996 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) {
                        bw.write(" ");
                    } else {
                        bw.write("*");
                    }
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
