package baekjoon.subjects.priorityqueue;

import java.io.*;
import java.util.TreeMap;

/**
 * 플랫폼 : 백준
 * 문제번호 : 7662
 * 문제제목 : 이중 우선순위 큐
 * 난이도 : 골드 5
 * 제한사항 : 6초/256MB
 * 알고리즘 분류 : 우선순위 큐, 트리를 사용한 집합과 맵
 *
 * 알고리즘 설명
 * 트리 맵으로 구현 -> 키 : 숫자, 값 : 갯수
 * 트리 맵은 삽입과 동시에 정렬 발생 (순서가 무시된다.)
 * 트리의 첫번째 값이 최솟값, 마지막 값이 최대값
 *
 * 채점 결과 : 2608ms/306560KB
 * 풀이 날짜 : 2021/07/16
**/

public class B7662 {
    static int c, k;
    static TreeMap<Integer, Integer> heap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = Integer.parseInt(br.readLine());
        for (int t = 0; t < c; t++) {
            k = Integer.parseInt(br.readLine());
            heap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().trim().split(" ");
                String order = input[0];

                if (order.equals("I")) {
                    int num = Integer.parseInt(input[1]);
                    heap.put(num, heap.getOrDefault(num, 0) + 1);
                } else {
                    if (!heap.isEmpty()) {
                        int pos = Integer.parseInt(input[1]);
                        int temp;
                        if (pos == 1) {
                            temp = heap.lastKey();
                        } else {
                            temp = heap.firstKey();
                        }
                        heap.put(temp, heap.get(temp) - 1);
                        if (heap.get(temp) == 0) {
                            heap.remove(temp);
                        }
                    }
                }
            }

            if (heap.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(heap.lastKey() + " " + heap.firstKey() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
