package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 10830
문제제목 : 행렬 제곱
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 분할 정복, 분할 정복을 이용한 거듭제곱, 선형대수학

알고리즘 설명
분할 정복을 이용한 거듭제곱 (행렬 버전)

채점 결과 : 148ms/15836KB
풀이 날짜 : 2021/11/01
*/

public class B10830 {
    static int n;
    static long b;
    static long[][] a;

    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        a = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Long.parseLong(st.nextToken()) % MOD;
            }
        }

        long[][] answer = matrixPow(a, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long[][] matrixPow(long[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        long[][] result = matrixPow(matrix, exp / 2);

        result = matrixMultiple(result, result);

        if (exp % 2 == 1) {
            result = matrixMultiple(result, a);
        }

        return result;
    }

    static long[][] matrixMultiple(long[][] m1, long[][] m2) {
        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
