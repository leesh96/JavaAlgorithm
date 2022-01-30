package baekjoon.steps.step7;

import java.io.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1316
 * 문제제목 : 그룹 단어 체커
 * 난이도 : 실버 5
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 구현, 문자열
 *
 * 알고리즘 설명
 * 1. 연속된 문자가 아닌경우 이전에 나왔던 문자인지 체크
 * 2. 이전에 나왔던 문자면 그룹단어가 아님
 *
 * 채점 결과 : 176ms/16352KB
 * 풀이 날짜 : 2021/08/15
**/

public class B1316 {
    static final int ALPHA_COUNT = 26;
    static int n;
    static boolean[] alphaCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            alphaCheck = new boolean[ALPHA_COUNT];
            String input = br.readLine().trim();
            char prev = 0;
            boolean isGroup = true;
            for (int j = 0; j < input.length(); j++) {
                char cur = input.charAt(j);
                int idx = cur - 'a';
                if (prev != cur) {
                    if (!alphaCheck[idx]) {
                        alphaCheck[idx] = true;
                        prev = cur;
                    } else {
                        isGroup = false;
                        break;
                    }
                }
            }
            if (isGroup) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
