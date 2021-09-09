package baekjoon.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11050
 * 문제제목 : 이항 계수 1
 * 난이도 : 브론즈 1
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 조합론
 *
 * 알고리즘 설명
 * 1. 이항 계수 : nCr;
 *
 * 채점 결과 : 84ms/11580KB
 * 풀이 날짜 : 2021/07/09
**/

public class B11050 {
	static int n, k;
	static int[] fact;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if (k == 0) {
			bw.write(String.valueOf(1) );
		} else {
			fact = new int[n + 1];
			fact[0] = 1;
			for (int i = 1; i <= n; i++) {
				fact[i] = fact[i-1] * i;
			}
			int result = (fact[n] / fact[n-k]) / fact[k];
			bw.write(String.valueOf(result));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
