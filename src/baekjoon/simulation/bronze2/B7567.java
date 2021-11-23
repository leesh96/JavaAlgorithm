package baekjoon.simulation.bronze2;

import java.io.*;
import java.util.Stack;

/*
플랫폼 : 백준
문제번호 : 7567
문제제목 : 그릇
난이도 : 브론즈 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 스택에 넣을 때, 스택 탑이 같은 모양이면 +5, 다른 모양이면 + 10

채점 결과 : 128ms/14324KB
풀이 날짜 : 2021/11/23
*/

public class B7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (char c : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                answer += 10;
            } else {
                if (stack.peek() == c) {
                    answer += 5;
                } else {
                    answer += 10;
                }
                stack.push(c);
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
