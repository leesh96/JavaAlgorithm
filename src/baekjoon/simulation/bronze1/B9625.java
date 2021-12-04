package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 9625
문제제목 : BABBA
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 다이나믹 프로그래밍

알고리즘 설명
1. 규칙을 찾아보면 a, b 둘다 피보나치 수열 형태를 띈다.
2. 단 3번째 버튼 클릭 부터 시작

채점 결과 : 132ms/14508KB
풀이 날짜 : 2021/12/04
*/

public class B9625 {
    static int n;
    static int[] aCnt = new int[46];
    static int[] bCnt = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        aCnt[1] = 0;
        bCnt[1] = 1;
        aCnt[2] = 1;
        bCnt[2] = 1;

        for (int i = 3; i <= n; i++) {
            aCnt[i] = aCnt[i-1] + aCnt[i-2];
            bCnt[i] = bCnt[i-1] + bCnt[i-2];
        }

        bw.write(String.format("%d %d", aCnt[n], bCnt[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
