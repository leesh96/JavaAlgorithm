package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2702
문제제목 : 초6 수학
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 수학, 정수론, 브루트포스 알고리즘

알고리즘 설명
1. 유클리드 호제법 사용

채점 결과 : 280ms/20280KB
풀이 날짜 : 2021/12/08
*/

public class B2702 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(String.format("%d %d\n", lcm(a, b), gcd(a, b)));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
