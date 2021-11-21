package baekjoon.simulation;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10808
문제제목 : 알파벳 개수
난이도 : 브론즈 2
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 배열에 알파벳 수 저장

채점 결과 : 140ms/15916KB
풀이 날짜 : 2021/11/21
*/

public class B10808 {
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            alpha[cur]++;
        }

        for (int cnt : alpha) {
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
