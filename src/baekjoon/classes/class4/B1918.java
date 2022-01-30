package baekjoon.classes.class4;

import java.io.*;
import java.util.Stack;

/*
플랫폼 : 백준
문제번호 : 1918
문제제목 : 후위 표기식
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : 자료구조, 스택

알고리즘 설명
1. 피연산자인 경우 후위표기식에 추가
2. 여는 괄호인 경우 스택에 push
3. 닫는 괄호인 경우 여는괄호가 나올때까지 스택 pop해서 후위표기식에 추가, 상단 여는 괄호 pop
4. 연산자인 경우 연산자의 우선순위에 따라 낮은 우선순위가 나올 떄 까지 pop해서 후위표기식에 추가
5. 스택에 남은 문자 후위표기식에 추가

채점 결과 : 124ms/14220KB
풀이 날짜 : 2021/10/31
*/

public class B1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if ('A' <= cur && cur <= 'Z') {
                answer.append(cur);
            } else if (cur == '(') {
                stack.push(cur);
            } else if (cur == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    answer.append(stack.pop());
                }
            } else {
                while (!stack.isEmpty() && operatorPriority(stack.peek()) >= operatorPriority(cur)) {
                    answer.append(stack.pop());
                }
                stack.push(cur);
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int operatorPriority(char op) {
        if (op == '(') {
            return 0;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
