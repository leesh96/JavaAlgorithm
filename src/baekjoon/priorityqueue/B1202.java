package baekjoon.priorityqueue;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1202
 * 문제제목 : 보석 도둑
 * 난이도 : 골드 2
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 우선순위 큐, 정렬, 그리디
 *
 * 알고리즘 설명
 * 1. 보석의 무게와 가치를 저장할 클래스 선언
 * 2. 보석의 정보 입력받고 무게순으로 정렬 (오름차순)
 * 3. 가방의 정보 입력받고 무게순으로 정렬 (오름차순)
 * 4. 보석의 가치를 담을 우선순위 큐(최대 힙) 선언
 * 5. 가장 작은 가방부터 가방에 들어갈 수 있는 보석의 가치를 우선순위 큐에 담는다. (그리디 생각)
 * 6. 다 담았다면 가장 높은 가치의 보석을 결과값에 더한다. (우선순위 큐)
 *
 * 채점 결과 : 1876ms/133688KB
 * 풀이 날짜 : 2021/07/08
**/

public class B1202 {
	static class shine {
		int weight;
		int price;
		
		public shine(int w, int p) {
			this.weight = w;
			this.price = p;
		}
	}
	
	static int n, k;
	static long result;
	static int[] bags;
	static shine[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new shine[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new shine(w, p);
		}
		
		bags = new int[k];
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1.weight - o2.weight);
		Arrays.sort(bags);
		
		result = 0;
		int posShine = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for (int i = 0; i < k; i++) {
			int curBag = bags[i];
			while (posShine < n && arr[posShine].weight <= curBag) {
				q.offer(arr[posShine].price);
				posShine++;
			}
			if (!q.isEmpty()) {
				result += q.poll();
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
