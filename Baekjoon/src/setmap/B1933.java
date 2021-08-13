package setmap;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1933
 * 문제제목 : 스카이라인
 * 난이도 : 골드 2
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 자료구조, 스위핑, 우선순위 큐, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 1. 우선순위 큐에 빌딩 정보 담기 -> 왼쪽 x, 높이 / 오른쪽 x, -높이
 * 2. 우선순위 큐는 x좌표 오름차순, 빌딩 높이 내림차순 (x좌표가 같은 경우 높은 빌딩 고려)
 * 3. 우선순위 큐에서 빌딩 정보 뽑으면서 빌딩이 시작하는 자리면 map에 빌딩 수 + 1, 빌딩이 끝나는 자리면 map에서 빌딩 수 - 1
 * 4. x좌표에 따른 빌딩 높이 정보 리스트 선언
 * 5. 리스트에 큐에서 뽑은 x좌표와 현재 map의 가장 높은 높이 저장 (TreeMap -> 높이 내림차순)
 * 6. 맵이 비어있다면 (빌딩 수 1개면 remove) x좌표와 0 저장
 * 7. 리스트 돌면서 높이가 변했으면 x좌표와 높이 출력
 *
 * 채점 결과 : 992ms/72228KB
 * 풀이 날짜 : 2021/08/13
**/

public class B1933 {
    static int n;
    static PriorityQueue<building> queue;
    static TreeMap<Integer, Integer> map;
    static ArrayList<building> result;

    static class building {
        int x, height;

        public building(int x, int h) {
            this.x = x;
            this.height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1.x == o2.x) {
                return Integer.compare(o2.height, o1.height);
            }
            return o1.x - o2.x;
        }));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            queue.offer(new building(left, height));
            queue.offer(new building(right, -height));
        }
        map = new TreeMap<>(((o1, o2) -> o2 - o1));
        result = new ArrayList<>();
        while (!queue.isEmpty()) {
            building cur = queue.poll();
            if (cur.height > 0) {
                map.put(cur.height, map.getOrDefault(cur.height, 0) + 1);
            } else {
                int value = map.get(-cur.height);
                if (value == 1) {
                    map.remove(-cur.height);
                } else {
                    map.replace(-cur.height, value - 1);
                }
            }

            if (map.size() == 0) {
                result.add(new building(cur.x, 0));
                continue;
            }

            result.add(new building(cur.x, map.firstKey()));
        }
        building last = result.get(0);
        bw.write(last.x + " " + last.height + " ");
        for (int i = 1; i < result.size(); i++) {
            building cur = result.get(i);
            if (last.height != cur.height) {
                bw.write(cur.x + " " + cur.height + " ");
                last = cur;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
