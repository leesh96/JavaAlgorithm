package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1924
문제제목 : 2007년
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 2007년의 몇 일째 날인지 구하고
2. 7로 나눈 나머지가 요일

채점 결과 : 124ms/14228KB
풀이 날짜 : 2021/11/29
*/

public class B1924 {
    static final int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static final String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += daysOfMonth[i];
        }
        sum += day;

        bw.write(days[sum % 7]);
        bw.flush();
        bw.close();
        br.close();
    }
}
