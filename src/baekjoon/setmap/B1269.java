package baekjoon.setmap;

import java.io.*;
import java.util.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1269
 * 문제제목 : 대칭 차집합
 * 난이도 : 실버 3
 * 제한사항 : 2초/256MB
 * 알고리즘 분류 : 자료구조, 트리를 사용한 집합과 맵, 해시를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. Map에 a와 b집합의 숫자를 갯수와 함께 담는다.
 * 2. 갯수가 1보다 크다면 교집합에 있는 원소
 * 3. 갯수가 1인 Key만 count
 *
 * 채점 결과 : 860ms/87220KB
 * 풀이 날짜 : 2021/08/12
**/

public class B1269 {
    static int n, m;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> cur = it.next();
            if (cur.getValue() == 1) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
