package baekjoon.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 플랫폼 : 백준
 * 문제번호 : 6416
 * 문제제목 : 트리인가?
 * 난이도 : 골드 5
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 트리
 *
 * 알고리즘 설명
 * 1. 인접 정점의 수를 담는 HashMap 선언
 * 2. HashMap의 모든 Key(정점)에 대해서 (value는 들어오는 간선)
 * 3. 들어오는 간선이 0개 이면 루트
 * 4. 들어오는 간선이 1개보다 많으면 트리 아님
 * 5. 빈 트리도 트리
 * 6. 루트 1개, edge의 갯수가 정점-1개, 들어오는 간선이 1개보다 많은 정점이 없으면 트리
 *
 * 채점 결과 : 124ms/13048KB
 * 풀이 날짜 : 2021/07/08
**/

public class B6416 {
	static HashMap<Integer, Integer> vertex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseCnt = 1;
		
		while (true) {
			vertex = new HashMap<>();
			int edge = 0;
			
			while (true) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				if (start == -1 && end == -1) {
					sc.close();
					return;
				}
				else if (start == 0 && end == 0) break;
				
				vertex.put(start, vertex.getOrDefault(start, 0));
				vertex.put(end, vertex.getOrDefault(end, 0) + 1);
				
				edge++;
			}
			
			int root = 0;
			boolean flag = true;
			
			Iterator<Integer> key = vertex.keySet().iterator();
			
			while (key.hasNext()) {
				int node = key.next();
				
				if (vertex.get(node) == 0) {
					root++;
				} else if (vertex.get(node) > 1) {
					flag = false;
					break;
				}
			}
			
			if (vertex.size() == 0) {
				System.out.println("Case " + caseCnt + " is a baekjoon.tree.");
			} else if (flag && root == 1 && edge == vertex.size() - 1) {
				System.out.println("Case " + caseCnt + " is a baekjoon.tree.");
			} else {
				System.out.println("Case " + caseCnt + " is not a baekjoon.tree.");
			}
			
			caseCnt++;
		}
	}
}
