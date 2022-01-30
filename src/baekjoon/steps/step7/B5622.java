package baekjoon.steps.step7;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 5622
 * 문제제목 : 다이얼
 * 난이도 : 브론즈 2
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현
 *
 * 채점 결과 : 148ms/15824KB
 * 풀이 날짜 : 2021/08/08
**/

public class B5622 {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine().trim();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'C') {
                count += 3;
            } else if (c >= 'D' && c <= 'F') {
                count += 4;
            } else if (c >= 'G' && c <= 'I') {
                count += 5;
            } else if (c >= 'J' && c <= 'L') {
                count += 6;
            } else if (c >= 'M' && c <= 'O') {
                count += 7;
            } else if (c >= 'P' && c <= 'S') {
                count += 8;
            } else if (c >= 'T' && c <= 'V') {
                count += 9;
            } else if (c >= 'W' && c <= 'Z') {
                count += 10;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
