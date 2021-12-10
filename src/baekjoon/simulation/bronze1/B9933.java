package baekjoon.simulation.bronze1;

import java.io.*;
import java.util.HashSet;

/*
플랫폼 : 백준
문제번호 : 9933
문제제목 : 민균이의 비밀번호
난이도 : 브론즈 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. set 자료구조 선언
2. 입력받은 비밀번호를 뒤집은 문자열이 set에 존재하거나, 입력과 같으면 해당 문자열이 정답
3. 문자열 길이와 중간 글씨 출력

채점 결과 : 140ms/14384KB
풀이 날짜 : 2021/12/10
*/

public class B9933 {
    static int n;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String reverse = new StringBuilder(input).reverse().toString();

            if (flag) {
                continue;
            }

            if (set.contains(reverse) || input.equals(reverse)) {
                bw.write(String.format("%d %c", input.length(), input.charAt(input.length() / 2)));
                flag = true;
            } else {
                set.add(input);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
