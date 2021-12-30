package baekjoon.simulation.silver5;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11576
문제제목 : Base Conversion
난이도 : 실버 5
제한사항 : 2초/256MB
알고리즘 분류 : 수학, 구현, 정수론

알고리즘 설명
1. 스택 자료구조 사용 수동 변환
2. a진수 to 10진수, 10진수 to b진수

채점 결과 : 132ms/14416KB
풀이 날짜 : 2021/12/30
*/

public class B11576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int length = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < length; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int decimal = 0;
        int mul = 1;
        while (!nums.isEmpty()) {
            int cur = nums.pop();
            decimal += cur * mul;
            mul *= a;
        }

        nums = new Stack<>();
        while (decimal > 0) {
            int cur = decimal % b;
            nums.add(cur);
            decimal /= b;
        }

        while (!nums.isEmpty()) {
            bw.write(nums.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
