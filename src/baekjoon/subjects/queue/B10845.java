package baekjoon.subjects.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 10845
 * 문제제목 : 큐
 * 난이도 : 실버 4
 * 제한사항 : 0.5초/256MB
 * 알고리즘 분류 : 큐
 *
 * 알고리즘 설명
 * 큐 구현
 *
 * 채점 결과 : 316ms/21936KB
 * 풀이 날짜 : 2021/07/07
**/

public class B10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> numbers = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			String order = inputs[0];
			
			if (order.equals("push")) {
				int pushNum = Integer.parseInt(inputs[1]);
				numbers.add(pushNum);
			} else if (order.equals("pop")) {
				if (numbers.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(numbers.poll() + "\n");
				}
				bw.flush();
			} else if (order.equals("size")) {
				bw.write(numbers.size() + "\n");
				bw.flush();
			} else if (order.equals("empty")) {
				if (numbers.isEmpty()) {
					bw.write(String.valueOf(1) + "\n");
				} else {
					bw.write(String.valueOf(0) + "\n");
				}
				bw.flush();
			} else if (order.equals("front")) {
				if (numbers.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(numbers.peek() + "\n");
				}
				bw.flush();
			} else if (order.equals("back")) {
				if (numbers.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(numbers.toArray()[numbers.size() - 1] + "\n");
				}
				bw.flush();
			}
		}
		
		bw.close();
		br.close();
	}
}
