package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1453
문제제목 : 피시방 알바
난이도 : 브론즈 1
제한사항 : 2초/128MB
알고리즘 분류 : 구현

알고리즘 설명
1. 좌석에 사람이 앉았는지 표시하는 배열 선언
2. 손님이 앉으려는 자리가 true이면 count++, false인 경우 true로 변경
3. count 출력

채점 결과 : 140ms/14352KB
풀이 날짜 : 2021/12/04
*/

public class B1453 {
    static int n;
    static boolean[] seat = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int person = Integer.parseInt(st.nextToken());
            if (seat[person]) {
                count++;
            } else {
                seat[person] = true;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
