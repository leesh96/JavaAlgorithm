package baekjoon.numbers;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 5376
 * 문제제목 : 소수를 분수로
 * 난이도 : 실버 1
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 문자열, 파싱
 *
 * 알고리즘 설명
 * 1. 순환소수 -> 분수로 만드는 공식 사용
 * 2. 순환부분 - 비순환부분 / 9 * 순환자릿수 + 0 * 비순환자릿수
 *
 * 채점 결과 : 80ms/11472KB
 * 풀이 날짜 : 2021/07/14
**/

public class B5376 {
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = Integer.parseInt(br.readLine());

        for (int t = 0; t < c; t++) {
            String input = br.readLine().trim();
            int length = input.length();

            long ja = 0;
            int idx = 2;
            while (true) {
                if (idx == length) break;
                if (input.charAt(idx) == '(') break;
                ja = ja * 10 + (input.charAt(idx) - '0');
                idx++;
            }
            int finCnt = idx - 2;
            int infCnt = 0;
            if (idx != length) {
                long fin = ja;
                while (true) {
                    idx++;
                    if (input.charAt(idx) == ')') break;
                    ja = ja * 10 + (input.charAt(idx) - '0');
                    infCnt++;
                }
                if (ja != fin) {
                    ja -= fin;
                }
            }

            long mo = 0;
            while (infCnt-- >= 1) {
                mo = mo * 10 + 9;
            }
//            for (int i = 0; i < infCnt; i++) {
//                mo = mo * 10 + 9;
//            }
            if (mo == 0) mo = 1;
            while (finCnt-- >= 1) {
                mo *= 10;
            }
//            for (int i = 0; i < finCnt; i++) {
//                mo *= 10;
//            }
            long gcd = gcd(mo, ja);
            ja /= gcd;
            mo /= gcd;
            bw.write(ja + "/" + mo + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
