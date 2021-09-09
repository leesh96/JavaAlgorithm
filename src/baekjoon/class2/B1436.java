package baekjoon.class2;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1436
 * 문제제목 : 영화감독 숌
 * 난이도 : 실버 5
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 완전 탐색
 *
 * 알고리즘 설명
 * 숫자 666부터 1씩 증가시키면서 666을 포함하면 카운트 -1
 * 카운트 0이 되면 그 숫자가 영화 제목에 들어가는 숫자
 *
 * 채점 결과 : 158752KB/364ms
 * 풀이 날짜 : 2021/07/22
**/

public class B1436 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int num = 665;
        while (n > 0) {
            num++;
            if (String.valueOf(num).contains("666")) {
                n--;
            }
        }
        bw.write(num + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
