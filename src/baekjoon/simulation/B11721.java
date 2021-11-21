package baekjoon.simulation;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11721
문제제목 : 열 개씩 끊어 출력하기
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 subString() 함수 사용

채점 결과 : 124ms/14248KB
풀이 날짜 : 2021/11/21
*/

public class B11721 {
    static final int STEP = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int len = N.length();
        int idx = 0;

        while (true) {
            if (idx + STEP <= len) {
                bw.write(N.substring(idx, idx + STEP));
            } else {
                bw.write(N.substring(idx));
                break;
            }

            bw.newLine();
            idx += STEP;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
