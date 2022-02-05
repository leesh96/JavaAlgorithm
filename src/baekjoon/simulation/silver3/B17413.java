package baekjoon.simulation.silver3;

import java.io.*;
import java.util.Stack;

/*
플랫폼 : 백준
문제번호 : 17413
문제제목 : 단어 뒤집기 2
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 자료 구조, 문자열, 스택

알고리즘 설명
1. 스택 활용
2. 조건에 맞게 넣어준다.

채점 결과 : 248ms/21792KB
풀이 날짜 : 2022/02/05
*/

public class B17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tag = false;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (cur == '<') {
                tag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(cur);
            } else if (cur == '>') {
                tag = false;
                sb.append(cur);
            } else if (cur == ' ') {
                if (!tag) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(cur);
            } else {
                if (tag) {
                    sb.append(cur);
                } else {
                    stack.add(cur);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
