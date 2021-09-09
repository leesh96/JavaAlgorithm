package baekjoon.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 13251
 * 문제제목 : 조약돌 꺼내기
 * 난이도 : 실버 3
 * 제한사항 : 2초/512MB
 * 알고리즘 분류 : 조합론, 확률론
 *
 * 알고리즘 설명
 * 1. 모든 색상에 대해 k만큼 뽑을 때 모두 같은 색일 확률 계산해서
 * 2. 답에 더해준다.
 * 3. k개 보다 많이 있는 색상만 해주면 된다.
 *
 * 채점 결과 : 84ms/11752KB
 * 풀이 날짜 : 2021/07/13
**/

public class B13251 {
    static int n, m ,k;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        m = Integer.parseInt(br.readLine());
        n = 0;
        color = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            n += color[i];
        }
        k = Integer.parseInt(br.readLine());

        double rate = 0;

        for (int i = 0; i < m; i++) {
            if (color[i] >= k) {
                int total = n;
                int pick = k;
                double temp = 1;
                while (pick-- > 0) {
                    temp *= (color[i]-- / (double) total--);
                }
                rate += temp;
            }
        }

        rate = rate >= 1 ? 1.0 : rate;
        bw.write(String.valueOf(rate));
        bw.flush();
        bw.close();
        br.close();
    }
}
