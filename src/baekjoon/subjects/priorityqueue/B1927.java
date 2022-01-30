package baekjoon.subjects.priorityqueue;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1927
 * 문제제목 : 최소 힙
 * 난이도 : 실버 1
 * 제한사항 : 1초(자바 2초)/128MB
 * 알고리즘 분류 : 우선순위 큐
 *
 * 알고리즘 설명
 * 작은 수가 나오는 우선순위 큐 구현
 *
 * 채점 결과 : 308ms/27664KB
 * 풀이 날짜 : 2021/07/08
**/

public class B1927 {
	static PriorityQueue<Integer> minQ;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		minQ = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				if (minQ.isEmpty()) {
					bw.write("0" + "\n");
				} else {
					bw.write(String.valueOf(minQ.poll()) + "\n");
				}
			} else {
				minQ.offer(input);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
