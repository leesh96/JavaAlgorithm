package baekjoon.subjects.priorityqueue;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1655
 * 문제제목 : 가운데를 말해요
 * 난이도 : 골드 2
 * 제한사항 : 0.1초/128MB
 * 알고리즘 분류 : 우선순위 큐
 *
 * 알고리즘 설명
 * 1. min큐와 max큐를 마주보게 배치 -> min큐는 최소 힙, max큐는 최대 힙
 * 2. 값은 항상 max큐에서만 나오도록 구현
 * 3. 짝수 차례에선 max큐, 홀수 차례에선 min큐에 넣는다.
 * 4. 값 삽입 후에 min큐의 값 < max큐의 값이면 두 값을 서로 바꿔준다.
 * 5. max큐의 값 꺼내기 (max큐에는 항상 숫자가 존재)
 *
 * 채점 결과 : 636ms/47104KB
 * 풀이 날짜 : 2021/07/07
**/

public class B1655 {
	static int n;
	static PriorityQueue<Integer> minQueue, maxQueue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		minQueue = new PriorityQueue<>();
		maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (i % 2 == 0) {
				maxQueue.add(input);
			} else {
				minQueue.add(input);
			}
			
			if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if (minQueue.peek() < maxQueue.peek()) {
					int temp = maxQueue.poll();
					maxQueue.add(minQueue.poll());
					minQueue.add(temp);
				}
			}
			
			bw.write(maxQueue.peek() + "\n");	
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
