package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2789
문제제목 : 유학 금지
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 indexOf 함수 사용

채점 결과 : 120ms/14240KB
풀이 날짜 : 2021/11/28
*/

public class B2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String cambridge = "CAMBRIDGE";
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            if (cambridge.indexOf(c) == -1) {
                bw.write(c);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
