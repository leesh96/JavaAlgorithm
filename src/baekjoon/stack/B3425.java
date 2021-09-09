package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 플랫폼 : 백준
 * 문제번호 : 3425
 * 문제제목 : 고스택
 * 난이도 : 골드 3
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현, 스택
 *
 * 알고리즘 설명
 * 1. 스택 자료구조 사용
 * 2. 문제 조건에 맞게 구현
 *
 * 채점 결과 : 628ms/29744KB
 * 풀이 날짜 : 2021/07/05
**/

public class B3425 {
	static int numidx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		Stack<Long> numbers = new Stack<>();
		ArrayList<String> orders = new ArrayList<>();
		Long[] numOrders = new Long[100001];
		
		numidx = 0;
		
		while(true) {
			String[] input = br.readLine().split(" ");
			
			if(input[0].equals("QUIT")) {
				break;
			} 
			
			if(input[0].equals("END")) {
				int n = Integer.parseInt(br.readLine());
				for(int i = 0; i < n; i++) {
					numidx = 0;
					numbers.clear();
					numbers.add(Long.parseLong(br.readLine()));
					
					boolean isError = false;
					
					for(int j = 0; j < orders.size(); j++) {
						String curOrder = orders.get(j);
						
						if(curOrder.equals("NUM")) {
							numbers.add(numOrders[numidx++]);
						} else if(curOrder.equals("POP")) {
							if(numbers.empty()) {
								isError = true;
								break;
							}
							numbers.pop();
						} else if(curOrder.equals("INV")) {
							if(numbers.empty()) {
								isError = true;
								break;
							}
							long a = numbers.peek();
							numbers.pop();
							numbers.add(-a);
						} else if(curOrder.equals("DUP")) {
							if(numbers.empty()) {
								isError = true;
								break;
							}
							long a = numbers.peek();
							numbers.add(a);
						} else if(curOrder.equals("SWP")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							numbers.add(top);
							numbers.add(second);
						} else if(curOrder.equals("ADD")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							long result = second + top;
							
							if(Math.abs(result) > 1000000000) {
								isError = true;
								break;
							} else {
								numbers.add(result);
							}
						} else if(curOrder.equals("SUB")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							long result = second - top;
							
							if(Math.abs(result) > 1000000000) {
								isError = true;
								break;
							} else {
								numbers.add(result);
							}
						} else if(curOrder.equals("MUL")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							long result = second * top;
							
							if(Math.abs(result) > 1000000000) {
								isError = true;
								break;
							} else {
								numbers.add(result);
							}
						} else if(curOrder.equals("DIV")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							if(top == 0) {
								isError = true;
								break;
							}
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							
							int minusCnt = 0;
							if(top < 0) {
								minusCnt++;
							}
							if(second < 0) {
								minusCnt++;
							}
							
							long result = Math.abs(second) / Math.abs(top);
							
							if(minusCnt == 1) {
								result = -result;
							}
							
							numbers.add(result);
						} else if(curOrder.equals("MOD")) {
							if(numbers.size() < 2) {
								isError = true;
								break;
							}
							long top = numbers.peek();
							if(top == 0) {
								isError = true;
								break;
							}
							numbers.pop();
							long second = numbers.peek();
							numbers.pop();
							
							long result = Math.abs(second) % Math.abs(top);
							
							if(second < 0) {
								result = -result;
							}
							
							numbers.add(result);
						}
					}
					
					if(isError || numbers.size() > 1 || numbers.size() < 1) {
						System.out.println("ERROR");
					} else {
						System.out.printf("%d\n", numbers.peek());
					}
				}
			}
			else if(input[0].equals("")) {
				orders.clear();
				numbers.clear();
				numidx = 0;
				System.out.println();
			}
			else {
				orders.add(input[0]);
				
				if (input[0].equals("NUM")) {
					numOrders[numidx++] = Long.parseLong(input[1]);
				}
			}
		}
		br.close();
	}
}
