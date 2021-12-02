package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11655
문제제목 : ROT13
난이도 : 브론즈 1
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 아스키코드 +13, 알파벳 범위 벗어나면 -26

채점 결과 : 124ms/14284KB
풀이 날짜 : 2021/12/02
*/

public class B11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        for (char c : input) {
            bw.write(rot13(c));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static char rot13(char c) {
        int res = c;

        if ('a' <= c && c <= 'z') {
            res = c + 13;

            if (res > 122) {
                res -= 26;
            }
        } else if ('A' <= c && c <= 'Z'){
            res = c + 13;

            if (res > 90) {
                res -= 26;
            }
        }

        return (char) res;
    }
}
