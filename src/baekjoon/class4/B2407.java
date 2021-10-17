package baekjoon.class4;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2407
문제제목 : 조합
난이도 : 실버 3
제한사항 : 2초/128MB
알고리즘 분류 : 수학, DP, 조합론, 임의 정밀도, 큰 수 연산

알고리즘 설명
1. BigInteger 클래스를 써서 큰 수 연산을 진행해야 오버플로우 발생하지 않음
2. 조합 공식을 그대로 적용
3. nCr = n! / (n - r)! * r!

채점 결과 : 140ms/14372KB
풀이 날짜 : 2021/10/17
*/

public class B2407 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger answer = n1.divide(n2);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
