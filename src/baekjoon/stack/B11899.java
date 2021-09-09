package baekjoon.stack;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11899
 * 문제제목 : 괄호 끼워넣기
 * 난이도 : 실버 4
 * 제한사항 : 1초/32MB
 * 알고리즘 분류 : 스택, 문자열
 *
 * 알고리즘 설명
 * 1. 입력받은 괄호열의 한 괄호씩 탐색
 * 2. 여는 괄호이면 스택에 삽입
 * 3. 닫는 괄호가 나오면 스택이 비어있거나 스택의 탑이 여는 괄호가 아닌 경우 필요한 괄호 + 1
 * 4. 여는 괄호가 스택 탑에 있으면 스택 pop
 * 5. 입력 괄호열 탐색 끝났는데 스택에 여는 괄호 남아있다면 사이즈 만큼 필요한 괄호 추가
 *
 * 채점 결과 : 84ms/11732KB
 * 풀이 날짜 : 2021/07/15
**/

public class B11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split("");

        int result = 0;
        Stack<String> bracket = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                bracket.add(input[i]);
            } else {
                if (bracket.isEmpty() || !bracket.peek().equals("(")) {
                    result++;
                } else {
                    bracket.pop();
                }
            }
        }

        if (!bracket.isEmpty()) {
            result += bracket.size();
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
