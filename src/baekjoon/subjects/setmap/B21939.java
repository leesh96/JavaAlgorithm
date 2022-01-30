package baekjoon.subjects.setmap;

import java.io.*;
import java.util.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 21939
 * 문제제목 : 문제 추천 시스템 Version 1
 * 난이도 : 골드 4
 * 제한사항 : 1초/512MB
 * 알고리즘 분류 : 자료구조, 우선순위 큐, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. TreeSet을 사용하여 문제 난이도, 번호 순(난이도가 같을 때) 정렬될 수 있도록 삽입 -> Comparator 구현
 * 2. 삭제 시 올바른 객체 삭제를 위해 문제 번호 - 난이도 엔트리의 Map 구현
 * 3. 문제 추천 시 TreeSet의 첫번째 객체가 쉬운 문제, 마지막 객체가 어려운 문제
 *
 * 채점 결과 : 700ms/55532KB
 * 풀이 날짜 : 2021/08/13
**/

public class B21939 {
    static int n, m;
    static TreeSet<problem> set;
    static HashMap<Integer, Integer> map;

    static class problem {
        int id, difficulty;

        public problem(int id, int d) {
            this.id = id;
            this.difficulty = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        set = new TreeSet<>((o1, o2) -> {
            if (o1.difficulty > o2.difficulty) {
                return 1;
            } else if (o1.difficulty < o2.difficulty) {
                return -1;
            } else {
                return Integer.compare(o1.id, o2.id);
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pID = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            set.add(new problem(pID, diff));
            map.put(pID, diff);
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().trim().split(" ");
            String order = input[0];
            if (order.equals("add")) {
                int pID = Integer.parseInt(input[1]);
                int diff = Integer.parseInt(input[2]);
                set.add(new problem(pID, diff));
                map.put(pID, diff);
            } else if (order.equals("recommend")) {
                int type = Integer.parseInt(input[1]);
                if (type == 1) {
                    bw.write(set.last().id + "\n");
                } else {
                    bw.write(set.first().id + "\n");
                }
            } else if (order.equals("solved")) {
                int pID = Integer.parseInt(input[1]);
                set.remove(new problem(pID, map.get(pID)));
                map.remove(pID);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
