package baekjoon.combinatorics;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 15663
 * 문제제목 : N과 M (9)
 * 난이도 : 실버 2
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 백트래킹
 *
 * 알고리즘 설명
 * 1. N개에서 M개를 뽑아 만든 수열 구하기
 * 2. 중복방지와 사전 순 정렬을 위해 LinkedHashSet 사용
 *
 * 채점 결과 : 324ms/54844KB
 * 풀이 날짜 : 2021/07/09
**/

public class B15663 {
	static int n, m;
	static int[] input, num;
	static boolean[] visit;
	static BufferedWriter bw;
	static LinkedHashSet<String> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		num = new int[m];
		result = new LinkedHashSet<>();
		make(0);
		
		for (String s : result) {
			bw.write(s + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void make(int len) {
		if (len == m) {
			String s = "";
			for (int p : num) {
				s += p + " ";
			}
			result.add(s);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				num[len] = input[i];
				make(len + 1);
				visit[i] = false;
			}
		}
	}
}
