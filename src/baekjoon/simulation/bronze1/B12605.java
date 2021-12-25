package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 12605
문제제목 : 단어순서 뒤집기
난이도 : 브론즈 1
제한사항 : 5초/512MB
알고리즘 분류 : 구현, 자료구조, 문자열, 스택

알고리즘 설명
1. 문자열을 공백으로 구분
2. 구분한 배열을 역순으로 출력

채점 결과 : 136ms/14384KB
풀이 날짜 : 2021/12/25
*/

public class B12605 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");

            bw.write(String.format("Case #%d: ", i));

            for (int j = input.length - 1; j >= 0; j--) {
                bw.write(input[j] + " ");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
