package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10870
문제제목 : 피보나치 수 5
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 구현, 다이나믹 프로그래밍

알고리즘 설명
1. 피보나치 DP

채점 결과 : 132ms/14456KB
풀이 날짜 : 2021/11/21
*/

public class B10870 {
    static int n;
    static int[] fibonacci;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        fibonacci = new int[21];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
            }
        }

        bw.write(fibonacci[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
