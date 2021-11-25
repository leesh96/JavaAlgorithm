package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2744
문제제목 : 대소문자 바꾸기
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 아스키코드 +- 32

채점 결과 : 124ms/14204KB
풀이 날짜 : 2021/11/25
*/

public class B2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        for (char cur : input) {
            if (cur - 'a' >= 0) {
                bw.write((char)(cur - 32));
            } else {
                bw.write((char)(cur + 32));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
