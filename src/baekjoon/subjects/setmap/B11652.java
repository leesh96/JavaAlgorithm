package baekjoon.subjects.setmap;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 플랫폼 : 백준
 * 문제번호 : 11652
 * 문제제목 : 카드
 * 난이도 : 실버 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 자료구조, 정렬, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. 트리 맵에 숫자 - 개수 엔트리 저장
 * 2. 트리 맵 이므로 작은 숫자부터 정렬
 * 3. 트리 맵의 엔트리를 돌면서 value가 가장 큰 숫자 찾기
 * 4. value가 같은 숫자가 있다면 작은 수가 답 -> 트리 맵으로 정렬되어 있기 때문
 *
 * 채점 결과 : 404ms/32816KB
 * 풀이 날짜 : 2021/08/12
**/

public class B11652 {
    static int n;
    static TreeMap<Long, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        long key = 0;
        Iterator<Map.Entry<Long, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Integer> cur = it.next();
            if (cur.getValue() > count) {
                count = cur.getValue();
                key = cur.getKey();
            }
        }
        bw.write(key + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
