package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10820
문제제목 : 문자열 분석
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
문자열 검증

채점 결과 : 184ms/14704KB
풀이 날짜 : 2021/11/23
*/

public class B10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();

            if (input.equals("")) {
                break;
            }

            int lower = 0;
            int upper = 0;
            int number = 0;
            int space = 0;

            for (char c : input.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    lower++;
                } else if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= '0' && c <= '9') {
                    number++;
                } else {
                    space++;
                }
            }

            bw.write(String.format("%d %d %d %d\n", lower, upper, number, space));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
