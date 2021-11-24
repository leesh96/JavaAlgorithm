package baekjoon.simulation.bronze2;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10987
문제제목 : 모음의 개수
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 문자열 탐색

채점 결과 : 128ms/14412KB
풀이 날짜 : 2021/11/24
*/

public class B10987 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
