package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1629
문제제목 : 곱셈
난이도 : 실버 1
제한사항 : 0.5초/128MB
알고리즘 분류 : 수학, 분할 정복을 이용한 거듭제곱

알고리즘 설명
1. 재귀 탐색
2. 지수를 반으로 나눠가면서 탐색한다. -> 지수를 1씩 빼면서 할 경우 재귀 호출 횟수가 너무 많아짐
3. 나머지 연산을 중간에 해줘야 오버플로우가 나지 않음

채점 결과 : 136ms/14256KB
풀이 날짜 : 2021/10/21
*/

public class B1629 {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bw.write(multiple(a, b) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static long multiple(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long temp = multiple(a, b / 2);

        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}
