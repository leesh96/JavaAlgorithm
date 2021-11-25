package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10995
문제제목 : 별 찍기 - 20
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현

알고리즘 설명
1. n 만큼 돌면서 각 줄이 짝수면 "* ", 홀수면 " *" 패턴

채점 결과 : 132ms/14408KB
풀이 날짜 : 2021/11/25
*/

public class B10995 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    bw.write("* ");
                }
            } else {
                for (int j = 0; j < n; j++) {
                    bw.write(" *");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
