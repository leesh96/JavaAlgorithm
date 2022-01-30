package baekjoon.classes.class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2231
 * 문제제목 : 분해합
 * 난이도 : 브론즈 2
 * 제한사항 : 2초/192MB
 * 알고리즘 분류 : 완전 탐색
 *
 * 알고리즘 설명
 * 분해합이 가능한 범위 제한 두기 -> 자릿수 * 9 만큼 뺀 수부터 N까지 탐색
 * 정수 자릿수 파싱하기
 *
 * 채점 결과 : 84ms/11516KB
 * 풀이 날짜 : 2021/07/17
**/

public class B2231 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        int len = 0;
        int ten = 1;
        while (n / ten != 0) {
            len++;
            ten *= 10;
        }
        int range = len * 9;
        int result = 0;
        for (int i = n - range; i <= n; i++) {
            int cur = i;
            int sum = cur;
            int temp = (int) Math.pow(10, len);
            while (temp > 0) {
                sum += cur / temp;
                cur %= temp;
                temp /= 10;
            }

            if (sum == n) {
                result = i;
                break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
