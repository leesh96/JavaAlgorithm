package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 9086
문제제목 : 문자열
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 charAt 함수 사용

채점 결과 : 128ms/14004KB
풀이 날짜 : 2021/11/28
*/

public class B9086 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            bw.write(input.charAt(0));
            bw.write(input.charAt(input.length() - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
