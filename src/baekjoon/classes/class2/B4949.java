package baekjoon.classes.class2;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 4949
 * 문제제목 : 균형잡힌 세상
 * 난이도 : 실버 4
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 문자열, 스택
 *
 * 알고리즘 설명
 * 스택 구현
 *
 * 채점 결과 : 244ms/19280KB
 * 풀이 날짜 : 2021/07/22
**/

public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') {
                    stack.add(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty() || !isCorrect) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
