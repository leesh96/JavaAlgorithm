package baekjoon.class4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11444
문제제목 : 피보나치 수 6
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 분할 정복을 이용한 거듭제곱

알고리즘 설명
재귀와 DP로 풀 수 없는 피보나치 수열 문제
1. 선형방정식 -> 행렬 변환
2. 행렬의 거듭제곱을 활용한 풀이
3. n이 매우 크므로 지수를 반 씩 쪼개면서 풀이

채점 결과 : 132ms/14368KB
풀이 날짜 : 2021/11/01
*/

public class B11444 {
    static long n;
    static long[][] A = { { 1, 1 }, { 1, 0 } };

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        long[][] answer = matrixPow(A, n-1);
        bw.write(answer[0][0] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static long[][] matrixPow(long[][] matrix, long exp) {
        if (exp == 1 || exp == 0) {
            return matrix;
        }

        long[][] result = matrixPow(matrix, exp / 2);

        result = matrixMultiple(result, result);

        if (exp % 2 == 1) {
            result = matrixMultiple(result, A);
        }

        return result;
    }

    static long[][] matrixMultiple(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];

        result[0][0] = ((m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0])) % MOD;
        result[0][1] = ((m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1])) % MOD;
        result[1][0] = ((m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0])) % MOD;
        result[1][1] = ((m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1])) % MOD;

        return result;
    }
}
