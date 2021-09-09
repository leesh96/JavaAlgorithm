package baekjoon.class2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1929
 * 문제제목 : 소수 구하기
 * 난이도 : 실버 2
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 정수론, 소수 판정, 에라토스테네스의 체
 *
 * 알고리즘 설명
 * 에라토스테네스의 체를 사용한 소수 판별
 *
 * 채점 결과 : 324ms/21792KB
 * 풀이 날짜 : 2021/07/22
**/

public class B1929 {
    static int m, n;
    static boolean[] che;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        che = new boolean[n+1];
        che[1] = true;
        for (int i = 2; i <= n; i++) {
            if (che[i]) continue;
            for (int j = i + i; j <= n; j += i) {
                if (!che[j]) {
                    che[j] = true;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (!che[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
