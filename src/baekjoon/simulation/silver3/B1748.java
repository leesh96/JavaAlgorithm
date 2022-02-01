package baekjoon.simulation.silver3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1748
문제제목 : 수 이어 쓰기 1
난이도 : 실버 3
제한사항 : 0.15초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 각 자릿수의 숫자 + 1 만큼 더해주면 모든 숫자의 길이를 누적해서 더해줄 수 있다.

채점 결과 : 124ms/14228KB
풀이 날짜 : 2022/02/01
*/

public class B1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i <= n; i *= 10) {
            answer += n - i + 1;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
