package baekjoon.subjects.setmap;

import java.io.*;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 플랫폼 : 백준
 * 문제번호 : 4358
 * 문제제목 : 생태학
 * 난이도 : 골드 5
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 트리를 이용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. 트리 맵 선언 -> key : 나무 이름, value : 수량
 * 2. 입력 받을 때 나무의 전체 수량을 알아야한다.
 * 3. 트리 맵의 각 엔트리(나무 - 수량)에 대해서 분포도 계산 후 출력
 *
 * 채점 결과 : 828ms/121840KB
 * 풀이 날짜 : 2021/07/08
**/

public class B4358 {
	static TreeMap<String, Double> trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		trees = new TreeMap<String, Double>();
		double count = 0.0;
		while (true) {
			String input = br.readLine();
			if (input.equals("")) {
				break;
			}
			
			trees.put(input, trees.getOrDefault(input, 0.0) + 1.0);
			count++;
		}
		
		for (Entry<String, Double> e : trees.entrySet()) {
			double rate = (e.getValue() * 100) / count;
			
			bw.write(e.getKey() + " " + String.format("%.4f", rate) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
