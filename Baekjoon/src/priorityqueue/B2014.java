package priorityqueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2014
 * 문제제목 : 소수의 곱
 * 난이도 : 골드 1
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 우선순위 큐
 *
 * 알고리즘 설명
 * 1. 소수 입력 받음
 * 2. 입력받은 소수 우선순위 큐(최소 힙)에 넣음
 * 3. 하나씩 꺼내면서 모든 소수랑 곱하고 큐에 넣는다.
 * 4. 이때 값이 최대범위를 넘어가는 경우 큐에 넣지 않음
 * 5. 중복 제거를 위해 큐에서 꺼낸 값이 곱하는 소수로 나누어 떨어지는 경우 다음 소수 꺼내기
 * 6. n번 반복
 *
 * 채점 결과 : 284ms/32428KB
 * 풀이 날짜 : 2021/07/08
**/

public class B2014 {
	static long[] sosu;
	static PriorityQueue<Long> q;
	static int k, n;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		sosu = new long[k];
		q = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sosu[i] = Long.parseLong(st.nextToken());
			q.offer(sosu[i]);
		}
		
		result = 0;
		
		while (n > 0) {
			result = q.poll();
			
			for (int i = 0; i < k; i++) {
				long temp = result * sosu[i];
				if (temp >= (long) Math.pow(2, 30)) break;
				
				q.offer(temp);
				
				if (result % sosu[i] == 0) break;
			}
			
			n--;
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
