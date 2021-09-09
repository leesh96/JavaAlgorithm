package baekjoon.step.step3;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 8393
 * 문제제목 : 합
 * 난이도 : 브론즈 5
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 수학, 구현
 *
 * 알고리즘 설명
 * 1 부터 n 까지의 합 구하기
 *
 * 채점 결과 : 156ms/14724KB
 * 풀이 날짜 : 2021/08/05
**/

public class B8393 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
