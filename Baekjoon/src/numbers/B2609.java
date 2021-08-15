package numbers;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 플랫폼 : 백준
 * 문제번호 : 2609
 * 문제제목 : 최대공약수와 최소공배수
 * 난이도 : 실버 5
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 수학, 정수론, 유클리드 호제법
 *
 * 알고리즘 설명
 * 1. 최대공약수 : 유클리드 호제법
 * 2. 최소공배수 : 최대공약수 * 두 수를 최대공약수로 나눈 몫의 곱
 *
 * 채점 결과 : 168ms/15908KB
 * 풀이 날짜 : 2021/08/15
**/

public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int g = gcd(a, b);
        bw.write(g + "\n");
        bw.write(g * (a / g) * (b / g) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
