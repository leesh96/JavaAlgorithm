package class2;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10773
 * 문제제목 : 제로
 * 난이도 : 실버 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 문자열, 스택
 *
 * 알고리즘 설명
 * 스택 구현
 *
 * 채점 결과 : 316ms/23760KB
 * 풀이 날짜 : 2021/07/22
**/

public class B10773 {
    static int k;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else {
                stack.add(n);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
