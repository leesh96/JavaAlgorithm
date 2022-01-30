package baekjoon.subjects.setmap;

import java.io.*;
import java.util.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2910
 * 문제제목 : 빈도 정렬
 * 난이도 : 실버 3
 * 제한사항 : 1초/128MB
 * 알고리즘 분류 : 구현, 자료구조, 정렬, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. key의 입력 순서가 필요하기 때문에 LinkedHashMap으로 선언
 * 2. 빈도수를 기준으로 키 리스트 정렬
 * 3. 빈도수 만큼 정렬된 리스트의 키 값 출력
 *
 * 채점 결과 : 192ms/14936KB
 * 풀이 날짜 : 2021/08/12
**/

public class B2910 {
    static int n, c;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });
        for (int k : list) {
            for (int i = 0; i < map.get(k); i++) {
                bw.write(k + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
