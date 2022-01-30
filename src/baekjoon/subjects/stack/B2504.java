package baekjoon.subjects.stack;

import java.io.*;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2504
 * 문제제목 : 괄호의 값
 * 난이도 : 실버 2
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 스택, 구현, 재귀?
 *
 * 알고리즘 설명
 * 1. 여는 괄호 나오면 현재 값 *=
 * 2. 닫는 괄호 나오면 올바른 괄호열인지 확인
 * 3. 괄호열의 직전 값이 여는 괄호였다면 결과 값 += 현재 값
 * 4. 올바른 괄호열이라면 괄호 스택 pop, 현재 값 /=
 *
 * 채점 결과 : 76ms/11752KB
 * 풀이 날짜 : 2021/07/08
**/

public class B2504 {
	static Stack<String> bracket;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().trim().split("");
		
		boolean flag = true;
		
		if (input.length % 2 == 1) {
			flag = false;
		}
		
		result = 0;
		bracket = new Stack<>();
		
		int current = 1;
		for (int i = 0; i < input.length; i++) {
			if (!flag) break;
			
			if (input[i].equals("(")) {
				bracket.add(input[i]);
				current *= 2;
			} else if (input[i].equals("[")) {
				bracket.add(input[i]);
				current *= 3;
			} else if (input[i].equals(")")) {
				if (bracket.isEmpty() || !bracket.peek().equals("(")) {
					flag = false;
					break;
				}
				if (input[i-1].equals("(")) {
					result += current;
				}
				bracket.pop();
				current /= 2;
			} else if (input[i].equals("]")) {
				if (bracket.isEmpty() || !bracket.peek().equals("[")) {
					flag = false;
					break;
				}
				if (input[i-1].equals("[")) {
					result += current;
				}
				bracket.pop();
				current /= 3;
			}
		}
		
		if (!flag) result = 0;
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
