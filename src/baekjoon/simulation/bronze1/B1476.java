package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1476
문제제목 : 날짜 계산
난이도 : 실버 5
제한사항 : 2초/4MB
알고리즘 분류 : 수학, 구현, 브루트포스 알고리즘, 정수론, 중국인의 나머지 정리

알고리즘 설명
1. e, s, m을 1씩 증가시키면서 각 범위에 맞게 처리, 총 년도 계속 증가
2. 총 년도 출력

채점 결과 : 128ms/14304KB
풀이 날짜 : 2021/12/26
*/

public class B1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int curE = 1;
        int curS = 1;
        int curM = 1;
        int answer = 1;
        while (true) {
            if (curE > 15) {
                curE = 1;
            }

            if (curS > 28) {
                curS = 1;
            }

            if (curM > 19) {
                curM = 1;
            }

            if (curE == e && curS == s && curM == m) {
                break;
            }

            curE++;
            curS++;
            curM++;
            answer++;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
