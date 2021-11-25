package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11365
문제제목 : !밀비 급일
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. StringBuffer를 사용하여 문자열 뒤집기

채점 결과 : 120ms/14276KB
풀이 날짜 : 2021/11/25
*/

public class B11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals("END")) {
                break;
            }

            bw.write(new StringBuffer(input).reverse() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
