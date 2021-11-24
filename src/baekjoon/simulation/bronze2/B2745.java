package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2745
문제제목 : 진법 변환
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현, 문자열

알고리즘 설명
1. 알파벳 진법 수를 숫자로 바꾸는 식 = char cur - 'A' + 10
2. 문자열 끝에서 부터 역방향으로 진수 곱해서 결과 도출
3. 10억 이하이므로 int형

채점 결과 : 136ms/14368KB
풀이 날짜 : 2021/11/24
*/

public class B2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = st.nextToken();
        int radix = Integer.parseInt(st.nextToken());
        int idx = 1;
        int answer = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char cur = number.charAt(i);
            if (cur >= '0' && cur <= '9') {
                answer += (cur - '0') * idx;
            } else {
                answer += (cur - 'A' + 10) * idx;
            }
            idx *= radix;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
