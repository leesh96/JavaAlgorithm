package numbers;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2960
 * 문제제목 : 에라토스테네스의 체
 * 난이도 : 실버 4
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 정수론, 소수 판정, 에라토스테네스의 체
 *
 * 알고리즘 설명
 * 에라토스테네스의 체로 소수 구할 때, n번째로 걸러진 수 찾기
 *
 * 채점 결과 : 76ms/11560KB
 * 풀이 날짜 : 2021/07/09
**/

public class B2960 {
	static int n, k;
	static boolean[] che;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		che = new boolean[n + 1];
		int idx = 0;
		int current = 0;
		for (int i = 2; i <= n; i++) {
			if (che[i]) continue;
			
			if (!che[i]) {
				che[i] = true;
				idx++;
				current = i;
				if (idx == k) {
					bw.write(String.valueOf(current));
					break;
				}
			}
			
			for (int j = i + i; j <= n; j += i) {
				if (!che[j]) {
					che[j] = true;
					idx++;
					current = j;
					if (idx == k) {
						bw.write(String.valueOf(current));
						break;
					}
				}
			}
			
			if (idx == k) {
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
