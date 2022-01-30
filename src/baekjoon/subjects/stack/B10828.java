package baekjoon.subjects.stack;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10828
 * 문제제목 : 스택
 * 난이도 : 실버4
 * 제한사항 : 0.5초/256MB
 * 알고리즘 분류 : 스택
 *
 * 알고리즘 설명
 * 스택 구현
 *
 * 채점 결과 : 332ms/20708KB
 * 풀이 날짜 : 2021/07/07
**/

public class B10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> numbers = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			String order = inputs[0];
			
			if (order.equals("push")) {
				int pushNum = Integer.parseInt(inputs[1]);
				numbers.push(pushNum);
			} else if (order.equals("pop")) {
				if (numbers.empty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(numbers.peek() + "\n");
					numbers.pop();
				}
				bw.flush();
			} else if (order.equals("size")) {
				bw.write(String.valueOf(numbers.size()) + "\n");
				bw.flush();
			} else if (order.equals("empty")) {
				if (numbers.empty()) {
					bw.write(String.valueOf(1) + "\n");
				} else {
					bw.write(String.valueOf(0) + "\n");
				}
				bw.flush();
			} else {
				if (numbers.empty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(numbers.peek() + "\n");
				}
				bw.flush();
			}
		}
		
		bw.close();
		br.close();
	}

}
