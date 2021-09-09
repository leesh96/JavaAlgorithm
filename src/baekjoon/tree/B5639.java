package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 플랫폼 : 백준
 * 문제번호 : 5639
 * 문제제목 : 이진 검색 트리
 * 난이도 : 실버 1
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 트리, 재귀, 그래프 탐색, 깊이 우선 탐색
 *
 * 알고리즘 설명
 * 1. 이진 검색 트리의 후위 순회 : 왼 -> 오 -> 루트
 * 2. 이진 검색 트리의 전위 순회 : 루트 -> 왼 -> 오
 * 3. 전위 순회 결과를 1차원 배열로 입력받음
 * 4. 재귀 함수 호출
 *
 * 채점 결과 : 624ms/34040KB
 * 풀이 날짜 : 2021/07/07
**/

public class B5639 {
	static int[] a = new int[10000];
	static int idx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		idx = 0;
		while ((input = br.readLine()) != "") {
			a[idx] = Integer.parseInt(input.trim());
			idx++;
		}
		
		recur(0, idx - 1);
	}
	
	static void recur(int s, int e) {
		if (s == e) {
			System.out.println(a[s]);
			return;
		} else if (s > e) {
			return;
		} else {
			int where = s + 1;
			while (where <= e) {
				if (a[where] > a[s]) break;
				else where++;
			}
			recur(s + 1, where - 1);
			recur(where, e);
			System.out.println(a[s]);
		}
	}
}
