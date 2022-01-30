package baekjoon.steps.step3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11021
 * 문제제목 : A+B - 7
 * 난이도 : 브론즈 3
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 수학, 구현, 사칙연산
 *
 * 채점 결과 : 164ms/14604KB
 * 풀이 날짜 : 2021/08/05
**/

public class B11021 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            bw.write(String.format("Case #%d: %d\n", tc, Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
