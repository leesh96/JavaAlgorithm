package baekjoon.simulation.silver4;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2607
문제제목 : 비슷한 단어
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 첫 번째 문자열과 문자들의 등장 횟수를 센다.
2. 나머지 문자열에서 첫 번째 문자열과 동일하게 등장하는 문자 수 세기
3. 첫 번째 문자열과 다른 문자열의 길이가 1차이 나고 첫 번째 문자열에서 문자를 빼거나 추가해서 만들 수 있으면 비슷한 문자열
4. 첫 번째 문자열과 다른 문자열의 길이가 같고 문자 하나를 바꾸거나 같은 문자열이라면 비슷한 문자열

채점 결과 : 128ms/14040KB
풀이 날짜 : 2022/01/24
*/

public class B2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String origin = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < origin.length(); i++) {
            alpha[origin.charAt(i) - 'A']++;
        }

        int answer = 0;
        for (int i = 1; i < n; i++) {
            String input = br.readLine();
            int[] copy = alpha.clone();
            int count = 0;

            for (int j = 0; j < input.length(); j++) {
                int cur = input.charAt(j) - 'A';
                if (copy[cur] > 0) {
                    count++;
                    copy[cur]--;
                }
            }

            if (input.length() == origin.length() - 1 && count == input.length()) {
                answer++;
            } else if (input.length() == origin.length() + 1 && count == origin.length()) {
                answer++;
            } else if (input.length() == origin.length()) {
                if (count == origin.length() - 1 || count == origin.length()) {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
