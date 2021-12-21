package baekjoon.simulation.bronze1;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2033
문제제목 : 반올림
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. n이 자릿수보다 큰 동안(제일 앞 자리수 전 까지)
2. 반올림을 해준다.

채점 결과 : 128ms/14328KB
풀이 날짜 : 2021/12/21
*/

public class B2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ten = 10;

        while (n > ten) {
            if (n % ten < ten / 2) {
                n -= n % ten;
            } else {
                n -= n % ten;
                n += ten;
            }
            ten *= 10;
        }

        bw.write(n + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
