package baekjoon.simulation.silver5;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 5555
문제제목 : 반지
난이도 : 실버 5
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 브루트포스 알고리즘

알고리즘 설명
1. 입력과 동시에 탐색
2. 문자열을 마지막에 한번 더 이어 붙임 -> 이렇게 해야 환형으로 탐색 가능
3. StringBuilder의 indexOf 메소드를 사용해서 찾고자하는 문자열이 존재하는지 확인

채점 결과 : 128ms/14184KB
풀이 날짜 : 2022/01/10
*/

public class B5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            sb.append(sb);
            if (sb.indexOf(target) != -1) {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
