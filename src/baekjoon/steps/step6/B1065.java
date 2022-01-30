package baekjoon.steps.step6;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1065
 * 문제제목 : 한수
 * 난이도 : 실버 4
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 완전 탐색
 *
 * 알고리즘 설명
 * 1. n이 100보다 작으면 1부터 n까지 모든 수가 한수
 * 2. n이 100보다 큰 경우 한수인지 판별
 *
 * 채점 결과 : 160ms/15816KB
 * 풀이 날짜 : 2021/08/08
**/

public class B1065 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n < 100) {
            count = n;
        } else {
            if (n == 1000) {
                n = 999;
            }
            count = 99;
            for (int i = 100; i <= n; i++) {
                if (check(i)) {
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(int n) {
        boolean result = false;
        int th = n / 100;
        int se = (n % 100) / 10;
        int on = n % 10;
        if ((th - se) == (se - on)) {
            result = true;
        }
        return result;
    }
}
