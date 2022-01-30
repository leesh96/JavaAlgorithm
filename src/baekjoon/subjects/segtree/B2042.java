package baekjoon.subjects.segtree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2042
 * 문제제목 : 구간 합 구하기
 * 난이도 : 골드 1
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 세그먼트 트리
 *
 * 알고리즘 설명
 * 세그먼트 트리 구현
 *
 * 채점 결과 : 460ms/101492KB
 * 풀이 날짜 : 2021/07/08
**/

public class B2042 {
	static int n, m, k;
	static long[] arr;
	static long[] segTree;
	static int segN;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		for (segN = 1; segN < n; segN *= 2);
		
		segTree = new long[(int)(1 * Math.pow(2, (int)Math.ceil(Math.log10(segN) / Math.log10(2)) + 1))];
		
		init(0, n - 1, 1);
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (order == 1) {
				long diff = c - arr[b - 1];
				update(0, n - 1, 1, b - 1, diff);
			} else {
				bw.write(sum(0, n - 1, 1, b - 1, c - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long init(int start, int end, int node) {
		if (start == end) {
			return segTree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			return segTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
	}
	
	static void update(int start, int end, int node, int idx, long diff) {
		if (idx < start || idx > end) {
			return;
		}
		
		segTree[node] += diff;
		
		if (start == end) {
			arr[idx] = segTree[node];
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
	}
	
	static long sum(int start, int end, int node, int left, long right) {
		if (left > end || right < start) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return segTree[node];
		}
		
		int mid = (start + end) / 2;
		
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
}
