package step.step3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 15552
 * 문제제목 : 빠른 A+B
 * 난이도 : 브론즈 2
 * 제한사항 : 1초(자바 1.5초)/512MB
 * 알고리즘 분류 : 수학, 구현, 사칙연산
 *
 * 채점 결과 : 940ms/237208KB
 * 풀이 날짜 : 2021/08/05
**/

public class B15552 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
