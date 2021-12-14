package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11586
문제제목 : 지영 공주님의 마법 거울
난이도 : 브론즈 1
제한사항 : 2초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 다루기
2. 문자열 좌우반전에는 StringBuilder.reverse() 메소드 사용

채점 결과 : 144ms/14356KB
풀이 날짜 : 2021/12/14
*/

public class B11586 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        String[] mirror = new String[n];
        for (int i = 0; i < n; i++) {
            mirror[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());
        if (k == 1) {
            for (String s : mirror) {
                bw.write(s + "\n");
            }
        } else if (k == 2) {
            for (String s : mirror) {
                bw.write(new StringBuilder(s).reverse() + "\n");
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                bw.write(mirror[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
