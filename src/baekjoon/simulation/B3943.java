package baekjoon.simulation;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 3943
문제제목 : 헤일스톤 수열
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 수열 나열할 때마다 최댓값 갱신

채점 결과 : 456ms/27312KB
풀이 날짜 : 2021/11/15
*/

public class B3943 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int answer = n;

            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = n * 3 + 1;
                }
                answer = Math.max(answer, n);
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
