package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1213
문제제목 : 팰린드롬 만들기
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 구현, 문자열, 그리디 알고리즘

알고리즘 설명
1. 입력받은 문자열의 알파벳 수 세기
2. 각 알파벳 수가 짝수여야 팰린드롬을 만들 수 있음
3. 단, 홀수인 알파벳이 1개이고 전체 길이가 홀수이면 팰린드롬 가능(가운데에 넣으면 된다.)
4. 2, 3 조건 검증 후 출력

채점 결과 : 124ms/14248KB
풀이 날짜 : 2022/01/17
*/

public class B1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - 'A';
            count[cur]++;
        }

        int middle = 0;
        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (oddCnt > 1) {
                break;
            }
            if (count[i] % 2 != 0) {
                middle = i;
                oddCnt++;
            }
        }

        if (oddCnt > 1 || (input.length() % 2 == 0 && oddCnt == 1)) {
            bw.write("I'm Sorry Hansoo");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    sb.append((char)(i + 'A'));
                }
            }
            bw.write(sb.toString());
            if (oddCnt == 1) {
                bw.write((char)(middle + 'A'));
            }
            bw.write(sb.reverse().toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
