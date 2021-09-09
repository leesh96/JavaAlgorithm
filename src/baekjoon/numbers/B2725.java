package baekjoon.numbers;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2725
 * 문제제목 : 보이는 점의 개수
 * 난이도 : 실버 2
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 정수론, 유클리드 호제법, 누적 합
 *
 * 알고리즘 설명
 * 1. 1000, 1000 까지의 보이는 점의 개수 메모이제이션 사용
 * 2. 좌표 범위의 우하단 절반 삼각형 만큼 보이는 점의 누적 갯수 구함
 * 3. 두 좌표의 최대공약수가 1이면 점이 보임
 * 4. 보이는 점 * 2 - 1이 답
 *
 * 채점 결과 : 132ms/11992KB
 * 풀이 날짜 : 2021/07/13
**/

public class B2725 {
    static int c;
    static int[] dp;
    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[MAX+1];
        dp[0] = 0;
        dp[1] = 2;
        for (int i = 2; i <= MAX; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) count++;
            }
            dp[i] = dp[i-1] + count;
        }

        c = Integer.parseInt(br.readLine());
        for (int t = 0; t < c; t++) {
            int n = Integer.parseInt(br.readLine());
            bw.write((dp[n] * 2 - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
