package baekjoon.simulation.silver5;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 13015
문제제목 : 별 찍기 - 23
난이도 : 실버 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현

알고리즘 설명
1. 조건에 맞게 별 출력
2. 첫줄과 끝줄, 중간줄로 나누어서 출력
3. 각 규칙의 시작점을 두고 출력

채점 결과 : 156ms/15196KB
풀이 날짜 : 2022/01/08
*/

public class B13015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int a = 0;
        int b = n - 1;
        int c = 3 * n - 3;
        int d = 4 * n - 4;

        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i == 1 || i == 2 * n - 1) {
                for (int j = a; j <= d; j++) {
                    if (j <= b || c <= j) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
                bw.newLine();
            } else {
                for (int j = 0; j <= d; j++) {
                    if (j == a || j == b || j == c || j == d) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
                bw.newLine();
            }

            if (i < n) {
                a++; b++; c--; d--;
            } else {
                a--; b--; c++; d++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
