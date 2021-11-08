package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 13172
문제제목 : ∑
난이도 : 골드 5
제한사항 : 1초/512MB
알고리즘 분류 : 수학, 정수론, 분할 정복을 이용한 거듭제곱, 페르마의 소정리

알고리즘 설명
페르마의 소정리

채점 결과 : 228ms/19788KB
풀이 날짜 : 2021/11/08
*/

public class B13172 {
    static int m;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        m = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            answer = (answer + fraction(s, n)) % MOD;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static long inverse(long b, int n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = result * b % MOD;
            }
            b = b * b % MOD;
            n >>= 1;
        }
        return result;
    }

    static long fraction(long a, long b) {
        return a * inverse(b, MOD-2) % MOD;
    }
}
