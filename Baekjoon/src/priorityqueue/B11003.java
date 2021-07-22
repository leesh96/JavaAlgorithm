package priorityqueue;

import java.io.*;
import java.util.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11003
 * 문제제목 : 최솟값 찾기
 * 난이도 : 플래티넘 5
 * 제한사항 : 2.4초(자바 2.6초)/512MB
 * 알고리즘 분류 : 우선순위 큐, 덱
 *
 * 알고리즘 설명
 * 1. 값과 인덱스를 가진 data 클래스 생성
 * 2. 값 입력 받을 때 큐 내부의 입력값보다 큰 값들 제거 (큐에는 최솟값만 남아있음)
 * 3. 큐의 첫 번째 값의 인덱스가 구간 벗어나면 제거
 * 4. 최솟값(큐 첫번째 값) 출력
 * 우선순위 큐 풀이법
 *
 * 채점 결과 : 2408ms/646076KB(덱), 자바는 우선순위 큐 시간초과
 * 풀이 날짜 : 2021/07/8
**/

public class B11003 {
	static int n, l;
	static int[] arr;
	static Deque<data> d;
//	static PriorityQueue<data> queue;
	
	static class data {
		int value;
		int idx;
		
		public data(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		d = new ArrayDeque<>();
//		queue = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int inputValue = Integer.parseInt(st.nextToken());
			while (!d.isEmpty() && d.getLast().value > inputValue) {
				d.removeLast();
			}
			data input = new data(inputValue, i);
			d.addLast(input);
//			queue.add(input);
			if (d.getFirst().idx <= i - l) {
				d.removeFirst();
			}
//			if (i >= l) {
//				while (queue.peek().idx < i - l + 1) {
//					queue.poll();
//				}
//			}
			
			bw.write(d.getFirst().value + " ");
//			bw.write(queue.peek().value + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
