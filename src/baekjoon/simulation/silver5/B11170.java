package baekjoon.simulation.silver5;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11170
문제제목 : 0의 개수
난이도 : 실버 5
제한사항 : 3초/256MB
알고리즘 분류 : 수학, 구현, 브루트포스 알고리즘

알고리즘 설명
1. 구간 내의 모든 수에 대해서 0이 몇 개인지 세어본다.
2. 미리 수들이 0의 수를 더해놓고 가는 것도 좋아보임

채점 결과 : 240ms/14456KB
풀이 날짜 : 2022/01/08
*/

public class B11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(countZero(n, m) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int countZero(int n, int m) {
        int result = 0;

        for (int i = n; i <= m; i++) {
            if (i == 0) {
                result++;
                continue;
            }

            int cur = i;
            while (cur > 0) {
                if (cur % 10 == 0) {
                    result++;
                }
                cur /= 10;
            }
        }

        return result;
    }
}
