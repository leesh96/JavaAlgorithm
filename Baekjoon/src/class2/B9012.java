package class2;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 9012
 * 문제제목 : 괄호
 * 난이도 : 실버 4
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 스택, 문자열
 *
 * 알고리즘 설명
 * 스택을 활용한 올바른 괄호열 문제
 *
 * 채점 결과 : 92ms/11728KB
 * 풀이 날짜 : 2021/07/18
**/

public class B9012 {
    static int n;
    static char[] input;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().toCharArray();
            stack = new Stack<>();
            boolean isValid = true;
            for (int j = 0; j < input.length; j++) {
                if (input[j] == '(') {
                    stack.add(input[j]);
                } else {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (!isValid || !stack.isEmpty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
