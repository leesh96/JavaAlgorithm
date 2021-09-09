package baekjoon.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1010
 * 문제제목 : 다리 놓기
 * 난이도 : 실버 5
 * 제한사항 : 0.5초/128MB
 * 알고리즘 분류 : DP, 조합론
 *
 * 알고리즘 설명
 * 1. 오른쪽다리C왼쪽다리를 구하는것이 목적
 * 2. 오른쪽다리 갯수 = 왼쪽다리 갯수이거나 왼쪽다리 갯수가 0이면 1
 *
 * 채점 결과 : 92ms/12804KB
 * 풀이 날짜 : 2021/07/09
**/

public class B1010 {
	static int t, n, m;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for (int k = 1; k <= t; k ++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			dp = new int[m+1][n+1];
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == j || j == 0) {
						dp[i][j] = 1;
						continue;
					}
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
			
			bw.write(String.valueOf(dp[m][n]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
