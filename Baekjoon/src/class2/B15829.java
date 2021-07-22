package class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 15829
 * 문제제목 : Hashing
 * 난이도 : 브론즈 2
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 문자열, 해싱
 *
 * 알고리즘 설명
 * 1. 모듈러 연산(나머지 연산) 분배법칙
 * 2. DP로 거듭제곱의 나머지 구해놓고 쓰는거랑 그때그때 구해가면서 하는거랑 4ms 차이
 * long 자료형 사용해야 100점
 *
 * 채점 결과 : 80ms/11592KB
 * 풀이 날짜 : 2021/07/17
**/

public class B15829 {
    static final int MOD = 1234567891;
    static final int PRIME = 31;
    static int l;
    static char[] input;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        l = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        dp = new long[l+1];
        dp[0] = 1;
        for (int i = 1; i <= l; i++) {
            dp[i] = (dp[i-1] * PRIME) % MOD;
        }

        long result = 0;
        for (int i = 0; i < l; i++) {
            int cur = input[i] - 'a' + 1;
            result = (result + cur * dp[i]) % MOD;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
